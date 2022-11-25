package oo1.extra.EnergiaFinal2018;

import java.util.HashSet;
import java.util.Set;

public class Empresa {
	Set<Cliente> clientes;
	Tarifario tarifario;
	
	public Empresa() {
		clientes = new HashSet<Cliente>();
		tarifario = new Tarifario(10, 20, 0.1, 0.02);
	}
	
	public void actualizarTarifario(double precioResidencial, double precioIndustrial) {
		this.actualizarTarifario(precioResidencial, precioIndustrial);
	}
	
	public Cliente altaClienteResidencial(String nombre, String apellido, String direccion) {
		Cliente nuevoCliente = new ClienteResidencial(nombre, apellido, direccion);
		this.clientes.add(nuevoCliente);
		return nuevoCliente;
	}

	public Cliente altaClienteIndustrial(String nombre, String direccion) {
		Cliente nuevoCliente = new ClienteIndustrial(nombre, direccion);
		this.clientes.add(nuevoCliente);
		return nuevoCliente;
	}

	
	
}
