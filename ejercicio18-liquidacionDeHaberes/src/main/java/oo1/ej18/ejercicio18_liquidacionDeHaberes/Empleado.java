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

	public void setFechaAlta(LocalDate other) {
		this.fechaAlta = other;
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

	public boolean getTieneConyugue() {
		return tieneConyugue;
	}

	public void setTieneConyugue(boolean tieneConyugue) {
		this.tieneConyugue = tieneConyugue;
	}

	public boolean getTieneHijxs() {
		return tieneHijxs;
	}

	public void setTieneHijxs(boolean tieneHijxs) {
		this.tieneHijxs = tieneHijxs;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public int getAntiguedad() {
		return LocalDate.now().compareTo(this.getFechaAlta());
	}
	
	public boolean agregarContrato(Contrato contrato) {
		if(this.estaActivo()) {
			return false;
		}
		contratos.add(contrato);
		return true;
	}
	
	public boolean estaActivo() {
		if (this.ultimoContrato() != null) {
			return this.ultimoContrato().estaActivo();
		}
		return false;
	}
	
	public Contrato ultimoContrato() {
		return this.contratos.stream().max((contrato1, contrato2) -> contrato1.getFechaInicio().compareTo(contrato2.getFechaInicio())).orElse(null);
	}
	
	public Recibo generarReciboCobro(Antiguedades antiguedades) {
		if(this.estaActivo()) {
			double sueldo = this.ultimoContrato().calcularMonto();
			sueldo += antiguedades.calcularMontoAntiguedad(this.getAntiguedad(), sueldo);
			return new Recibo(this.nombre, this.apellido, this.cuil, fechaAlta, fechaAlta, sueldo);
		}
		
		return null;
	}


	
	
}
