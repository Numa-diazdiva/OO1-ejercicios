package oo1.ej13.ejercicio13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {
	private ClienteDeCorreo cliente;
	private Email email1, email2;
	private Archivo archivo1, archivo2;
	
	@BeforeEach
	void setUp() {
		cliente = new ClienteDeCorreo();
		email1 = new Email("Ayuda","Ayuda123");
		archivo1 = new Archivo("Arch1");
		archivo2 = new Archivo("Arch2");
		email1.adjuntarArchivo(archivo1);
		email1.adjuntarArchivo(archivo2);
		email2 = new Email("Hola", "1");
	}
	
	
	@Test
	void testBuscar() {
		cliente.recibir(email1);
		assertEquals(email1, cliente.buscar("Ayuda"));
		assertNull(cliente.buscar("z"));
	}
	
	@Test
	void testMover() {
		// Chequear de testear con instancias creadas localmente en el test
		// Nunca acceder a listas por índices
		Carpeta carpeta1 = new Carpeta("Ayuda");
		cliente.agregarCarpeta(carpeta1);
		List<Carpeta> carpetas = cliente.getCarpetas();
		cliente.recibir(email1);
		assertEquals(carpetas.get(0), cliente.getCarpeta(email1));
		assertFalse(carpeta1.contieneEmail(email1));
		cliente.mover(email1, carpetas.get(0), carpetas.get(1));
		assertEquals(carpetas.get(1), cliente.getCarpeta(email1));
		assertTrue(carpeta1.contieneEmail(email1));
		assertFalse(carpetas.get(0).contieneEmail(email1));
	}
	
	
	@Test
	void testBorrar() {
		cliente.recibir(email1);
		cliente.borrarEmail(email1);
	}
	
	
	@Test
	void testEspacioOcupado() {
		cliente.recibir(email1);
		assertEquals(23, cliente.espacioOcupado());
		cliente.recibir(email2);
		assertEquals(28, cliente.espacioOcupado());
	
		// Funciona con distintas carpetas
		Carpeta inbox = cliente.getCarpetas().get(0);
		Carpeta nuevaCarpeta = new Carpeta("Tuki");
		cliente.agregarCarpeta(nuevaCarpeta);
		cliente.mover(email1, inbox, nuevaCarpeta);
		assertEquals(28, cliente.espacioOcupado());
		
		// Funciona si borramos
		cliente.borrarEmail(email1);
		assertEquals(5, cliente.espacioOcupado());
		cliente.borrarEmail(email2);
		assertEquals(0, cliente.espacioOcupado());
	}
	

	
}
