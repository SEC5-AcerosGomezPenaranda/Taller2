package modelo;

public class Ingrediente {
	private String nombre;
	
	private int precio;
	
	private int calorias;
	
	public Ingrediente(String elNombre, int elPrecio, int laCalo) {
		this.nombre = elNombre;
		this.precio = elPrecio;
		this.calorias = laCalo;
	}
	
	
	public String darNombre() {
		return nombre;
	}
	
	public int darPrecio() {
		return precio;
	}
	
	public int darCalorias() {
		return calorias;
	
	}
	
	
}
