

/**
 * 
 * En esta clase se cean ingredientes, a partir de los elementos requeridos.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * @version 1.0 
 * @see java.lang.Object
 */
public class Ingrediente {
	
	//Atributos
	private String nombre;
	private boolean gluten;
	private double precio;
	
	//Constructor
	
	/**
	 * 
	 * Constructor que inicializa un ingrediente de la clase Ingrediente, con sus respectivos parámetros: <b>nombre</b>, 
	 * <b>gluten</b>, <b>precio</b>.
	 * 
	 * @param nombre     Nombre del ingrediente.
	 * @param gluten     Parámetro que decreta si tal ingrediente contiene gluten o no.
	 * @param precio     Coste del ingrediente.
	 */
	public Ingrediente(String nombre, boolean gluten, double precio) {
		this.nombre = nombre;
		this.gluten = gluten;
		this.precio = precio;
	}
	
	//Getters y Setters 
	
	/**
	 * 
	 * Getter del atributo nombre.
	 * Obtiene el nombre del ingrediente.
	 * 
	 * @return          Nombre del ingrediente.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * Setter del atributo nombre.
	 * Establece el nombre del ingrediente.
	 * 
	 * @param nombre    Nombre del ingrediente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * Getter del atributo gluten.
	 * Se obtiene el resultado de comprobar si el ingrediente contiene gluten o no.
	 * 
	 * @return          Devuelve (true/false) si la base contiene gluten o no. 
	 */
	public boolean isGluten() {
		return gluten;
	}
	
	/**
	 * 
	 * Setter del atributo gluten.
	 * Se establece si el ingrediente contiene gluten o no.
	 *    
	 * @param gluten   True/false para establecer el estado del ingrediente, con gluten o no.
	 */
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	
	/**
	 * 
	 * Getter del atributo precio.
	 * Se obtiene el precio establecido para el ingrediente.
	 * 
	 * @return          El precio del ingrediente.
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * 
	 * Setter del atributo precio.
	 * Se establece el precio del ingrediente.
	 * 
	 * @param precio    El precio del ingrediente.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
