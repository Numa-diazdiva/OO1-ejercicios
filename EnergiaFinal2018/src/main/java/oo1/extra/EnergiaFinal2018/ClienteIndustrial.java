package oo1.extra.EnergiaFinal2018;

public class ClienteIndustrial extends Cliente{
	
	public ClienteIndustrial(String nombre, String direccion) {
		super(nombre, direccion);
	}
	
	public double calcularMontoAFacturar(Fecha fecha, Tarifario tarifario) {
		Medicion medicion = this.buscarMedicion(fecha);
		double monto = tarifario.getValorUEIndustrial();
		return monto - this.descuento(medicion, tarifario.getDescuentoIndustrial(), monto);
	}
	
	public double descuento(Medicion medicion, double porcentajeDescuento, double monto) {
		Medicion medicionAnterior = this.buscarMedicion(medicion.mesAnterior());
		
		if (medicionAnterior != null) {
			if (medicionAnterior.compararMedicion(medicion) < 0) {
				return monto * porcentajeDescuento;
			}
		}
		return 0;
	}
	
}
