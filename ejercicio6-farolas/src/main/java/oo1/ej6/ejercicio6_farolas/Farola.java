package oo1.ej6.ejercicio6_farolas;

import java.util.LinkedList;
import java.util.List;

public class Farola {
	private boolean encendida;
	private LinkedList<Farola> neightborFarolas;
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola() {
		this.encendida = false;
		this.neightborFarolas = new LinkedList<Farola>();
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos
	entre las farolas es recíproca, es decir el receptor del mensaje será vecino
	de otraFarola, al igual que otraFarola también se convertirá en vecina del
	receptor del mensaje
	*/
	
	public void pairWithNeighbor(Farola otraFarola) {
		if(!this.neightborFarolas.contains(otraFarola)) {
			this.neightborFarolas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.neightborFarolas;
	}
	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.encendida) {
			this.encendida = true;
			// Itero las farolas de la lista
			for (Farola f : this.neightborFarolas) {
				f.turnOn();
			}
		}
	}
	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.encendida) {
			this.encendida = false;
			// Itero las farolas de la lista
			for (Farola f : this.neightborFarolas) {
				f.turnOff();
			}
		}
	}
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.encendida;
	}
	
	
}
