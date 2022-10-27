package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class PersonaJuridica extends Cliente{
	private int CUIT;
	private String tipo;
	
	public PersonaJuridica(String nombre, String direccion, NroTelefono numeroDeTelefono, int CUIT, String tipo) {
		super(nombre, direccion, numeroDeTelefono);
		this.CUIT = CUIT;
		this.tipo = tipo;
	}

	public int getCUIT() {
		return this.CUIT;
	}

	public String getTipo() {
		return this.tipo;
	}

	public Factura facturarLlamadas(LocalDateTime from, LocalDateTime to) {
		double monto = this.llamadasEntreFechas(from, to).stream().mapToDouble(llamada -> llamada.calcularCosto()).sum();
		return new Factura(this, from, to, monto);
	}
}
