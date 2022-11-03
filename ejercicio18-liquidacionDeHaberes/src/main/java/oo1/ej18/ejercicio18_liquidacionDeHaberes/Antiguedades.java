package oo1.ej18.ejercicio18_liquidacionDeHaberes;

public class Antiguedades {
	
	private double antiguedad1, antiguedad2, antiguedad3, antiguedad4;
	
	public Antiguedades() {
		antiguedad1 = 0.3;
		antiguedad2 = 0.5;
		antiguedad3 = 0.7;
		antiguedad4 = 1;
	}
	
	
	public double calcularMontoAntiguedad(int antiguedad, double monto) {
		// Está hórrido
		if(antiguedad >= 5) {
			if(antiguedad >= 10) {
				if(antiguedad >= 15) {
					if(antiguedad >= 20) {
						return monto * antiguedad4;
					}
					return monto * antiguedad3;
				}
				return monto * antiguedad2;
			}
			return monto * antiguedad1;
		}
		return 0;
	}
	
}
