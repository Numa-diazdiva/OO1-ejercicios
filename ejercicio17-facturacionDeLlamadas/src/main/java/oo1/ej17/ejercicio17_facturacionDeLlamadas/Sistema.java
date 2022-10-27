package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.util.List;
import java.util.ArrayList;

public class Sistema {
	private List<Cliente> clientes;
	private List<NroTelefono> numerosDisponibles;
	
	public Sistema() {
		clientes = new ArrayList<Cliente>();
		numerosDisponibles = new ArrayList<NroTelefono>();
	}
	
	public void agregarNumeroDeTelefono(int numero) {
		this.numerosDisponibles.add(new NroTelefono(numero));
	}
	
	public boolean agregarClientePersonaFisica(Cliente cliente) {
		if(!this.numerosDisponibles.isEmpty()) {
			cliente.setNumeroDeTelefono(this.numerosDisponibles.remove(0));
			this.clientes.add(cliente);
			return true;
		}
		return false;
	}
	
	
}
