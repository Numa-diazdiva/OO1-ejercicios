package oo1.ej17.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oo1.ej17.ejercicio17_facturacionDeLlamadas.Cliente;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.Llamada;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.LlamadaInternacional;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.LlamadaInterurbana;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.NroTelefono;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.PersonaFisica;
import oo1.ej17.ejercicio17_facturacionDeLlamadas.TarifaPais;


public class LlamadaTest {
	private Llamada llamada1, llamada2, llamada3;
	private NroTelefono num1, num2;
	private TarifaPais pais1, pais2;
	
	@BeforeEach
	void setUp() {
		num1 = new NroTelefono(1234);
		num2 = new NroTelefono(5467);
	}
	
	@Test
	void testLlamadaInterurbanaDistChica() {
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 99);
		// 20 + 5 (costo de conexión)
		assertEquals(25, llamada1.calcularCosto());
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 5);
		assertEquals(25, llamada1.calcularCosto());
	}
	
	void instanciarPaises() {
		pais1 = new TarifaPais("Argelia", 5, 10);
		pais2 = new TarifaPais("Argentina", 10, 20);
	}
	
	@Test
	void testLlamadaInterurbanaDistMedia() {
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 100);
		assertEquals(30, llamada1.calcularCosto());
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 255);
		assertEquals(30, llamada1.calcularCosto());
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 500);
		assertEquals(30, llamada1.calcularCosto());
	}

	@Test
	void testLlamadaInterurbanaDistanciaGrande() {
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 501);
		assertEquals(35, llamada1.calcularCosto());
		llamada1 = new LlamadaInterurbana(LocalDateTime.now(), 10, num1, num2, 778);
		assertEquals(35, llamada1.calcularCosto());
	}
	
	@Test
	void testLlamadaInternacionalDiurna() {
		instanciarPaises();
		llamada1 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 8, 0), 10, num1, num2, pais1);
		assertEquals(100, llamada1.calcularCosto());
		llamada2 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 12, 0), 10, num1, num2, pais2);
		assertEquals(200, llamada2.calcularCosto());
		llamada3 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 20, 0), 10, num1, num2, pais2);
		assertEquals(200, llamada2.calcularCosto());
	}
	
	
	@Test
	void testLlamadaInternacionalNocturna() {
		instanciarPaises();
		llamada1 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 21, 0), 10, num1, num2, pais1);
		assertEquals(50, llamada1.calcularCosto());
		llamada2 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 01, 0), 10, num1, num2, pais2);
		assertEquals(100, llamada2.calcularCosto());
		llamada3 = new LlamadaInternacional(LocalDateTime.of(2022, 11, 1, 07, 0), 10, num1, num2, pais2);
		assertEquals(100, llamada2.calcularCosto());
	}
	
	
}
