package test.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.PoliticaDeCancelacion;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.PoliticaEstricta;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.PoliticaModerada;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.Propiedad;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.Reserva;
import main.java.oo1.ej16.ejercicio16_politicasDeCancelacion.Usuario;


public class ReservaTest {
	private Reserva reserva;
	private Usuario usuario;
	private Propiedad prop;
	LocalDate from, to;
	
	@BeforeEach
	void setUp() {
		this.usuario = new Usuario("Pablo", "asd", 38123);
		this.prop = new Propiedad("nombre", "asd", 1000, usuario, new PoliticaModerada());
		from = LocalDate.of(2022, 10, 10);
		to = LocalDate.of(2022,10,20);
		this.reserva = new Reserva(usuario, prop, from, to);
	}
	@Test
	void testTiempoRestanteParaIniciar() {
		LocalDate testDate = LocalDate.of(2022, 10, 5);
		assertEquals(5,reserva.tiempoRestanteParaIniciar(testDate));
		testDate = LocalDate.of(2022, 10, 11);
		assertEquals(0, reserva.tiempoRestanteParaIniciar(testDate));
	}
}
