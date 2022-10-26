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

public class PropiedadTest {
	
	private Propiedad prop1;
	private Usuario usr1;
	private PoliticaDeCancelacion politica;
	
	@BeforeEach
	void setUp() {
		this.usr1 = new  Usuario("Malena", "Avellaneda 1456", 25777777);
		this.politica = new PoliticaEstricta();
		this.prop1 = new Propiedad("Cabaña 2", "Av 12 1678", 1000, usr1, politica);
//		LocalDate from = LocalDate.of(2022, 12, 1);
//		LocalDate to = LocalDate.of(2022, 12, 10);
//		this.reserva1 = new Reserva(usr1, prop1, from, to);
	}
	
	private Reserva reservar() {
		LocalDate from = LocalDate.of(2022, 12, 1);
		LocalDate to = LocalDate.of(2022, 12, 10);
		return prop1.reservar(from, to, usr1);
	}
	
	@Test
	void testReservarExitoso() {
		LocalDate from = LocalDate.of(2022, 12, 1);
		LocalDate to = LocalDate.of(2022, 12, 10);
		Reserva reserva2 = prop1.reservar(from, to, usr1);
		from = LocalDate.of(2022, 12, 11);
		to = LocalDate.of(2022, 12, 25);
		assertNotNull(prop1.reservar(from, to, usr1));
	}
	
	@Test
	void testReservarFallido() {
		LocalDate from = LocalDate.of(2022, 12, 1);
		LocalDate to = LocalDate.of(2022, 12, 10);
		Reserva reserva2 = prop1.reservar(from, to, usr1);
		// Puedo dividir acá, más granular
		// Fallido por fecha contenida en fecha ya reservada
		from = LocalDate.of(2022, 12, 5);
		to = LocalDate.of(2022, 12, 8);
		assertNull(this.prop1.reservar(from, to, usr1));
		// Fallido por fecha solapada con el principio de reserva previa
		from = LocalDate.of(2022, 11, 25);
		to = LocalDate.of(2022, 12, 2);
		assertNull(this.prop1.reservar(from, to, usr1));
		// Fallido por fecha solapada con el final de reserva previa
		from = LocalDate.of(2022, 12, 8);
		to = LocalDate.of(2022, 12, 22);
		assertNull(this.prop1.reservar(from, to, usr1));
		// Fallido por fecha previa contenida en nueva fecha
		from = LocalDate.of(2022, 11, 12);
		to = LocalDate.of(2022, 12, 15);
		assertNull(this.prop1.reservar(from, to, usr1));		
	}
	
	@Test
	void testEliminarExitoso() {
		LocalDate from = LocalDate.of(2022, 12, 1);
		LocalDate to = LocalDate.of(2022, 12, 10);
		Reserva reserva2 = prop1.reservar(from, to, usr1);
		assertTrue(prop1.getReservas().contains(reserva2));
		assertTrue(prop1.eliminarReserva(reserva2));
		assertFalse(prop1.getReservas().contains(reserva2));
	}
	
	@Test
	void testEliminarFallido() {
		LocalDate from = LocalDate.of(2022, 10, 12);
		LocalDate to = LocalDate.of(2022, 11, 10);
		Reserva reserva2 = prop1.reservar(from, to, usr1);
		assertTrue(prop1.getReservas().contains(reserva2));
		assertFalse(prop1.eliminarReserva(reserva2));
		assertTrue(prop1.getReservas().contains(reserva2));
	}
	
	@Test
	void testCalcularIngresos() {
		LocalDate from = LocalDate.of(2022, 10, 12);
		LocalDate to = LocalDate.of(2022, 10, 15);
		prop1.reservar(from, to, usr1);
		from = LocalDate.of(2022, 11, 12);
		to = LocalDate.of(2022, 11, 22);
		prop1.reservar(from, to, usr1);
		from = LocalDate.of(2022, 11, 15);
		to = LocalDate.of(2022, 11, 17);
		assertEquals(2000, prop1.calcularIngresos(from, to));
		from = LocalDate.of(2022, 10, 10);
		to = LocalDate.of(2022, 11, 22);
		assertEquals(13000, prop1.calcularIngresos(from, to));
	}
	
	@Test 
	void testCancelacionEstricta() {
		Reserva reserva2 = this.reservar();
		LocalDate fechaCancelacion = LocalDate.of(2022, 11, 11);
		assertEquals(0, this.prop1.calcularReembolso(reserva2, fechaCancelacion));
	}

	@Test 
	void testCancelacionModeradaNula() {
		Reserva reserva2 = this.reservar();
		this.prop1.setPoliticaDeCancelacion(new PoliticaModerada());
		LocalDate fechaCancelacion = LocalDate.of(2022, 11, 30);
		assertEquals(0, this.prop1.calcularReembolso(reserva2, fechaCancelacion));
	}
	
	void testCancelacionModeradaMitad() {
		Reserva reserva2 = this.reservar();
		this.prop1.setPoliticaDeCancelacion(new PoliticaModerada());
		LocalDate fechaCancelacion = LocalDate.of(2022, 11, 26);
		assertEquals(5000, this.prop1.calcularReembolso(reserva2, fechaCancelacion));
	}
	
	void testCancelacionModeradaTotal() {
		Reserva reserva2 = this.reservar();
		this.prop1.setPoliticaDeCancelacion(new PoliticaModerada());
		LocalDate fechaCancelacion = LocalDate.of(2022, 11, 20);
		assertEquals(10000, this.prop1.calcularReembolso(reserva2, fechaCancelacion));
	}
	
	void testCancelacionFlexible() {
		Reserva reserva2 = this.reservar();
		this.prop1.setPoliticaDeCancelacion(new PoliticaModerada());
		LocalDate fechaCancelacion = LocalDate.of(2022, 11, 29);
		assertEquals(10000, this.prop1.calcularReembolso(reserva2, fechaCancelacion));
		fechaCancelacion = LocalDate.of(2022, 11, 2);
		assertEquals(0, this.prop1.calcularReembolso(reserva2, fechaCancelacion));
	}
	
	
}
