package oo1.parcial1.spootify;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SpootifyTest {

	private Album album1, album2;
	private Spootify spoti;
	private Musico musico;
	
	@BeforeEach
	void setUp() {
		this.spoti = new Spootify();
		album1 = new Album("asdfge", LocalDate.of(1987, 2, 12));
		album2 = new Album("asdfg", LocalDate.of(2020, 1, 10));
		this.musico = new Musico("palbito");
		this.spoti.agregarAlbum(album1);
		this.spoti.agregarAlbum(album2);
	}
	
	void agregarTemas() {
		album1.agregarTema(new Tema("asdg", "asdg", 12, musico));
		album1.agregarTema(new Tema("asdg", "asdg", 56, musico));
		album1.agregarTema(new Tema("asdg", "asdg", 1, musico));
		album1.agregarTema(new Tema("asdg", "asdg", 2, musico));
		album1.agregarTema(new Tema("asdg", "asdg", 5, musico));
		
		
		album2.agregarTema(new Tema("asdg", "asdg", 12, musico));
		album2.agregarTema(new Tema("asdg", "asdg", 56, musico));
		album2.agregarTema(new Tema("asdg", "asdg", 1, musico));
		album2.agregarTema(new Tema("asdg", "asdg", 2, musico));
		album2.agregarTema(new Tema("asdg", "asdg", 5, musico));
		
	}
	
	
	@Test
	void testTemasDelAño() {
		agregarTemas();
		assertEquals(5, album1.getTemas().size());
		//assertEquals(1987, album1.getAño());
		//assertEquals(5, spoti.getAlbumes().get(0).getTemas().size());
		//assertEquals(5, spoti.temasDelAño(1987).size());
		//assertTrue(spoti.temasDelAño(0));
	}
	
	@Test
	void tesAlbumesDelAño(){
		agregarTemas();
		assertEquals(1, spoti.albumesDelAño(1987).size());
	}
	
}
