package oo1.ej19.ejercicio19_MercadoDeObjetos;

public class Pedido {
	private Producto producto;
	private Cliente cliente;
	private int cantidad;
	private FormaDePago formaDePago;
	private Envio formaDeEnvio;

	public Pedido(Producto producto, Cliente cliente, int cantidad, FormaDePago formaDePago, Envio formaDeEnvio) {
		this.producto = producto;
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.setFormaDePago(formaDePago);
		this.setFormaDeEnvio(formaDeEnvio);
	}

	public Producto getProducto() {
		return producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	public Envio getFormaDeEnvio() {
		return formaDeEnvio;
	}

	public void setFormaDeEnvio(Envio formaDeEnvio) {
		this.formaDeEnvio = formaDeEnvio;
	}
	
	
	public double calcularCosto() {
		return formaDePago.calcularCosto(this.producto, this.cantidad) + this.formaDeEnvio.calcularCosto();
	}
	
	

}
