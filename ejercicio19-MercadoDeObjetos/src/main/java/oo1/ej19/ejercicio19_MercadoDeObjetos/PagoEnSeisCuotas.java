package oo1.ej19.ejercicio19_MercadoDeObjetos;

public class PagoEnSeisCuotas implements FormaDePago{

	private double interes;
	
	public PagoEnSeisCuotas() {
		interes = 0.2;
	}
	
	public double calcularCosto(Producto producto, int cantidad) {
		double montoParcial = producto.getPrecio() * cantidad; 
		return montoParcial + montoParcial * interes;
	}
	
}
