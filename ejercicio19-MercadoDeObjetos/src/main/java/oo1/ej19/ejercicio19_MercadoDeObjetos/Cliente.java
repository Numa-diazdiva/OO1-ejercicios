package oo1.ej19.ejercicio19_MercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
	
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		pedidos = new ArrayList<Pedido>();
	}
	
	public void registrarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}
	
}
