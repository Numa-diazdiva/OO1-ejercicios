package oo1.parcial1.spootify;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre, clave;
	private List<Playlist> playlists;
	private List<Reproduccion> reproducciones;
	
	public Usuario(String nombre, String clave) {
		this.setNombre(nombre);
		this.clave = clave;
		this.playlists = new ArrayList<Playlist>();
		this.reproducciones = new ArrayList<Reproduccion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public List<Reproduccion> getReproducciones() {
		return reproducciones;
	}
	
	public void agregarReproduccion(Tema tema) {
		this.reproducciones.add(new Reproduccion(tema));
	}
	
	public void agregarPlaylist(Playlist playlist) {
		this.playlists.add(playlist);
	}
	
	public List<Tema> temasEscuchados(){
		// Falta hacerlo conjunto
		return this.reproducciones.stream().map(r -> r.getTema()).toList();
	}
	
	
	
}
