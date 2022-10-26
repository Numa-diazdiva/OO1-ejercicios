package main.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

public class PoliticaFlexible implements PoliticaDeCancelacion{

	public double montoAReembolsar(double montoTotal, int diasDeAnticipacion) {
		if (diasDeAnticipacion > 0) {
			return montoTotal;
		}
		return 0;
	}
	

	
}
