package oo1.ej8.ejercicio8_redElectrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Usuario usuario;
	private Consumo consumo1, consumo2;
	
	@BeforeEach
	void setUp() {
		usuario = new Usuario("Panchito", "20 de Septiembre 1945");
		consumo1 = new Consumo(75,10);
		consumo2 = new Consumo(45,3);
	}
	
	@Test
	void testAgregarConsumo() {
		usuario.agregarMedicion(consumo1);
		assertTrue(usuario.getConsumos().contains(consumo1));
		
		usuario.agregarMedicion(consumo2);
		assertTrue(usuario.getConsumos().contains(consumo2));
	}
	
	@Test
	void testUltimoConsumoActiva() {
		usuario.agregarMedicion(consumo1);
		usuario.agregarMedicion(consumo2);
		assertEquals(45,usuario.ultimoConsumoActiva());
	}
	
	
	
}
