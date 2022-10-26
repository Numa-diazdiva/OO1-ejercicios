package test.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.PoliticaDeCancelacion;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.PoliticaEstricta;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.Propiedad;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.Sistema;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.Usuario;

public class SistemaTest {
	
	private Sistema sistema;
	private Propiedad prop1;
	private Usuario usr1;
	private PoliticaDeCancelacion politica;
	
	@BeforeEach
	void setUp() {
		this.sistema = new Sistema();
		this.usr1 = new  Usuario("Malena", "Avellaneda 1456", 25777777);
		this.politica = new PoliticaEstricta();
		this.prop1 = new Propiedad("Cabaña 2", "Av 12 1678", 1000, usr1, politica);
	}
	
	
	@Test
	void testRegistrarPropiedad() {
		assertTrue(this.sistema.registrarPropiedad(prop1, usr1));
		assertFalse(this.sistema.registrarPropiedad(prop1, usr1));
	}
	
	@Test
	void testRegistrarUsuario() {
		assertTrue(this.sistema.registrarUsuario(usr1));
		assertFalse(this.sistema.registrarUsuario(usr1));
	}
	
	@Test
	void testBuscarPropiedadesEnAlquiler() {
		this.sistema.registrarPropiedad(prop1, usr1);
		Propiedad prop2 = new Propiedad("Asd", "Ave1234", 500, usr1, politica);
		this.sistema.registrarPropiedad(prop2, usr1);
		LocalDate from = LocalDate.of(2022, 10, 10);
		LocalDate to = LocalDate.of(2022, 10, 20);
		List<Propiedad> disponibles = this.sistema.buscarPropiedadesEnAlquiler(from, to);
		assertTrue(disponibles.contains(prop1) && disponibles.contains(prop2));
		prop2.reservar(LocalDate.of(2022, 10, 15), LocalDate.of(2022, 10, 18), usr1);
		assertFalse(this.sistema.buscarPropiedadesEnAlquiler(from, to).contains(prop2));
	}
	
}
