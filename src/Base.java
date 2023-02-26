
/**
 * 
 * En esta clase se crean bases a partir de sus elementos necesarios.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * @version 1.0 
 * @see java.lang.Object
 */
public class Base {
	
	//Atributos
	private String tipo;
	private boolean gluten;
	private double precio;
	private String tamanio;
	
	
	//Constructor
	/**
	 * 
	 * Constructor que inicializa una base de la clase Base, con sus respectivos parámetros: <b>tipo</b>, <b>gluten</b>, 
	 * <b>precio</b> y <b>tamaño</b>.
	 * 
	 * @param tipo          Tipo de grosor de la base de la pizza.
	 * @param gluten        Parámetro que decreta si tal base contiene gluten o no.
	 * @param precio        Coste de la base.
	 * @param tamanio       Dimensiones de la base.
	 */
	Base(String tipo, boolean gluten, double precio, String tamanio) {
		
		
		setGluten(gluten);
		setPrecio(precio);
		setTamanio(tamanio);
		setTipo(tipo);
	}
	
	
	//Getters y Setters
	
	/**
	 * 
	 * Getter del atributo tipo.
	 * Se obtiene el tipo de grosor establecido para la base.
	 * 
	 * @return         El tipo de grosor de la base.
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * 
	 * Setter del atributo tipo.
	 * Se establece el tipo de grosor para la base.
	 * 
	 * @param tipo     El tipo de grosor de la base.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * 
	 * Getter del atributo gluten.
	 * Se obtiene el resultado de comprobar si la base contiene gluten o no.
	 * 
	 * @return         Devuelve (true/false) si la base contiene gluten o no. 
	 */
	public boolean isGluten() {
		return gluten;
	}
	
	/**
	 * 
	 * Setter del atributo gluten.
	 * Se establece si la base de la pizza contiene gluten o no.
	 * 
	 * @param gluten   True/false para establecer el estado de la base, con gluten o no.
	 */
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	
	/**
	 * 
	 * Getter del atributo precio.
	 * Se obtiene el precio establecido para la base.
	 * 
	 * @return         El precio de la base.
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * 
	 * Setter del atributo precio.
	 * Se establece el precio de la base.
	 *  
	 * @param precio   La cantidad de dinero que cuesta la base.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * 
	 * Getter del atributo tamanio.
	 * Se obtiene el tamaño que tiene la base.
	 * 
	 * @return          El tamaño de la base.
	 */
	public String getTamanio() {
		return tamanio;
	}
	
	/**
	 * 
	 * Setter del atributo tamanio.
	 * Se establece el tamaño de la base.
	 * 
	 * @param tamanio   Las dimensiones de la base.
	 */
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
}
