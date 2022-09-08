package oo1.ej4.ejercicio4_figurasYCuerpos;

// Podría definir una clase abstracta o una interface para que luego objeto 3D tome como tipo para su cara basal
// La interfaz es más correcta porque el enunciado dice que las clases Cuadrado y Círculo son subclases de Object.
public interface Figura2D {
	public double getPerimetro();
	public double getArea();
}
