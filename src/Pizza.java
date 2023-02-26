

import java.util.Vector;

/**
 * 
 * En esta clase se crean pizzas, a partir de los elementos requeridos.
 * 
 * @author Lian Salmer�n L�pez
 * @author Mar�a Teresa Rodr�guez G�mez
 * @version 1.0
 * @see java.lang.Object
 */

public class Pizza {
	
	//Atributos
	private String nombre_pizza;
	private Base base;
	private Vector<Ingrediente> ingredientes;
	
	//Constructor
	
	/**
	 * 
	 * Constructor que inicializa una pizza de la clase Pizza con sus respectivos par�metros: <b>nombre_pizza</b>, 
	 * la <b>base</b> y el <b>ingrediente</b>.
	 * 
	 * @param nombre_pizza       Nombre de la pizza que se ha pedido.
	 * @param base               Base con la que est� creada la pizza.
	 * @param ingrediente        Ingrediente que se le ha a�adido a la pizza.
	 */
	Pizza(String nombre_pizza, Base base, Ingrediente ingrediente) {
		this.nombre_pizza = nombre_pizza;
		
		this.base = base;
		
		this.ingredientes = new Vector<Ingrediente>();
		
		this.ingredientes.add(ingrediente);
	}
	
	
	//M�todos
	
	/**
	 * 
	 * M�todo que permite a�adir un ingriente al vector ingredientes.
	 * 
	 * @param ingrediente       El ingrediente que se desee a�adir.
	 */
	public void ponerIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}
	
	/**
	 * 
	 * M�todo que permite poner una base.
	 * 
	 * @param base               La base que se desee poner.   
	 */
	public void ponerBase(Base base) {
		this.base = base;
	}
	
	/**
	 * 
	 * M�todo que calcula el coste de la pizza.
	 * 
	 * @return                   Coste de la pizza, sumando su base y sus ingredientes.
	 */
	public double calcularCostePizza() {
		double coste = base.getPrecio();
		
		for (int i=0; i< this.ingredientes.size(); i++) {
			coste += this.ingredientes.get(i).getPrecio();
		}
		
		return coste;
	}
	
	/**
	 * 
	 * M�todo que comprueba si la pizza es apta o no para personas cel�acos.
	 * 
	 * @return                   True/false del resultado de la comprobaci�n si la pizza es apta o no para celiacos.
	 */
	public boolean aptaCeliacos() {
		boolean esApta =true;
		
		if (this.base.isGluten()) {
			esApta = false;
		}
		else {
			int i = 0;
			
			while(esApta & i<this.ingredientes.size()) {
				esApta = !this.ingredientes.get(i).isGluten();
				i++;
			}
		}
		
		return esApta;
	}
	
	//Getters y Setters 
	
	/**
	 * 
	 * Getter del atributo nombre_pizza.
	 * Se obtiene el nombre de la pizza que se ha establecido.
	 * 
	 * @return                El nombre de la pizza.
	 */
	public String getNombre_pizza() {
		return nombre_pizza;
	}
	
	/**
	 * 
	 * Setter del atributo nombre_pizza.
	 * Se establece el nombre de la pizza que se ha pedido.
	 * 
	 * @param nombre_pizza     El nombre de la pizza.
	 */
	public void setNombre_pizza(String nombre_pizza) {
		this.nombre_pizza = nombre_pizza;
	}
	
	/**
	 * 
	 * Getter del atributo base.
	 * Se obtiene la base que se ha fijado para la pizza.
	 * 
	 * @return                 La base de la pizza.
	 */
	public Base getBase() {
		return base;
	}
	
	/**
	 * 
	 * Setter del atributo base.
	 * Se establece una base para la pizza.
	 * 
	 * @param base             La base para la pizza.
	 */
	public void setBase(Base base) {
		this.base = base;
	}
	
	/**
	 * 
	 * Getter del vector, de la clase Ingrediente, ingredientes.
	 * Se obtienen los ingredientes del vector.
	 * 
	 * @return                 Los ingredientes del vector.
	 */
	public Vector<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	/**
	 * 
	 * Setter del vector, de la clase Ingrediente, ingredientes.
	 * Se a�aden los ingredientes al vector.
	 * 
	 * @param ingredientes    Los ingredientes que se desean a�adir al vector.
	 */
	public void setIngredientes(Vector<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
		

}
