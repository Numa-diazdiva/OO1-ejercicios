package oo1.parcial1.spootify;

import java.time.LocalDate;

public class Reproduccion {
	private Tema tema;
	private LocalDate fecha;
	
	public Reproduccion(Tema tema) {
		this.tema = tema;
		this.fecha = LocalDate.now();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Tema getTema() {
		return tema;
	}
}
