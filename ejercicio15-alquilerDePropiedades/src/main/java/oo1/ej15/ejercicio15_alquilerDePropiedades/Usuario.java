package oo1.ej15.ejercicio15_alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre, direccion;
	private int dni;
	private List<Reserva> reservas;
	private List<Propiedad> propiedades;
	
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.reservas = new ArrayList<Reserva>();
		this.propiedades = new ArrayList<Propiedad>();
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
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void agregarReserva(Reserva reserva){
		this.reservas.add(reserva);
	}
	
	public void agregarPropiedad(Propiedad prop) {
		this.propiedades.add(prop);
	}
	
}
