package oo1.parcial1.spootify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ColeccionDeTemas {
	private String titulo;
	private LocalDate fecha;
	private List<Tema> temas;
	
	public ColeccionDeTemas(String titulo, LocalDate fecha) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.temas = new ArrayList<Tema>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void agregarTema(Tema tema) {
		this.temas.add(tema);
	}
	
}
