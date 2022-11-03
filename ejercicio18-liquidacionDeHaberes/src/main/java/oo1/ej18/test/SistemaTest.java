package oo1.ej18.test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import oo1.ej18.ejercicio18_liquidacionDeHaberes.Empleado;
import oo1.ej18.ejercicio18_liquidacionDeHaberes.Sistema;

public class SistemaTest {
	private Sistema sistema;
	private Empleado pablo, romina, jeff;
	
	@BeforeEach
	void setUp() {
		sistema = new Sistema();
		romina = new Empleado("Pablo", "Solaris", 12355, LocalDate.of(1991, 4, 6), true, false);
		pablo = new Empleado("Romina", "Pastrana", 12355, LocalDate.of(1980, 4, 6), true, false);
		jeff = new Empleado("Jeff", "Beck", 12355, LocalDate.of(1974, 4, 6), false, false);
	}
	
	
	@Test
	void testGenerarRecibosDeSueldo() {
		
	}
	
}
