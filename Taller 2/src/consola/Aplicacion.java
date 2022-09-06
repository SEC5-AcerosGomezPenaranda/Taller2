package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import modelo.LoaderComidas;
import modelo.Restaurante;


public class Aplicacion {
	private Restaurante restaurante;
	
	public void ejecutarAplicacion() throws FileNotFoundException, IOException
	{
		
		System.out.println("Estadísticas sobre los Juegos Olímpicos\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarMenu();
				else if (opcion_seleccionada == 2 && restaurante != null)
					ejecutarHacerPedido();
				/*else if (opcion_seleccionada == 3 && calculadora != null)
					ejecutarMedallasEnRango();
				else if (opcion_seleccionada == 4 && calculadora != null)
					ejecutarAtletasPorPais();
				else if (opcion_seleccionada == 5 && calculadora != null)
					ejecutarPaisConMasMedallistas();
					*/

				else if (opcion_seleccionada == 13)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (restaurante == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					
					System.out.println("Por favor seleccione una opción válida.");
					continuar = false;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	
	}

	/**
	 * Muestra al usuario el menú con las opciones para que escoja la siguiente
	 * acción que quiere ejecutar.
	 */
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar menú");
		System.out.println("2. Hacer pedido");
		System.out.println("3. Consultar las medallas de un atleta en un periodo");
		System.out.println("4. Consultar los atletas de un país dado");
		System.out.println("5. Consultar el país con más medallistas");
		System.out.println("13. Salir de la aplicación\n");

		
	}
	
	private void ejecutarCargarMenu() throws FileNotFoundException, IOException
	{
		restaurante = LoaderComidas.cargarArchivo();
		System.out.println("Se cargó el archivo");
		restaurante.mostrarCombos();
		restaurante.mostrarProductos();
		restaurante.mostrarBebidas();
	}
	
	private void ejecutarHacerPedido() throws FileNotFoundException, IOException
	{
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				elegirPedido();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					restaurante.mostrarCombos();
				else if (opcion_seleccionada == 2 && restaurante != null)
					restaurante.mostrarProductos();
				else if (opcion_seleccionada == 3 && restaurante != null)
					restaurante.mostrarBebidas();
				/*else if (opcion_seleccionada == 4 && calculadora != null)
					ejecutarAtletasPorPais();
				else if (opcion_seleccionada == 5 && calculadora != null)
					ejecutarPaisConMasMedallistas();
					*/

				else if (opcion_seleccionada == 0)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					
					System.out.println("Por favor seleccione una opción válida.");
					continuar = false;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}	
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
	public void elegirPedido()
	{
		System.out.println("1. Combo");
		System.out.println("2. Producto individual");
		System.out.println("3. Bebida");
		System.out.println("0. Terminar pedido");
	}

}
