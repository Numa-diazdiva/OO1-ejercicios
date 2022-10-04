package oo1.ej9.ejercicio9_cuentaConGanchos;

public class CuentaCorriente extends Cuenta{
	
	private double descubierto;
	
	
	public CuentaCorriente() {
		this.descubierto = 0;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public boolean setDescubierto(double descubierto) {
		if (descubierto >= 0) {
			this.descubierto = descubierto;
			return true;
		}
		return false;
	}
	
	protected boolean puedeExtraer(double monto) {
		if ((this.getSaldo() - monto) >= (this.getDescubierto() * -1)) {
			return true;
		}
		return false;
	}
	
}
