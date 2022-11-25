package oo1.parcial1.spootify;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Spootify {
	private List<Album> albumes;
	private List<Playlist> playlistsDelSistema;
	private List<Usuario> usuarios;
	
	public Spootify() {
		this.albumes = new ArrayList<Album>();
		this.playlistsDelSistema = new ArrayList<Playlist>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	
	public List<Tema> temasDelAño(int año){
		List<Tema> temas = new ArrayList<Tema>();
		List<Album> albums = this.albumes.stream().filter(a -> a.getAño() == año).toList();
		return temas;
	}
	
	public List<Album> albumesDelAño(int año){
		return this.albumes.stream().filter(a -> a.getAño() == año).toList();
	}
	
	
	public void agregarAlbum(Album a) {
		this.albumes.add(a);
	}
	
	public List<Album> getAlbumes(){
		return this.albumes;
	}
	
}
