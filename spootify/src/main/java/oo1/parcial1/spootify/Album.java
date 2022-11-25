package oo1.parcial1.spootify;

import java.time.LocalDate;

public class Album extends ColeccionDeTemas {

	public Album(String titulo, LocalDate fecha) {
		super(titulo, fecha);
	}

	public int getAño() {
		return this.getFecha().getYear();
	}
	
}
