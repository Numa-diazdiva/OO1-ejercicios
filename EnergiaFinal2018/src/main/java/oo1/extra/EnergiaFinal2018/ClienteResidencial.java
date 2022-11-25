package oo1.extra.EnergiaFinal2018;

public class ClienteResidencial extends Cliente {
	private String apellido;
	
	public ClienteResidencial(String nombre, String apellido, String direccion) {
		super(nombre, direccion);
		this.setApellido(apellido);
	}
	
	public double calcularMontoAFacturar(Fecha fecha, Tarifario tarifario) {
		Medicion medicion = this.buscarMedicion(fecha);
		double monto = medicion.getConsumoUE() * tarifario.getValorUEResidencial();
		return monto - this.descuento(medicion, tarifario.getDescuentoResidencial(), monto);
	}
	
	public double descuento(Medicion medicion, double porcentajeDescuento, double monto) {
		Medicion medicionAnterior = this.buscarMedicion(medicion.anioAnterior());
		
		if (medicionAnterior != null) {
			if(medicionAnterior.compararMedicion(medicion) <= 0) {
				return 0;
			}
		}
		return monto * porcentajeDescuento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
