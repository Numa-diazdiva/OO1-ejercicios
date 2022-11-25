package oo1.extra.EnergiaFinal2018;

public class Tarifario {
	private double valorUEResidencial;
	private double valorUEIndustrial;
	private double descuentoResidencial;
	private double descuentoIndustrial;
	
	public Tarifario(double valorUEResidencial, double valorUEIndustrial, double descuentoResidencial, double descuentoIndustrial) {
		this.valorUEResidencial = valorUEResidencial;
		this.valorUEIndustrial = valorUEIndustrial;
		this.descuentoResidencial = descuentoResidencial;
		this.descuentoIndustrial = descuentoIndustrial;
	}

	public void actualizarValoresUE(double pR, double pI) {
		this.valorUEResidencial = pR;
		this.valorUEIndustrial = pI;
	}
	
	public double getValorUEResidencial() {
		return valorUEResidencial;
	}

	public void setValorUEResidencial(double valorUEResidencial) {
		this.valorUEResidencial = valorUEResidencial;
	}

	public double getValorUEIndustrial() {
		return valorUEIndustrial;
	}

	public void setValorUEIndustrial(double valorUEIndustrial) {
		this.valorUEIndustrial = valorUEIndustrial;
	}

	public double getDescuentoResidencial() {
		return descuentoResidencial;
	}

	public void setDescuentoResidencial(double descuentoResidencial) {
		this.descuentoResidencial = descuentoResidencial;
	}

	public double getDescuentoIndustrial() {
		return descuentoIndustrial;
	}

	public void setDescuentoIndustrial(double descuentoIndustrial) {
		this.descuentoIndustrial = descuentoIndustrial;
	}
	

	
}
