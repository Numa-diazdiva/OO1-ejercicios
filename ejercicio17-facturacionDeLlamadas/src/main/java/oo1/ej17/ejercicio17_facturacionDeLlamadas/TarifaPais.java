package oo1.ej17.ejercicio17_facturacionDeLlamadas;

public class TarifaPais {
	private String nombre;
	private double tarifaNocturna, tarifaDiurna;
	
	public TarifaPais(String nombre, double tarifaNocturna, double tarifaDiurna) {
		this.nombre = nombre;
		this.tarifaDiurna = tarifaDiurna;
		this.tarifaNocturna = tarifaNocturna;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getTarifaNocturna() {
		return tarifaNocturna;
	}


	public void setTarifaNocturna(double tarifaNocturna) {
		this.tarifaNocturna = tarifaNocturna;
	}


	public double getTarifaDiurna() {
		return tarifaDiurna;
	}

	public void setTarifaDiurna(double tarifaDiurna) {
		this.tarifaDiurna = tarifaDiurna;
	}
}
