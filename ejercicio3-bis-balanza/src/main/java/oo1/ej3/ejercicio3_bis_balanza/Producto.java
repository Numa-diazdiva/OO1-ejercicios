package oo1.ej3.ejercicio3_bis_balanza;

public class Producto{
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto(double peso, double precioKilo, String desc){
		this.setPeso(peso);
		this.setPrecioPorKilo(precioKilo);
		this.setDescripcion(desc);
	}
	
	public Producto(){
		
	}
	
	public void setPeso(double nuevoPeso){
		this.peso = nuevoPeso;
	}
	
	public void setPrecioPorKilo(double nuevoPrecio){
		this.precioPorKilo = nuevoPrecio;
	}
	
	public void setDescripcion(String desc){
		this.descripcion = desc;
	}
	
	public double getPeso(){
		return this.peso;
	}
	
	public double getPrecioPorKilo(){
		return this.precioPorKilo;
	}
	
	public double getPrecio(){
		return this.precioPorKilo * this.peso;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
}