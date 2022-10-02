package oo1.ej8.ejercicio8_redElectrica;

import java.util.List;
import java.util.LinkedList;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precio) {
		usuarios = new LinkedList<Usuario>();
		this.setPrecioKWh(precio);
	}
	
	public double getPrecioKWh() {
		return this.precioKWh;
	}
	
	public void setPrecioKWh(double precio) {
		if (precio > 0) {
			this.precioKWh = precio;
		}
	}
		
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	
	public List<Factura> facturar(){
		// Solución tradicional
		List<Factura> facturacion = new LinkedList<Factura>();
		for(Usuario usr : usuarios) {
			facturacion.add(usr.facturarEnBaseA(this.precioKWh));
		}
		return facturacion;
	}
	
	public double consumoTotalActiva() {
		double consumoActiva = 0;
		for(Usuario usr: usuarios) {
			consumoActiva += usr.ultimoConsumoActiva();
		}
		return consumoActiva;
	}
}
