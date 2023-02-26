
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;


/**
 * En esta clase se maneja la lógica del sistema, que permite gestionar una pizzeria.
 *
 *@author Lian Salmerón López
 *@author María Teresa Rodríguez Gómez
 *@version 1.0
 *@see java.lang.Object
 */


public class Pizzeria_Modelo {
	
	//Atributos
	
	private Vector <Ingrediente> ingredientes;
	private Vector <Pizza> pizzas;
	private Vector <Orden> ordenes;
	private Vector <Base> bases;

	
	//Constructores
	/**
	 *Inicializa los distintos contenedores (Vectores) donde se almacenan: bases, ingredientes, pizzas y ordenes.
	 *@see java.util.Vector
	 */
	public Pizzeria_Modelo() {
		this.bases = new Vector <Base>();
		this.ingredientes = new Vector <Ingrediente>();
		this.pizzas = new Vector <Pizza>();
		this.ordenes = new Vector <Orden>();
		
	}
	
	/**
	 * 
	 *Inicializa los distintos contenedores (Vectores) que recibe, en los cuales se almacenan: bases, ingredientes, pizzas y ordenes.
	 *
	 * @param ordenes                  Los pedidos que un usuario realiza para pedir un cierto número de pizzas.
	 * @param pizzas                   Las pizzas que el usuario desea pedir.
	 * @param ingredientes             Los ingredientes que el usuario desea añadir a sus pizzas.
	 *  
	 * @see java.util.Vector
	 */
	public Pizzeria_Modelo(Vector <Orden> ordenes, Vector <Pizza> pizzas, Vector <Ingrediente> ingredientes) {
		this.ordenes = ordenes;
		this.pizzas = pizzas;
		this.ingredientes = ingredientes;
		
	}
	
	
	
	//Métodos

	/**
	 * 
	 * Método que crea una pizza con un <b>nombre</b>, <b>base</b> e <b>ingrediente</b> en el sistema.
	 * El nombre de la pizza debe coincidir con las pizzas que aparecen en fichero <i>pizzas.txt</i>
	 * sino es el caso, la pizza no podrá ser añadida a la orden.
	 * 
	 * @param nombre          Nombre de la pizza, mostrado en el catálogo de la aplicación
	 * @param base            La base elegida por el usuario, guardadas dentro del Vector
	 *                        <b>ingredientes</b>, donde se guardan todos los ingredientes disponibles. 
	 * @param ingrediente     Ingrediente elegido por el usuario, el cual se encunetra dentro del contenedor.
	 *                        (Vector) <b>ingredientes</b>, donde se guardan todos los ingredientes disponibles.
	 * @return                El Vector <b>pizzas</b>, donde se guardan todas las pizzas que el usuario.
	 *                        desee añadir.
	 */
	
	//Se  crea una pizza con la base e ingrediente selecionados
	public Vector<Pizza> CrearPizza(String nombre, Base base, Ingrediente ingrediente) {
		
		//Se crea una pizza, al que se le pasan la base y el ingrediente
		Pizza pizza = new Pizza(nombre, base, ingrediente);
		//Se añade al vector pizzas
		this.pizzas.add(pizza);

		return pizzas;
	}
	
	
	/**
	 * 
	 * Método que crea un pedido/orden a partir de un <b>nombre</b>, una <b>dirección</b>, un <b>telefóno</b>, 
	 * una <b>fecha</b> del pedido, las <b>pizzas</b> deseadas por el usuario y si el pedido ha sido <b>entregado</b>.
	 * En el cúal, se van añadiendo las pizzas que habían sido guardadas en el Vector <b>pizzas</b>.
	 * A su vez este pedido/orden
	 * 
	 * @param nombre        Nombre del usuario, usado para denominar su orden.
	 * @param direccion     Información del destino del pedido.
	 * @param telefono      Información del usuario para contactar con él. 
	 * @param fecha         Fecha en la que se realizó el pedido.
	 * @param pizzas        Número de pizzas que se pidieron.
	 * @param entregado     Comprobación si el pedido ha sido entregado o falta por entregar.
	 * @return              El vector <b>ordenes</b>, donde se guarda toda la información recogida
	 *                      sobre el pedido y sus características.
	 *                      
	 * @see java.io.FileWriter
	 * @see java.io.BufferedWriter
	 */
	
