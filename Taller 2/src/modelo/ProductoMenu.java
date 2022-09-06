package modelo;

public class ProductoMenu {
	
	private String nombre;
	
	private int precio;
	
	private int calorias;
	
	public ProductoMenu(String elNombre, int elPrecio, int laCalo) {
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
