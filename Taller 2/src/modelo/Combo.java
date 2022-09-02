package modelo;

import java.util.ArrayList;


public class Combo {
	private String nombre;
	
	private double descuento;
	
	private ArrayList<Object> producto;
	
	public Combo(String elNombre, double elDescuento, ProductoMenu hamburguesa, ProductoMenu papitas, Bebida bebida) {
		this.nombre = elNombre;
		this.descuento = elDescuento;
		
		
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public void agregarItemAcombo(){
		
	}
}	

