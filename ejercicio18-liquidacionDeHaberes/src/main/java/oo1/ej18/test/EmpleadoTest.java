package oo1.ej18.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import oo1.ej18.ejercicio18_liquidacionDeHaberes.Contrato;
import oo1.ej18.ejercicio18_liquidacionDeHaberes.ContratoDePlanta;
import oo1.ej18.ejercicio18_liquidacionDeHaberes.ContratoPorHoras;
import oo1.ej18.ejercicio18_liquidacionDeHaberes.Empleado;

public class EmpleadoTest {
	
	private Empleado pablo, romina, jeff;
	
	@BeforeEach
	void setUp() {
		romina = new Empleado("Pablo", "Solaris", 12355, LocalDate.of(1991, 4, 6), true, false);
		pablo = new Empleado("Romina", "Pastrana", 12355, LocalDate.of(1980, 4, 6), true, false);
		jeff = new Empleado("Jeff", "Beck", 12355, LocalDate.of(1974, 4, 6), false, false);
	}
	
	
	
	@Test
	void testGetAntiguedad() {
		romina.setFechaAlta(LocalDate.of(2015, 5, 3));
		assertEquals(7,romina.getAntiguedad());
	}
	
	
	@Test
	void testAgregarContratoOk() {
		Contrato contratoNuevo = new ContratoPorHoras(LocalDate.of(2022, 12, 5), 2000, 10, jeff);
		jeff.agregarContrato(contratoNuevo);
		assertTrue(jeff.getContratos().contains(contratoNuevo));
		assertEquals(contratoNuevo, jeff.ultimoContrato());
		assertTrue(jeff.estaActivo());
		
		contratoNuevo = new ContratoDePlanta(200000, 20000, 200000, romina);
		romina.agregarContrato(contratoNuevo);
		assertEquals(contratoNuevo, romina.ultimoContrato());
		assertTrue(romina.estaActivo());
		
	}
	
	@Test
	void testAgregarContratoFail(){
		Contrato contratoNuevo = new ContratoPorHoras(LocalDate.of(2022, 12, 5), 2000, 10, jeff);
		jeff.agregarContrato(contratoNuevo);
		assertTrue(jeff.getContratos().contains(contratoNuevo));
		assertEquals(contratoNuevo, jeff.ultimoContrato());
		
		Contrato contrato2 = new ContratoPorHoras(LocalDate.of(2022, 12, 5), 2000, 10, jeff);
		assertFalse(jeff.agregarContrato(contrato2));
		assertFalse(jeff.getContratos().contains(contrato2));
		
		
		contratoNuevo = new ContratoDePlanta(200000, 20000, 200000, romina);
		romina.agregarContrato(contratoNuevo);
		assertEquals(contratoNuevo, romina.ultimoContrato());
		
		assertFalse(romina.agregarContrato(contrato2));
		assertFalse(romina.getContratos().contains(contrato2));
		
		
	}
	
	
}
