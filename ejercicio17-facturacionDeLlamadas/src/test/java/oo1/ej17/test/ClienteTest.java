package oo1.ej17.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oo1.ej17.ejercicio17_facturacionDeLlamadas.Cliente;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.Factura;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.Llamada;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.LlamadaInternacional;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.LlamadaInterurbana;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.NroTelefono;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.PersonaFisica;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.PersonaJuridica;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.TarifaPais;


public class ClienteTest {
	private Cliente clienteFisico, clienteJuridico;
	private NroTelefono num1, num2;
	private Llamada llamada1, llamada2;
	
	@BeforeEach
	void setUp() {
		num1 = new NroTelefono(1234);
		num2 = new NroTelefono(5467);
		clienteFisico = new PersonaFisica("Pabro", "14 de septiembre 1234", num1, 1633456);
		clienteJuridico = new PersonaJuridica("LEnovo", "14 de septiembre 1234", num1, 1633456, "SA");
	}
	
	@Test
	void testRegistrarLlamada() {
		Llamada llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 99);
		clienteFisico.registrarLlamada(llamada1);
		assertTrue(clienteFisico.getLlamadas().contains(llamada1));
	}
	
	void setearLlamadasCliente(Cliente cliente) {
		TarifaPais pais1 = new TarifaPais("Argentina", 5, 10);
		llamada1 = new LlamadaInterurbana(LocalDateTime.of(2022, 10, 27, 21, 0), 10, num1, num2, 99);
		cliente.registrarLlamada(llamada1);
		llamada2 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 21, 0), 10, num1, num2, pais1);
		cliente.registrarLlamada(llamada2);
	}
	
	@Test
	void testContieneLlamadaEnPeriodo() {
		setearLlamadasCliente(clienteFisico);
		LocalDateTime from, to;
		from = LocalDateTime.of(2022, 10, 27, 01, 0);
		to = LocalDateTime.of(2022, 11, 1, 21, 0);
		assertTrue(clienteFisico.contieneLlamadaEnPeriodo(from, to, llamada1));
		assertTrue(clienteFisico.contieneLlamadaEnPeriodo(from, to, llamada2));
	}
	
	@Test
	void testLlamadasEntreFechas() {
		setearLlamadasCliente(clienteFisico);
		LocalDateTime from, to;
		from = LocalDateTime.of(2022, 10, 27, 01, 0);
		to = LocalDateTime.of(2022, 11, 1, 21, 0);
		assertTrue(clienteFisico.llamadasEntreFechas(from, to).contains(llamada1));
		assertTrue(clienteFisico.llamadasEntreFechas(from, to).contains(llamada2));
	}
	
	@Test
	void testFacturarLlamadasPersonaFisica() {
		setearLlamadasCliente(clienteFisico);
		LocalDateTime from, to;
		from = LocalDateTime.of(2022, 10, 27, 01, 0);
		to = LocalDateTime.of(2022, 11, 1, 21, 0);
		assertEquals(75 * 0.9, clienteFisico.facturarLlamadas(from, to).getMonto());
	}
	
	@Test
	void testFacturarLlamadasPersonaJuridica() {
		setearLlamadasCliente(clienteJuridico);
		LocalDateTime from, to;
		from = LocalDateTime.of(2022, 10, 27, 01, 0);
		to = LocalDateTime.of(2022, 11, 1, 21, 0);
		assertEquals(75, clienteJuridico.facturarLlamadas(from, to).getMonto());
	}
	
	
}
