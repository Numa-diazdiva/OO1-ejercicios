package oo1.ej19.ejercicio19_MercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
	private List<Cliente> clientes;
	private List<Persona> vendedores;
	private List<Producto> productos;
	
	public Mercado() {
		clientes = new ArrayList<Cliente>();
		vendedores = new ArrayList<Persona>();
		productos = new ArrayList<Producto>();
	}
	
	public Persona registrarVendedor(String nombre, String direccion) {
		Persona vendedor = new Persona(nombre, direccion);
		vendedores.add(vendedor);
		return vendedor;
	}
	
	public Persona buscarVendedor(String nombre) {
		return vendedores.stream().filter(vendedor -> vendedor.getNombre() == nombre).findFirst().orElse(null);
	}
	
	public Persona registrarCliente(String nombre, String direccion) {
		Cliente cliente = new Cliente(nombre, direccion);
		clientes.add(cliente);
		return cliente;
	}
	
	public Persona buscarCliente(String nombre) {
		return clientes.stream().filter(cliente -> cliente.getNombre() == nombre).findFirst().orElse(null);
	}
	
	public Producto ponerProductoALaVenta(String nombre, String descripcion, double precio, int cantidad, Persona vendedor) {
		Producto producto = new Producto(nombre, descripcion, precio, cantidad, vendedor);
		productos.add(producto);
		return producto;
	}
	
	public List<Producto> buscarProducto(String nombre) {
		return productos.stream().filter(producto -> producto.getNombre() == nombre).toList();
	}
	
	
	public Pedido registrarPedido(Cliente cliente, Producto producto, int cantidad, FormaDePago formaPago, Envio envio) {
		if (producto.retirarItems(cantidad)) {
			Pedido pedido = new Pedido(producto, cliente, cantidad, formaPago, envio);
			cliente.registrarPedido(pedido);
			return pedido;
		}
		return null;
	}
	
}
