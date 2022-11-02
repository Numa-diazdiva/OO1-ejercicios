                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       package oo1.ej18.ejercicio18_liquidacionDeHaberes;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Empleado> empleados;
	
	public Sistema() {
		empleados = new ArrayList<Empleado>();
	}
	
	public boolean darDeAltaEmpleado(Empleado empleado) {
		if(this.empleados.contains(empleado)) {
			return false;
		}
		this.empleados.add(empleado);
		return true;
	}
	
	public Empleado buscarEmpleado(int cuil) {
		return empleados.stream().filter(e -> e.getCuil() == cuil).findFirst().orElse(null);
	}
	
	public boolean darDeBajaEmpleado(Empleado empleado) {
		return this.empleados.remove(empleado);
	}
	
	public List<Empleado> buscarEContratoVencido(){
		return empleados.stream().filter(e -> !e.estaActivo()).toList();
	}
	
	public List<Recibo> generarRecibosDeCobro(){
		return empleados.stream().map(e -> e.generarReciboCobro().toList);
	}
	
}
