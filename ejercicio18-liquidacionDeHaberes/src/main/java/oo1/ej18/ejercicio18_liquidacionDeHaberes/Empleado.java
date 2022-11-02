package oo1.ej18.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre, apellido;
	private int cuil;
	private LocalDate fechaNacimiento, fechaAlta;
	private boolean tieneConyugue, tieneHijxs;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, int cuil, LocalDate fechaNacimiento, boolean conyugue, boolean hijos) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.setTieneConyugue(conyugue);
		this.setTieneHijxs(hijos);
		this.contratos = new ArrayList<Contrato>();
		this.fechaAlta = LocalDate.now();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCuil() {
		return cuil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public boolean isTieneConyugue() {
		return tieneConyugue;
	}

	public void setTieneConyugue(boolean tieneConyugue) {
		this.tieneConyugue = tieneConyugue;
	}

	public boolean isTieneHijxs() {
		return tieneHijxs;
	}

	public void setTieneHijxs(boolean tieneHijxs) {
		this.tieneHijxs = tieneHijxs;
	}
	
	
	public boolean estaActivo() {
		return true;
	}
	
	public Recibo generarReciboCobro() {
		return null;
	}
	
	
}
