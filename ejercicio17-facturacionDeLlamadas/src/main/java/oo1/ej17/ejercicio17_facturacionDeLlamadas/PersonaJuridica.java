package oo1.ej17.ejercicio17_facturacionDeLlamadas;

public class PersonaJuridica extends Cliente{
	private int dni;
	
	public PersonaJuridica(String nombre, String direccion, NroTelefono numeroDeTelefono, int dni) {
		super(nombre, direccion, numeroDeTelefono);
		this.dni = dni;
	}
	
	
	
}
