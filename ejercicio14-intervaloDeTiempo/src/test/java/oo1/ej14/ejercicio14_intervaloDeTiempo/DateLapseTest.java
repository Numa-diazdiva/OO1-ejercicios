package oo1.ej14.ejercicio14_intervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DateLapseTest {
	private LocalDate date1, date2;
	private DateLapse dateLapse;
	
	@BeforeEach
	void setUp() {
		date1 = LocalDate.of(2001, 6, 12);
		date2 = LocalDate.of(2001, 6, 17);
		dateLapse = new DateLapse(date1,date2);
	}
	
	@Test
	void testSizeInDays() {
		assertEquals(5, dateLapse.sizeInDays());
		DateLapse dateLapse2 = new DateLapse(date2, date1);
		assertEquals(-5, dateLapse2.sizeInDays());
	}
	
	@Test
	void testIncludesDateOK() {
		LocalDate date3 = LocalDate.of(2001, 6, 15);
		assertTrue(dateLapse.includesDate(date3));
		date3 = LocalDate.of(2001, 6, 12);
		assertTrue(dateLapse.includesDate(date3));
		date3 = LocalDate.of(2001, 6, 17);
		assertTrue(dateLapse.includesDate(date3));
	}
	
	@Test
	void testIncludesDateFail() {
		LocalDate date3 = LocalDate.of(2001, 6, 19);
		assertFalse(dateLapse.includesDate(date3));	
		date3 = LocalDate.of(2001, 6, 11);
	}
}
