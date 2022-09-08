package oo1.ej4.ejercicio4_figurasYCuerpos;

public class Cuerpo3D {
	
	private Figura2D caraBasal;
	private double altura;
	
	public Cuerpo3D(double altura, Figura2D caraBasal){
		this.altura = altura;
		this.caraBasal = caraBasal;
	}
	
	public Cuerpo3D() {}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(Figura2D caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public Figura2D getCaraBasal() {
		return this.caraBasal;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea() * this.altura;
	}
	
	public double getSuperficieExterior() {
		return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.altura;
	}
	
}
