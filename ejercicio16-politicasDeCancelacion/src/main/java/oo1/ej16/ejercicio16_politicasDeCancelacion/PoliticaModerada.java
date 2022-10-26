package main.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

public class PoliticaModerada implements PoliticaDeCancelacion{

	private int cantDiasMinimos, cantDiasCambioValor;
	
	public PoliticaModerada() {
		this.cantDiasMinimos = 2;
		this.cantDiasCambioValor = 7;
	}
	
	public double montoAReembolsar(double montoTotal, int diasDeAnticipacion) {
		if (diasDeAnticipacion >= this.cantDiasCambioValor) {
			return montoTotal;
		} else if (diasDeAnticipacion >= this.cantDiasMinimos) {
			return montoTotal * 0.5;
		}
		return 0;
	}
	
}
