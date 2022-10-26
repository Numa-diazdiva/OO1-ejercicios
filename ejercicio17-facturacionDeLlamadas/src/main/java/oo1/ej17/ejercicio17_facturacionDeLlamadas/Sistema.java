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
	
	public void agregarClientePersonaFisica(String nombre, String direccion, int dni) {
		Cliente cliente = null;
		this.clientes.add(null);
	}
	
	
}