	//Se crea un pedido donde se van añadiendo las pizzas requeridas
	public Vector <Orden> CrearOrden(String nombre, String direccion, String telefono, Date fecha, Vector <Pizza> pizzas, boolean entregado) {
		
		int j=0;
		//Se crea un pedido al cual se le pasa lo que necesita
		Orden orden = new Orden(nombre, direccion, telefono, new Date(), pizzas, entregado);
		//Se añade al vector orden
		this.ordenes.add(orden);
		
		String pizza = "";
		//Se recorre el vector pizzas para conseguir el nombre de las pizzas elegidas
		for (j=0; j<this.pizzas.size(); j++) {
			pizza += this.pizzas.get(j).getNombre_pizza()+", ";
		}
		
		
		 try {
			    
				BufferedWriter fichero = null;
				//Escribirá en el fichero
				fichero = new BufferedWriter(new FileWriter("HistorialPedidos.txt", true)); 
				
				//Escribimos en el fichero los datos del pedido
				fichero.write(nombre+";"+direccion+";"+telefono+";"
				+pizza+";"+fecha+";"+false);
				fichero.newLine();
				fichero.flush();
			    fichero.close();
			  
			}
			catch (IOException e) {
				System.out.println("ERROR. Fichero no encontrado.");
			} 
		 return ordenes;
	}
	
	

	/**
	 * 
	 * Método que calcula el coste de la pizza que se desea crear a partir de una <b>base</b> y un <b>ingrediente</b>.
	 * 
	 * @param base                  La base elegida por el usuario, en la lista desplegable.
	 * @param ingrediente           El ingrediente elegido por el usuario, en la lista desplegable.
	 * @return                      El coste de la pizza.
	 */
	//Se calcula el coste de todo el pedido
	public String CalcularCoste(double base, double ingrediente) {

        double coste = 0;
        String precio = "";
              
        coste = base + ingrediente;
        precio= Double.toString(coste);

        return precio;
    }
	
	
	
	/**
	 * 
	 * Método que comprueba que el número de teléfono del usuario es correcto.
	 * 
	 * 
	 * @param telefono          Número de contacto del usuario.
	 * @return                  True/false, si el número de teléfono introducido por el usuario contiene el formato correcto.
	 */
	public boolean comprobarTelefono(String telefono) {
		boolean numeroCorrecto = false;
		
        try {
        	//Pasa a int el numero de teléfono
            Integer.parseInt(telefono);
            numeroCorrecto = true;
        } catch (NumberFormatException e) {
        	numeroCorrecto = false;
            
        }
        return numeroCorrecto;
    }

	
	/**
	 * 
	 * Método que busca en el historial de pedidos a partir del <b>nombre</b>, para confirmar que un pedido
	 * ha sido entregado.
	 * 
	 * @param nombre     Nombre del pedido, para modifificar su estado y cerciorarse de que ha sido entregado.
	 * @return           True/false si el pedido a confirmar se ha encontrado o no.
	 * 
	 */
	
	//Se confirma que el pedido ha sido entregado
	public boolean ConfirmarPedido(String nombre) {
		
		String [][] datos;
		boolean correcto = false;
		boolean pedido_encontrado = false;
		
		try {
			//El contenido del fichero se guarda en el array
			datos = leerFichero("HistorialPedidos.txt");
			
			//Se recorre el array
			for (int i=0; i<datos.length; i++) {
				for (int j=0; j<datos[0].length; j++) {
					//Se comprueba que el pedido exista en el contenido del historial
					if (datos[i][j].equals(nombre)) {
						pedido_encontrado = true;
						correcto = true;
						//Se cambia el estado del pedido a entregado
						datos[i][5] = "true";
						
	
					}
				}
			}
			//Se guardan los datos en el fichero
			guardar_matriz(datos, "HistorialPedidos.txt");
			//Si el pedido no existe en el fichero
			if (pedido_encontrado==false) {
				correcto = false;
			}
			
		} catch (FileNotFoundException e) {
			
		}
		return correcto;
	}
	
	
	
