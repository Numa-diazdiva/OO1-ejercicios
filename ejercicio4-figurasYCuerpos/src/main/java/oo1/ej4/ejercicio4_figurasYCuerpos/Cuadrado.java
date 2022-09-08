package oo1.ej4.ejercicio4_figurasYCuerpos;

public class Cuadrado implements Figura2D {
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}
	
	public Cuadrado() {}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double getPerimetro(){
		return this.lado * 4;
	}
	
	public double getArea() {
		return Math.pow(lado, 2);
	}
}
