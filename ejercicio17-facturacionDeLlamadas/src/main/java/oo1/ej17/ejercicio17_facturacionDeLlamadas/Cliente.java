package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre, direccion;
	private NroTelefono numeroDeTelefono;
	private List<Llamada> llamadas;
	
	public Cliente(String nombre, String direccion, NroTelefono numeroDeTelefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroDeTelefono = numeroDeTelefono;
		llamadas = new ArrayList<Llamada>();
	}
	
	public void registrarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public Factura facturarLlamadas(LocalDate from, LocalDate to) {
		return null;
	}
	
}
