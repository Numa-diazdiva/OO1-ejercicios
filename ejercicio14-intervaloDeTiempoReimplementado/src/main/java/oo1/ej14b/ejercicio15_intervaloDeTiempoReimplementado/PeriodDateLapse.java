package oo1.ej14b.ejercicio15_intervaloDeTiempoReimplementado;

import java.time.LocalDate;

public class PeriodDateLapse implements DateLapse {
	private LocalDate from;
	private int sizeInDays;
	
	public PeriodDateLapse(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.from.plusDays(sizeInDays);
	}
	
	public boolean includesDate(LocalDate other) {
		int comparacion = other.compareTo(this.from);
		return  comparacion >= 0 && comparacion <= this.sizeInDays;
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}
	
}
