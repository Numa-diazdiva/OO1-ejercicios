package oo1.ej9.ejercicio9_cuentaConGanchos;

public abstract class Cuenta {
	private double saldo;
	
	public Cuenta() {
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double monto) {
		this.saldo += monto;
	}
	// Protected para que puedan acceder las subclases sin que sea pública
	protected void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
	
	// Va a ser menester implementarlo en las subclases, sino el compilador nos va a avisar.
	protected abstract boolean puedeExtraer(double monto);
	
	public boolean extraer(double monto) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	// El this va a ser la instancia de la clase que reciba el mensaje -CDA o CC-
	// Debería poder transferirse a cualquier subclase de Cuenta
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}
	
}
