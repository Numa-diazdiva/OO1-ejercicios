package oo1.ej19.ejercicio19_MercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MercadoTest {

	private Mercado mercado;
	private Persona vendedor, vendedor2;
	private Cliente cliente;
	private Producto producto;
	private Pedido pedido;
	private FormaDePago formaDePagoEfectivo, formaDePagoCuotas;
	private Envio envio;
	
	@BeforeEach
	void setUp() {
		this.mercado = new Mercado();
		this.vendedor = new Persona("Pablito", "asd1234");
		this.cliente = new Cliente("Nati", "adagfw");
		this.formaDePagoCuotas = new PagoEnSeisCuotas();
		this.formaDePagoEfectivo = new PagoEfectivo();
		this.vendedor2 = this.mercado.registrarVendedor("Eddy", "asd1234");
		this.mercado.registrarCliente("Leti", "asdfhjh");
		this.producto = this.mercado.ponerProductoALaVenta("Shampú", "dasfgeh", 300, 10, vendedor);
	}
	
	
	@Test
	void testBuscarVendedorOK() {
		assertNotNull(this.mercado.buscarVendedor("Eddy"));
		assertEquals("asd1234", this.mercado.buscarVendedor("Eddy").getDireccion());
	}
	
	@Test
	void testBuscarVendedorError() {
		assertNull(this.mercado.buscarVendedor("Matilda"));
	}
	
	@Test
	void testBuscarClienteOK() {
		assertNotNull(this.mercado.buscarCliente("Leti"));
		assertEquals("asdfhjh", this.mercado.buscarCliente("Leti").getDireccion());
	}
	
	@Test
	void testBuscarClienteError() {
		assertNull(this.mercado.buscarCliente("Matilda"));
	}

	@Test
	void testBuscarProductoOK() {
		Producto producto2 = this.mercado.ponerProductoALaVenta("Shampú", "asdgfgeh", 100, 10, vendedor);
		assertEquals(2, this.mercado.buscarProducto("Shampú").size());
		assertTrue(this.mercado.buscarProducto("Shampú").contains(this.producto));
		assertTrue(this.mercado.buscarProducto("Shampú").contains(producto2));
	}
	
	@Test
	void testBuscarProductoError() {
		assertTrue(this.mercado.buscarProducto("Mayonesa").isEmpty());
	}
	
	
	@Test
	void testRegistrarPedidoOK() {
		this.pedido = this.mercado.registrarPedido(cliente, producto, 10, formaDePagoCuotas, envio);
		assertTrue(cliente.getPedidos().contains(pedido));
	}
	
	@Test
	void testRegistrarPedidoError() {
		assertNull(this.mercado.registrarPedido(cliente, producto, 11, formaDePagoCuotas, envio));
	}
	
}
