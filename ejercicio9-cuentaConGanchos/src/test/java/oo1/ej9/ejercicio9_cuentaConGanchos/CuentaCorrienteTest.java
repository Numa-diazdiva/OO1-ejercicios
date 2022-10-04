package oo1.ej9.ejercicio9_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	private CuentaCorriente cuentaCorriente;
	
	@BeforeEach
	void setUp() {
		cuentaCorriente = new CuentaCorriente();
		cuentaCorriente.setDescubierto(50);
		cuentaCorriente.depositar(100);
	}
	
	@Test
	void testSetDescubierto() {
		// Uno fuera de rango, otro dentro
		assertTrue(cuentaCorriente.setDescubierto(600));
		assertFalse(cuentaCorriente.setDescubierto(-50));
	}
	
	@Test
	void testExtraerExitoso(){
		//Pensé que no se podía acceder desde acá, pero se puede
		boolean puede = cuentaCorriente.puedeExtraer(20);
		assertTrue(puede);
		assertTrue(cuentaCorriente.extraer(120));
		assertEquals(-20, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testExtraerFallido() {
		assertFalse(cuentaCorriente.puedeExtraer(155));
		cuentaCorriente.extraer(100);
		assertEquals(0, cuentaCorriente.getSaldo());
		assertFalse(cuentaCorriente.extraer(70));
	}
	
	@Test
	void testTransferenciaExitosa() {
		Cuenta cuenta2 = new CuentaCorriente();
		assertTrue(cuentaCorriente.transferirACuenta(145, cuenta2));
		assertEquals(-45, cuentaCorriente.getSaldo());
		assertEquals(145, cuenta2.getSaldo());
	}
	
	@Test
	void testTransferenciaFallida() {
		Cuenta cuenta2 = new CuentaCorriente();
		assertFalse(cuentaCorriente.transferirACuenta(155, cuenta2));
		assertEquals(100, cuentaCorriente.getSaldo());
		assertEquals(0, cuenta2.getSaldo());
	}
	
	@Test
	void testTransferenciaACajaDeAhorro() {
		Cuenta cajaDeAhorro = new CajaDeAhorro();
		assertTrue(cuentaCorriente.transferirACuenta(20, cajaDeAhorro));
		assertEquals(19.6, cajaDeAhorro.getSaldo()); // Descuento servicio
		assertEquals(80, cuentaCorriente.getSaldo());
	}
	
	
}
