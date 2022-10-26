package main.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Propiedad> propiedades;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	
	/**
	 * Registra un usuario agregándolo a la lista de usuarios del sistema
	 * @param usr: Usuario
	 * @return true si el usuario se registró. False si el usuario ya está registrado.
	 */
	public boolean registrarUsuario(Usuario usr) {
		if (!this.usuarios.contains(usr)) {
			this.usuarios.add(usr);
			return true;
		}
		return false;
	}
	
	/**
	 * Registra una propiedad agregándola a la lista de propiedades del sistema.
	 * @param prop: Propiedad
	 * @param usr: Usuario
	 * @return true si la propiedad se registró. False si la propiedad ya estaba registrada en el sistema.
	 */
	public boolean registrarPropiedad(Propiedad prop, Usuario usr) {
		if (!this.propiedades.contains(prop)) {
			this.propiedades.add(prop);
			usr.agregarPropiedad(prop);
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve una lista con las propiedades que se encuentran disponibles para alquilar entre las fechas solicitadas.
	 * @param from: LocalDate
	 * @param to: LocalDate
	 * @return List<Propiedad> conteniendo las propiedades disponibles si las hay.
	 */
	public List<Propiedad> buscarPropiedadesEnAlquiler(LocalDate from, LocalDate to) {
		return this.propiedades.stream().filter(propiedad -> propiedad.disponibleEnPeriodo(from, to)).toList();
	}
	
	/**
	 * No incluyo los métodos de eliminar y de reservar acá porque de esa manera la clase sistema funciona únicamente como pasamanos.
	 * Quien implementa la interfaz de usuario puede comunicarse directamente con las clases responsables de hacer cada cosa.
	 */
	
}
