package oo1.ej13.ejercicio13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	private Carpeta carpeta;
	private Email email;
	
	@BeforeEach
	void setUp() {
		carpeta = new Carpeta("Spam");
		email = new Email("Ayuda","Ayuda123");
		Archivo archivo1 = new Archivo("Arch1");
		Archivo archivo2 = new Archivo("Arch2");
		email.adjuntarArchivo(archivo1);
		email.adjuntarArchivo(archivo2);
	}
	
	@Test
	void testBorrarEmail() {
		carpeta.guardarEmail(email);
		assertEquals(1, carpeta.getCantItems());
		carpeta.borrarEmail(email);
		assertEquals(0, carpeta.getCantItems());
	}
	
	@Test
	void testEspacioOcupado() {
		carpeta.guardarEmail(email);
		 Email mail2 = new Email("Hola", "1");
		 carpeta.guardarEmail(mail2);
		assertEquals(28, carpeta.espacioOcupado());
	}
	
	@Test
	void testBuscar() {
		carpeta.guardarEmail(email);
		Email mail2 = new Email("Hola", "1");
		carpeta.guardarEmail(mail2);
		
		// Cosas que existen
		Email resultado = carpeta.buscar("Ayuda");
		assertEquals(email, resultado);
		resultado = carpeta.buscar("a");
		assertEquals(email, resultado);
		resultado = carpeta.buscar("Hola");
		assertEquals(mail2, resultado);
		
		// Cosas que no existen
		assertNull(carpeta.buscar("%"));
		
		// Que no haya nada
		carpeta.borrarEmail(mail2);
		carpeta.borrarEmail(email);
		assertNull(carpeta.buscar("a"));
	}
	
}
