package oo1.extra.EnergiaFinal2018;

public class Medicion {
	private int consumoUE;
	private Fecha fecha;
	
	public Medicion(int consumo, Fecha fecha) {
		this.consumoUE = consumo;
		this.fecha = fecha;
	}

	public int getConsumoUE() {
		return consumoUE;
	}

	public Fecha getFecha() {
		return fecha;
	}
	
	public int compararMedicion(Medicion medicion) {
		return this.consumoUE - medicion.getConsumoUE();
	}
	
	public Fecha mesAnterior() {
		return this.fecha.minusMonth();
	}
	
	public Fecha anioAnterior() {
		return this.fecha.minusYears(1);
	}
	
	public boolean delLaFecha(Fecha fecha) {
		return this.fecha.isEqual(fecha);
	}
}
