package oo1.ej13.ejercicio13_ClienteDeCorreo;

public class Archivo {
	private String nombre;
	
	public Archivo(String nombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int tamaño() {
		return this.nombre.length();
	}
	
}