	/**
	 * 
	 * Método que elimina el pedido deseado del fichero <i>HistorialPedidos.txt</i>. 
	 * 
	 * @param nombre         Nombre del pedido a eliminar.
	 * @return               True/false si el pedido a eliminar se ha encontrado o no.
	 */
	//Elimina el pedido deseado
	public boolean EliminarPedido(String nombre) {
		
        String [][] datos = {};
        String [][] nuevosdatos = {};
        int correccion_fila = 0;
        int i = 0;
        int j = 0;
        int numFila = 0;
        boolean correcto = false;
        boolean pedidoEncontrado = false;

        
        try {
        	//El contenido del fichero se guarda en el array
            datos = leerFichero("HistorialPedidos.txt");
           
            //Se establecen las dimensiones del nuevo array
            nuevosdatos = new String [datos.length-1][datos[0].length];
            //Se recorre el array datos, donde se encuentra el contenido del fichero
            for (i=0; i<datos.length; i++) {
                for (j=0; j<datos[0].length; j++) {
                	//Se comprueba que el pedido exista en el contenido del historial
                    if (datos[i][j].equals(nombre)) {
                    	//Si es así la variable numFila guardará la posición en la que se ecuentra el pedido
                    	pedidoEncontrado = true;
                    	 correcto = true;
                        numFila = i;
                    }

                }
            }
            //Si el nombre del pedido no existe
            if (pedidoEncontrado==false) {
            	correcto = false;
            }
            else {
            
            //Se recorre el array de datos
            for (i = 0; i < datos.length;i++) {
            	//Si i es igual a la posición donde se encontraba el pedido
                if(numFila == i) {
                    correccion_fila = -1;
                }
                //Si no es igual se copia el contenido de datos al nuevo array menos la fila del pedido
                else {
                    nuevosdatos[i+correccion_fila] = datos[i];
                }
            }
            //Se guardan los cambios en el fichero
            guardar_matriz(nuevosdatos, "HistorialPedidos.txt");
            }
            
        } catch (FileNotFoundException e) {
        	

        }
        
        return correcto;
    }
	
	

	/**
	 * 
	 * Método que lee el contenido de un fichero y se vuelca en un array, para poder manejar los datos
	 * fácilmente. Para poder obtener tal array, se encesitan sus dimensiones, obtenidas por los métodos
	 * <i>contarLineas()</i> y <i>contarColumnas()</i>.
	 * 
	 * @param ruta           Ruta/nombre del fichero deseado a leer.
	 * @return               El contenido del fichero en un array, para su fácil empleo
	 * @throws               FileNotFoundException si no se pudo encontra el fichero deseado.
	 * 
	 * 
	 */
	

