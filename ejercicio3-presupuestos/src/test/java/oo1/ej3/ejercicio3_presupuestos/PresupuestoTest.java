package oo1.ej3.ejercicio3_presupuestos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PresupuestoTest {

	private Presupuesto presupuesto;

	@BeforeEach
	public void setUp() {
		presupuesto = new Presupuesto("Pedro");
	}

	@Test
	public void testCalcularTotal() {
		assertEquals(0, presupuesto.calcularTotal());
		Item item = new Item("Leche", 100, 1);
		presupuesto.agregarItem(item);
		assertEquals(100, presupuesto.calcularTotal());

		item = new Item("Chocolate", 150, 1);
		presupuesto.agregarItem(item);

		assertEquals(250, presupuesto.calcularTotal());
	}

	@Test
	public void testInitialize() {
		assertEquals(0, presupuesto.calcularTotal());
	}

}
