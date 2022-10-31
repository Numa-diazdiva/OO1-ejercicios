package oo1.ej19.ejercicio19_MercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

	private Persona vendedor;
	private Cliente cliente;
	private Producto producto;
	private Pedido pedido;
	private FormaDePago formaDePagoEfectivo, formaDePagoCuotas;
	private Envio envio;
	
	@BeforeEach
	void setUp() {
		this.vendedor = new Persona("Pablito", "asd1234");
		this.producto = new Producto("Shampoo", "asdfgqeg", 100, 10, vendedor);
		this.cliente = new Cliente("Nati", "adagfw");
		this.formaDePagoCuotas = new PagoEnSeisCuotas();
		this.formaDePagoEfectivo = new PagoEfectivo();
	}
	
	@Test
	void testCalcularCostoRetiroEnComercio() {
		this.envio = new RetiroEnComercio();
		this.pedido = new Pedido(producto, this.cliente, 6, formaDePagoCuotas, envio);
		assertEquals(720,this.pedido.calcularCosto());
		this.pedido = new Pedido(producto, this.cliente, 6, formaDePagoEfectivo, envio);
		assertEquals(600, this.pedido.calcularCosto());		
	}
	
	
	@Test
	void testCalcularCostoEnvioExpress() {
		Mapa mapa = new Mapa();
		this.envio = new ExpressDomicilio(this.cliente.getDireccion(), this.vendedor.getDireccion(), mapa);
		this.pedido = new Pedido(producto, this.cliente, 6, formaDePagoCuotas, envio);
		assertEquals(770,this.pedido.calcularCosto());
		this.pedido = new Pedido(producto, this.cliente, 6, formaDePagoEfectivo, envio);
		assertEquals(650, this.pedido.calcularCosto());	
	}
	
	@Test
	void testCalcularCostoRetiroEnCorreo() {
		this.envio = new RetiroEnCorreo();
		this.pedido = new Pedido(producto, this.cliente, 6, formaDePagoCuotas, envio);
		assertEquals(770,this.pedido.calcularCosto());
		this.pedido = new Pedido(producto, this.cliente, 6, formaDePagoEfectivo, envio);
		assertEquals(650, this.pedido.calcularCosto());	
	}
	
}
