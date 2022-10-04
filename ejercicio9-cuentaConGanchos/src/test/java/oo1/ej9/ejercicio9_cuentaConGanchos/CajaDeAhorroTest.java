package oo1.ej9.ejercicio9_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CajaDeAhorroTest {
	private CajaDeAhorro cajaDeAhorro;
	
	@BeforeEach
	void setUp() {
		cajaDeAhorro = new CajaDeAhorro();
		cajaDeAhorro.depositar(20);
	}
	
	
	@Test
	void testExtraerExitoso(){
		//Pensé que no se podía acceder desde acá, pero se puede
		assertEquals(19.6, cajaDeAhorro.getSaldo());
		assertTrue(cajaDeAhorro.puedeExtraer(15));
		assertTrue(cajaDeAhorro.extraer(10));
		//assertEquals(9.4, cajaDeAhorro.getSaldo());
	}
	
	@Test 
	void testExtraerFallido(){
		assertFalse(cajaDeAhorro.puedeExtraer(19.6));
		assertFalse(cajaDeAhorro.extraer(140));
		assertEquals(19.6, cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testTransferirExitoso() {
		Cuenta cCorriente = new CuentaCorriente();
		assertTrue(cajaDeAhorro.puedeExtraer(6));
		assertTrue(cajaDeAhorro.transferirACuenta(6, cCorriente));
		assertEquals(6, cCorriente.getSaldo());
//		assertEquals(13.48, cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testTransferirFallido() {
		Cuenta cCorriente = new CuentaCorriente();
		assertFalse(cajaDeAhorro.puedeExtraer(20));
		assertFalse(cajaDeAhorro.transferirACuenta(20, cCorriente));
		assertEquals(0, cCorriente.getSaldo());
	}
	
	
}
