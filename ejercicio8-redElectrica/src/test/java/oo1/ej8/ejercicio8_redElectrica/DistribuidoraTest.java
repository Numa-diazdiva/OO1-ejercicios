package oo1.ej8.ejercicio8_redElectrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DistribuidoraTest {
	private Distribuidora dist;
	private List<Factura> facturacion;
	
	@BeforeEach
	void setUp() {
		dist = new Distribuidora(10);
	}
	@Test
	void testPrecioIncorrecto(){
		dist.setPrecioKWh(-5);
		assertEquals(10, dist.getPrecioKWh());
	}
	@Test
	void testPrecioCorrecto() {
		dist.setPrecioKWh(500);
		assertEquals(500, dist.getPrecioKWh());
	}
	@Test
	void testAgregarUsuario() {
		Usuario usuario = new Usuario("Panchito", "20 de Septiembre 1945");
		dist.agregarUsuario(usuario);
		assertTrue(dist.getUsuarios().contains(usuario));
	}
	
	
	@Test
	void testEmitirFacturas() {
		Consumo consumo1 = new Consumo(10,2);
		Consumo consumo2 = new Consumo(45,3);
		Consumo consumo3 = new Consumo(4,5);
		Usuario usuario1 = new Usuario("Panchito", "20 de Septiembre 1945");
		Usuario usuario2 = new Usuario("Mirtha", "Avellaneda 983 2A");
		usuario1.agregarMedicion(consumo1);
		usuario2.agregarMedicion(consumo2);
		usuario2.agregarMedicion(consumo3);
		dist.agregarUsuario(usuario1);
		dist.agregarUsuario(usuario2);
		
		facturacion = dist.facturar();
		// FPe = 0.98 => hay descuento
		assertEquals(90,facturacion.get(0).montoTotal());
		// FPe = 0.62 => no hay descuento
		assertEquals(40, facturacion.get(1).montoTotal());
	}
	
	@Test
	void testConsumoTotalActiva() {
		Consumo consumo1 = new Consumo(10,2);
		Consumo consumo2 = new Consumo(45,3);
		Consumo consumo3 = new Consumo(4,5);
		Usuario usuario1 = new Usuario("Panchito", "20 de Septiembre 1945");
		Usuario usuario2 = new Usuario("Mirtha", "Avellaneda 983 2A");
		usuario1.agregarMedicion(consumo1);
		usuario2.agregarMedicion(consumo2);
		usuario2.agregarMedicion(consumo3);
		dist.agregarUsuario(usuario1);
		dist.agregarUsuario(usuario2);
		
		assertEquals(14,dist.consumoTotalActiva());
		
	}
	
	
}
