package oo1.ej4.ejercicio4_figurasYCuerpos;

public class Circulo implements Figura2D {
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public Circulo() {}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public void setDiametro(double diametro) {
		this.radio = diametro / 2;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public double getDiametro() {
		return this.radio * 2;
	}
	
	public double getPerimetro() {
		return this.getDiametro() * Math.PI;
	}
	
	public double getArea() {
		return Math.pow(this.radio, 2) * Math.PI;
	}
	
}
