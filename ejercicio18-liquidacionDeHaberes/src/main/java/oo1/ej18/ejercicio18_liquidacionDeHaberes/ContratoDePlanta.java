package oo1.ej18.ejercicio18_liquidacionDeHaberes;

public class ContratoDePlanta extends Contrato {
	private double sueldoMensual, montoConyugue, montoHijxs;
	
	public ContratoDePlanta(double sueldoMensual, double montoConyugue, double montoHijxs, Empleado empleado) {
		super(empleado);
		this.sueldoMensual = sueldoMensual;
		this.montoConyugue = montoConyugue;
		this.montoHijxs = montoHijxs;
	}
	
	public double calcularMonto() {
		double sueldo = this.sueldoMensual;
		if(this.getEmpleado().getTieneConyugue()) {
			sueldo += this.montoConyugue;
		}
		if (this.getEmpleado().getTieneHijxs()) {
			sueldo += this.montoHijxs;
		}
		return sueldo;
	}
	
	public boolean vence() {
		return true;
	}

	public boolean estaActivo() {
		return true;
	}
	
}
