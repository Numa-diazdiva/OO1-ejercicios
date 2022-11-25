package oo1.parcial1.spootify;

import java.util.ArrayList;
import java.util.List;

public class Musico implements Generico {
	private String nombre, descripcion;
	public List<Tema> temasPropios;
	
	public Musico(String nombre) {
		this.setNombre(nombre);
		this.temasPropios = new ArrayList<Tema>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	// le podría llegar el tema también y que no cumpla la función de creador
	// aunque así nos aseguramos de que no pueda tener otro autor el tema (o sino se controla en sistema)
	public void agregarTemaPropio(String titulo, String genero, double duracion) {
		this.temasPropios.add(new Tema(titulo, genero, duracion, this));
	}
	
	public List<String> generos() {
		return this.temasPropios.stream().map(t -> t.getGenero()).toList();
	}
	
}
