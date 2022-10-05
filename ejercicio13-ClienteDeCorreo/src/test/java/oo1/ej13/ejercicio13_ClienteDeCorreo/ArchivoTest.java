package oo1.ej13.ejercicio13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	private Archivo archivo;
	
	@BeforeEach
	void setUp() {
		archivo = new Archivo("Pablito");
	}
	
	@Test
	void testTamaño() {
		assertEquals(7,archivo.tamaño());
	}
	
}
