package oo1.ej5.ejercicio5_genealogia;

import java.util.Date;
import java.util.LinkedList;

public class Mamifero {
	private String identificador;
	private String especie;
	private Date fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero() {}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getEspecie() {
		return this.especie;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getPadre() {
		return this.padre;
	}

	public Mamifero getAbuelaMaterna() {
		if (this.madre != null) {
			return this.madre.getMadre();
		} else return null;
	}

	public Mamifero getAbuelaPaterna() {
		if (this.padre != null) {
			return this.padre.getMadre();
		} else return null;
	}

	public Mamifero getAbueloMaterno() {
		if (this.madre != null) {
			return this.madre.getPadre();
		} else return null;
	}

	public Mamifero getAbueloPaterno() {
		if (this.padre != null) {
			return this.padre.getPadre();
		} else return null;
	}
	
	public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		LinkedList<Mamifero> ancestros = new LinkedList<Mamifero>();
		ancestros.add(this.madre);
		ancestros.add(this.padre);
		ancestros.add(this.getAbuelaMaterna());
		ancestros.add(this.getAbueloMaterno());
		ancestros.add(this.getAbuelaPaterna());
		ancestros.add(this.getAbueloPaterno());
		return ancestros.contains(unMamifero);
	}
	
}
