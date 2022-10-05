package oo1.ej13.ejercicio13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	private Email email;
	
	@BeforeEach
	void setUp() {
		email = new Email("Título","Testing");
	}
	
	@Test
	void testEspacioOcupado() {
		Archivo archivo1 = new Archivo("Pablito");
		Archivo archivo2 = new Archivo("Jimena");
		email.adjuntarArchivo(archivo1);
		email.adjuntarArchivo(archivo2);
		
		assertEquals(26, email.espacioOcupado());
	}
}
