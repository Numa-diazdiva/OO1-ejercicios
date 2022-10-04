package oo1.ej9.ejercicio9_cuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	
	public void depositar(double monto) {
		// El depósito también tiene cargo de servicio
		super.depositar(monto * 0.98);
	}
	
	// El problema de la caja de ahorro es que podemos chequear que tenga saldo para hacer la extracción o transferencia,
	// pero, dónde quemamos el saldo que se come el banco?
	public boolean extraer(double monto) {
		if (super.extraer(monto)) {
			this.extraerSinControlar(monto * 0.02); // Accedo a este protejido para sacar la tasa de servicio
			return true;
		}
		return false;
	}
	
	public boolean transferirACuenta(double monto, Cuenta cuenta) {
		if (super.transferirACuenta(monto, cuenta)) {
			this.extraerSinControlar(monto * 0.02);
			return true;
		}
		return false;
	}
	
	protected boolean puedeExtraer(double monto) {
		if ((monto * 1.02) <= this.getSaldo()) {
			return true;
		}
		return false;
	}
	
}
