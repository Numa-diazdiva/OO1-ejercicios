package oo1.ej19.ejercicio19_MercadoDeObjetos;

public class PagoEfectivo implements FormaDePago{
	
	
	public double calcularCosto(Producto producto, int cantidad) {
		return producto.getPrecio() * cantidad;
	}
	
}
