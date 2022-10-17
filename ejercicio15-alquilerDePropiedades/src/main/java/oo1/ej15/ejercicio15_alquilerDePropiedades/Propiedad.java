package oo1.ej15.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Propiedad {
	private String nombre, direccion, descripcion;
	private double precioPorNoche;
	private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String direccion, double precioPorNoche, Usuario propietario) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioPorNoche = precioPorNoche;
		this.propietario = propietario;
		this.descripcion = "sin descripción";
		this.reservas = new ArrayList<Reserva>();	
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
	
	/**
	 * Consulta las reservas de la propiedad y determina si ésta se encuentra disponible entre las fechas especificadas.
	 * @param from
	 * @param to
	 * @return true si la propiedad está disponible. False si ya está reservada.
	 */
	public boolean disponibleEnPeriodo(LocalDate from, LocalDate to) {
		return !this.reservas.stream().anyMatch(reserva -> reserva.seSolapa(from, to));
	}

	/**
	 * Se reserva si ésta está disponible en el periodo requerido.
	 * @param from
	 * @param to
	 * @param usr
	 * @return Reserva si se pudo reservar. Null en caso contrario.
	 */
	public Reserva reservar(LocalDate from, LocalDate to, Usuario usr) {
		if(this.disponibleEnPeriodo(from, to)) {
			Reserva reserva = new Reserva(usr, this, from, to);
			this.reservas.add(reserva);
			usr.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}
	
	/**
	 * Elimina la reserva solicitada si la ocupación aún no aconteció y si dicha reserva corresponde a esta propiedad 
	 * @param reserva
	 * @return true si la reserva se pudo eliminar. False si la reserva ya aconteció o no corresponde a esta propiedad.
	 */
	public boolean eliminarReserva(Reserva reserva) {
		if (reserva.estaOcurriendo()) {
			return false;
		}
		return this.reservas.remove(reserva);
	}
	
	public double calcularIngresos(LocalDate from, LocalDate to) {
		return this.reservas.stream().mapToInt(reserva -> reserva.solapamientoEnDias(from, to)).sum() * this.precioPorNoche;
	}
	
}
