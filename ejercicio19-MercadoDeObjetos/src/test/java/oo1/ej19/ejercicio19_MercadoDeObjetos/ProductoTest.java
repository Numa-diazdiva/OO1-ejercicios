package oo1.ej19.ejercicio19_MercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {

	private Persona vendedor;
	private Producto producto;
	
	@BeforeEach
	void setUp() {
		this.vendedor = new Persona("Pablito", "asd1234");
		this.producto = new Producto("Shampoo", "asdfgqeg", 100, 10, vendedor);
	}
	
	@Test
	void testRetirarItems() {
		assertTrue(producto.retirarItems(5));
		assertFalse(producto.retirarItems(6));
		assertTrue(producto.retirarItems(5));
	}
	
}
