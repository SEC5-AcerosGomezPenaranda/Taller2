package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class Restaurante {

	private List<Combo> combos;
	
	private List<Ingrediente> ingredientes;

	private List<ProductoMenu> productos;
	
	private List<Bebida> bebidas;
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye una calculadora de estadísticas, guardando la información
	 * proporcionada sobre atletas, países y eventos.
	 * 
	 * @param atletas Un mapa con los atletas, donde las llaves son los nombres de
	 *                los atletas y los valores son los atletas.
	 * @param paises  Un mapa con los países, donde las llaves son los nombres de
	 *                los países y los valores son los países.
	 * @param eventos Una lista con los eventos.
	 */
	public Restaurante(Map<String, Combo> combos, Map<String, Ingrediente> ingredientes, Map<String, ProductoMenu> productos, Map<String, Bebida> bebidas)
	{
		this.combos = new ArrayList<Combo>(combos.values());
		this.ingredientes = new ArrayList<Ingrediente>(ingredientes.values());
		this.productos = new ArrayList<ProductoMenu>(productos.values());
		this.bebidas = new ArrayList<Bebida>(bebidas.values());
		System.out.print(combos.get("combo corral"));
	}
	
	/**
	 * Retorna el atleta con el nombre indicado
	 * 
	 * @param nombreAtleta El nombre del atleta que se está buscando
	 * @return El atleta con el nombre dado o null si no se encuentra.
	 */
	private Bebida buscarbebida(String nombrebebida)
	{
		Bebida laBebida = null;
		for (int i = 0; i < bebidas.size() && laBebida == null; i++)
		{
			if (bebidas.get(i).darNombre().equals(nombrebebida)) {
		
				laBebida = bebidas.get(i);
			}
		}
		return laBebida;
	}

		
	/** Mostrar menú**/
	public void mostrarCombos() {
		System.out.println("\n");
		System.out.println("ESTOS SON LOS COMBOS: \n");
		for (int i = 0; i < combos.size(); i++)
		{
			int x = i+1;
			System.out.println((x)+ ". "+ combos.get(i).darNombre());
			
		}
		
	}
	public void mostrarProductos() {
		System.out.println("\n");
		System.out.println("ESTOS SON LOS PRODUCTOS: \n");
		for (int i = 0; i < productos.size(); i++)
		{
			int x = i+1;
			System.out.println((x)+ ". "+ productos.get(i).darNombre() + " PRECIO: "+ productos.get(i).darPrecio() + " CAL: "+ productos.get(i).darCalorias() );
			
		}
		
	}
	public void mostrarBebidas() {
		System.out.println("\n");
		System.out.println("ESTOS SON LAS BEBIDAS: \n");
		for (int i = 0; i < bebidas.size(); i++)
		{
			int x = i+1;
			System.out.println((x)+ ". "+ bebidas.get(i).darNombre() + " PRECIO: "+ bebidas.get(i).darPrecio() + " CAL: "+ bebidas.get(i).darCalorias() );
			
		}
		
	}
	
}

