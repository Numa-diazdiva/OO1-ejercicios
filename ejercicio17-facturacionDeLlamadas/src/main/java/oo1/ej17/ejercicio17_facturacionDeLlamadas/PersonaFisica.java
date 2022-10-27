package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class PersonaFisica extends Cliente {
	
	private int dni;
	
	public PersonaFisica(String nombre, String direccion, NroTelefono numeroDeTelefono, int dni) {
		super(nombre, direccion, numeroDeTelefono);
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}
	
	public Factura facturarLlamadas(LocalDateTime from, LocalDateTime to) {
		double monto = this.llamadasEntreFechas(from, to).stream().mapToDouble(llamada -> llamada.calcularCosto()).sum() * 0.9;
		return new Factura(this, from, to, monto);
	}
	
}
