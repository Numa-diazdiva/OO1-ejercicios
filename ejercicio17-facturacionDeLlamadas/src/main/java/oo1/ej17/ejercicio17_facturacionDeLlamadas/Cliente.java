package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre, direccion;
	private NroTelefono numeroDeTelefono;
	protected List<Llamada> llamadas;
	
	public Cliente(String nombre, String direccion, NroTelefono numeroDeTelefono) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setNumeroDeTelefono(numeroDeTelefono);
		llamadas = new ArrayList<Llamada>();
	}
	
	public Cliente(String nombre, String direccion) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		llamadas = new ArrayList<Llamada>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public NroTelefono getNumeroDeTelefono() {
		return numeroDeTelefono;
	}

	public void setNumeroDeTelefono(NroTelefono numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}
	
	public void registrarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public List<Llamada> getLlamadas() {
		return this.llamadas;
	}
	
	/**
	 * Determina si la llamada especificada fue realizada en el periodo indicado
	 * @param from
	 * @param to
	 * @param llamada
	 * @return true si la llamada está contenida en el periodo, false en caso contrario.
	 */
	public boolean contieneLlamadaEnPeriodo(LocalDateTime from, LocalDateTime to, Llamada llamada) {
		// puede ser privada, por lo pronto es pública para testear
		return llamada.getFechaYHora().compareTo(from) >= 0 && llamada.getFechaYHora().compareTo(to) <= 0;
	}
	
	/**
	 * Crea una lista con las llamadas que realizó el cliente en el período especificado.
	 * @param from
	 * @param to
	 * @return Lista con las llamadas realizadas.
	 */
	public List<Llamada> llamadasEntreFechas(LocalDateTime from, LocalDateTime to) {
		return this.llamadas.stream().filter(llamada -> this.contieneLlamadaEnPeriodo(from, to, llamada)).toList();
	}
	
	/**
	 * Crea una factura con la suma del monto total de las llamadas realizadas en el período especificado.
	 * @param from
	 * @param to
	 * @return Factura
	 */
	public abstract Factura facturarLlamadas(LocalDateTime from, LocalDateTime to);
	
}
