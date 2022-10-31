package oo1.ej19.ejercicio19_MercadoDeObjetos;

public class ExpressDomicilio implements Envio {
	private String origen, destino;
	private Mapa mapa;
	private double costoKM;
	
	public ExpressDomicilio(String origen, String destino, Mapa mapa) {
		// Otra opción es mandarlos cuando se desea calcular, pero me parece prudente que el objeto creador se encarge de obtener la información pertinente.
		this.setOrigen(origen);
		this.setDestino(destino);
		this.mapa = mapa;
		this.costoKM = 0.5;	
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	public double calcularCosto() {
		return this.mapa.distanciaEntre(this.origen, this.destino) * this.costoKM;
	}
	
}
