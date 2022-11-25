package oo1.parcial1.spootify;

public class Tema {
	private String titulo, genero;
	private double duracion;
	private Musico autor;
	
	public Tema(String titulo, String genero, double duracion, Musico autor) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
}