	//Lee el contenido de lfichero y lo vuelva en un array
	public String[][] leerFichero(String ruta) throws FileNotFoundException {
		
		
		int filas = contarLineas(ruta);
		int columnas = contarColumnas(ruta);
		String[][] salida; // Reservamos espacio para cada linea
		int i = 0;
		int j;
		
		File fichero = new File(ruta);
		salida = new String[filas][columnas];
			Scanner leer = new Scanner(fichero);
			
			//Las lineas del fichero se van volcando al array
			for (i=0; i<salida.length; i++) {
				String linea = leer.nextLine(); 	// "1;4;5"
				String[] valores = linea.split(";");// {"1.0","4","5"} 
				
				salida[i] = valores;
				
			}
			leer.close();
			
		return salida;
	}
	
	
	/**
	 * 
	 * Método que cuenta las líneas de un fichero, usando la clase Scanner
	 * 
	 * @param ruta         Ruta/nombre del fichero deseado a leer.
	 * @return             El número de líneas escritas en el fichero.
	 * @see                java.util.Scanner
	 */

	
	//Cuenta las lineas del fichero
	public int contarLineas(String ruta) {
		int lineas = 0;
		// Usamos Scanner para contar las lineas
		try {
			Scanner fichero = new Scanner(new File(ruta));
			while (fichero.hasNextLine()) {
				lineas++;
				fichero.nextLine();
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las lineas de " + ruta);
		}
		return lineas;
	}
	
	
	/**
	 * 
	 * Método que cuenta las columnas de un fichero. Se usa el método <i>split("delimitador")</i> para
	 * conseguir el número de columnas.
	 * 
	 * @param ruta          Ruta/nombre del fichero deseado a leer.
	 * @return              El número de columnas en el fichero.
	 * 
	 */
	
	
	//Cuenta las columnas en el fichero
	public int contarColumnas(String ruta) {
		int columnas = 0;
		String primeraLinea = "";

		// Usamos Scanner para contar las lineas
		try {
			Scanner fichero = new Scanner(new File(ruta));
			if (fichero.hasNextLine()) {
				primeraLinea = fichero.nextLine();
			}
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error contando las columnas de " + ruta);
		}
		
		
		// primeraLinea algo de este estilo: "3.5;-4.0;88.0"  | ";;"
		columnas = primeraLinea.split(";").length;
		
		// Para resolver el problema del split si datos, solo ;
		// es el caso de ";;;...;"
		if (columnas == 0) {
			columnas = primeraLinea.lastIndexOf(';')+2; // posición del último ; 
		}

		return columnas;
	}
	
	
	
	/**
	 * 
	 * Método que guarda el contenido del array en el fichero deseado.
	 * 
	 * @param matriz        Array que se brinda para copiar su contenido al fichero deseado.
	 * @param ruta          Ruta/nombre del fichero al que se desea pasar el contenido. 
	 */
	
	//Guardar la matriz en ruta
    public void guardar_matriz(String[][] matriz, String ruta) {
		
		FileWriter fichero;
    	try {
			fichero = new FileWriter(ruta);
			//Se recorre el array
			for (int i=0; i<matriz.length; i++) {
				for (int j=0; j<matriz[i].length; j++) {
					//Se va copiando el contenido del array al fichero
					fichero.write("" + matriz[i][j]);
					if (j != matriz[i].length-1) {
						fichero.write(";");
					}
					
				}
				fichero.write("\n");
			} 
			fichero.close();
			
		} catch (IOException e) {
			System.out.println("ERROR en el guardado de la matriz.");
		}
	}

	


    
    
	//Getters y Setters	
    
  
	/**
	 * 
	 * Getter del Vector, de la clase Ingrediente, ingredientes.
	 * 
	 * @return              Los ingredientes escogidos para la creacción de la pizza.
	 */
	public Vector<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	
	/**
	 * 
	 * Setter del Vector, de la calse Ingrediente, ingredientes.
	 * 
	 * @param ingredientes   Los ingredientes que se quieren asociar al vector
	 */
	public void setIngredientes(Vector<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * 
	 * Getter del Vector, de la clase Pizza, pizzas.
	 * 
	 * @return              Las pizzas que fueron añadidas al vector.
	 */
	public Vector<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * 
	 * Setter del Vector, de la clase Pizza, pizzas.
	 * 
	 * @param pizzas        Las pizzas que se quieren asociar al vector.
	 */
	public void setPizzas(Vector<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	/**
	 * 
	 * Getter del Vector, de la clase Orden, ordenes.
	 * 
	 * @return              Los ordenes que se añadieron al vector.
	 */
	public Vector<Orden> getOrdenes() {
		return ordenes;
	}

	/**
	 * 
	 * Setter del Vector, de la clase Orden, ordenes.
	 * 
	 * @param ordenes       Los ordenes que se quieren asociar al vector.
	 */
	public void setOrdenes(Vector<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	/**
	 * 
	 * Getter del Vector, de la clase Base, bases.
	 * 
	 * @return              Las bases que se añadieron al vector
	 */
	public Vector<Base> getBases() {
		
		return bases;
	}

	/**
	 * 
	 * Setter del Vector, de la clase Base, bases 
	 * 
	 * @param bases        Las bases que se quieren asociar al vector.
	 */
	public void setBases(Vector<Base> bases) {
		this.bases = bases;
	}
	
}

	

