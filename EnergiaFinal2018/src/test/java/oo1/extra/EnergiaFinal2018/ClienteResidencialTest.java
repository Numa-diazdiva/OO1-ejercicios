package oo1.extra.EnergiaFinal2018;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteResidencialTest {
	private Tarifario tarifario;
	private Fecha fecha;
	private Cliente cliente;
	private Medicion medicion1;

	@BeforeEach
	void setUp() {
		this.cliente = new ClienteResidencial("Pablo", "Jeffersen", "12 de Octubre 1234");
		this.fecha = new Fecha(3,2004);
		this.medicion1 = new Medicion(10, fecha);
		this.cliente.registrarMedicion(medicion1);
		this.tarifario = new Tarifario(10, 20, 0.1, 0.02);
	}

	
	// Partición 1
	@Test
	void testMontoAFacturarSinConsumoAnterior(){
		assertEquals(90, this.cliente.calcularMontoAFacturar(fecha, tarifario));
	}
	
	// Partición 2: Casos
	
	// Valor de borde
	@Test
	void testMontoAFacturarConConsumoAnteriorIgual(){
		this.cliente.registrarMedicion(new Medicion(10, new Fecha(3,2003)));
		assertEquals(100, this.cliente.calcularMontoAFacturar(fecha, tarifario));
	}
	@Test
	void testMontoAFacturarConConsumoAnteriorMayor(){
		this.cliente.registrarMedicion(new Medicion(11, new Fecha(3,2003)));
		assertEquals(90, this.cliente.calcularMontoAFacturar(fecha, tarifario));
	}
	@Test
	void testMontoAFacturarConConsumoAnteriorMenor(){
		this.cliente.registrarMedicion(new Medicion(5, new Fecha(3,2003)));
		assertEquals(100, this.cliente.calcularMontoAFacturar(fecha, tarifario));
	}
	
	
}
