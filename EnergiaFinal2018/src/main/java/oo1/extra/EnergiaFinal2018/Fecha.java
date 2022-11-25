package oo1.extra.EnergiaFinal2018;

public class Fecha {
	private int mes;
	private int anio;
	
	public Fecha(int mes, int anio) {
		this.mes = mes;
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public int getAnio() {
		return anio;
	}

	public Fecha minusMonth() {
		if (this.mes == 1) {
			return new Fecha(12, this.anio - 1);
		}
		return new Fecha(this.mes - 1, this.anio);
	}
	
	public Fecha minusYears(int years) {
		return new Fecha(this.mes, this.anio - 1);
	}
	
	public boolean isEqual(Fecha fecha) {
		return this.mes == fecha.getMes() & this.anio == fecha.getAnio();
	}
}
