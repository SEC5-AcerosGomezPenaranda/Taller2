package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.taller0.modelo.Atleta;
import uniandes.dpoo.taller0.procesamiento.CalculadoraEstadisticas;

import java.io.BufferedReader;

public class LoaderComidas {
	
	

	public static Restaurante cargarArchivo() throws FileNotFoundException, IOException{
		Map<String, Combo> combos = new HashMap<>();
		Map<String, Ingrediente> ingredientes = new HashMap<>();
		Map<String, Producto> productosNormales = new HashMap<>();
		Map<String, Bebida> bebidas = new HashMap<>();
		
		
		
		//Carga del archivo "menu.txt"
		BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"));
		String lineaMenu = br.readLine();
		
		lineaMenu = br.readLine();
		while (lineaMenu != null) {
			String[] partes = lineaMenu.split(";");
			String nombreProducto = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int caloria = Integer.parseInt(partes[2]);
			
			ProductoMenu producto = productosNormales.get(nombreProducto);
			if (producto == null) {
				producto = new ProductoMenu(nombreProducto, precio, caloria);
				productosNormales.put(nombreProducto, producto);
			}
			lineaMenu = br.readLine();
		
		}
		br.close();
		
		//Carga del archivo "bebidas"
		
		BufferedReader br2 = new BufferedReader(new FileReader("data/bebidas.txt"));
		String lineaBeb = br2.readLine();
		
		lineaBeb = br2.readLine();
		while (lineaBeb != null) {
			String[] partes = lineaBeb.split(";");
			String nombreBeb = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int caloria = Integer.parseInt(partes[2]);
			
			Bebida bebidita = bebidas.get(nombreBeb);
			if (bebidita == null) {
				bebidita = new Bebida(nombreBeb, precio, caloria);
				bebidas.put(nombreBeb, bebidita);
			}
			lineaBeb = br2.readLine();
			
			
		
		}
		br2.close();
		
		//carga del archivo "ingredientes"
		
		BufferedReader br3 = new BufferedReader(new FileReader("data/ingredientes.txt"));
		String lineaIng = br3.readLine();
		
		lineaIng = br3.readLine();
		while (lineaIng != null) {
			String[] partes = lineaIng.split(";");
			String nombreIng = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int caloria = Integer.parseInt(partes[2]);
			
			Ingrediente ingre = ingredientes.get(nombreIng);
			if (ingre == null) {
				ingre = new Ingrediente(nombreIng, precio, caloria);
				ingredientes.put(nombreIng, ingre);
			}
			lineaIng = br3.readLine();
		
		}
		br3.close();
		
		//carga del archivo "combos"
		
		BufferedReader br4 = new BufferedReader(new FileReader("data/combos.txt"));
		String lineaCom = br4.readLine();
		
		lineaCom = br4.readLine();
		while (lineaCom != null) {
			String[] partes = lineaCom.split(";");
			String nombreCom = partes[0];
			String descuento = partes[1];
			descuento = descuento.replace("%", "");
			double desc = Double.parseDouble(descuento);
			desc = desc/100;
			String hamburguesa = partes[2];
			String papitas = partes[3];
			String beb = partes[4];
			
			
			
			Combo combi = combos.get(nombreCom);
			if (combi == null) {
				combi = new Combo(nombreCom, desc);
				combos.put(nombreCom, combi);
			}
			lineaCom = br4.readLine();
		
		}

		
		br4.close();
		Restaurante restaurante = new Restaurante(combos, ingredientes, productosNormales, bebidas);
		return restaurante;
		
	}	
	

	
}
