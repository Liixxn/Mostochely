

import java.util.Date;
import java.util.Vector;

/**
 * 
 * En esta clase se crean ordenes, a partir delos elementos requeridos.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * @version 1.0
 * @see java.lang.Object
 */

public class Orden {
	
	//Atributos
	private String nombre;
	private String direccion;
	private String telefono;
	private Date fecha_pedido;
	private Vector<Pizza> pizzas;
	private boolean entregado;
	
	
	//Constructores
	
	
	/**
	 * 
	 * Constructor que inicializa una orden de la clase Orden. Donde se crea un vector de pizzas de la clase Pizza.
	 * 
	 */
	Orden () {
		this.pizzas = new Vector<Pizza>();
	}
	
	/**
	 * 
	 * Constructor que inicializa una orden de la clase Orden, con sus respectivos parámetros: <b>nombre</b>, <b>direccion</b>,
	 * <b>teléfono</b>, <b>fecha_pedido</b>, el número de <b>pizzas</b> deseadas y una comprobación de si ha 
	 * si <b>entregado</b> o no la orden.
	 * 
	 * @param nomnbre        Nombre de la orden, para identificarla de una manera más fácil.
	 * @param direccion      Información del destino del pedido. 
	 * @param telefono       Información del usuario para contactar con él.
	 * @param fecha_pedido   Fecha en la que se realizó el pedido.
	 * @param pizzas         Número de pizzas que se pidieron.
	 * @param entregado      Comprobación si el pedido ha sido entregado o falta por entregar.
	 */
	public Orden(String nomnbre, String direccion, String telefono, Date fecha_pedido, Vector <Pizza> pizzas, boolean entregado) {
		this.direccion = direccion;
		this.fecha_pedido = fecha_pedido;
		this.pizzas = pizzas;
		this.entregado = entregado;
	}
	
	
	//Métodos
	
	/**
	 * 
	 * Método que añade una pizza creada al vector <b>pizzas</b>.
	 * 
	 * @param pizza        Una pizza de la clase Pizza.
	 */
	public void aniadirPizza (Pizza pizza) {
		this.pizzas.add(pizza);
	}
	
	
	/**
	 * 
	 * Método que elimina la última pizza que se encuentra en el vector <b>pizzas</b>.
	 * 
	 */
	public void eliminarUltimaPizza() {
		if (this.pizzas.size() > 0) {
			this.pizzas.remove(this.pizzas.size()-1);
		}
	}
	
	
	/**
	 * 
	 * Método que calcula el coste de las pizzas que se encuentran dentro del vector <b>pizzas</b>. 
	 * 
	 * @return              El coste total de las diferentes pizzas, sumando los costes de las bases
	 *                      con los ingredientes.
	 */
	public double calcularCostePedido() {
		double coste = 0;
		
		for(int i=0; i< this.pizzas.size(); i++) {
			coste += this.pizzas.get(i).calcularCostePizza();
		}
		
		return coste;	
	}
	
	
	/**
	 * 
	 * Método que confirma que la orden ha llegado a su destino.
	 * 
	 */
	public void confirmarRecepcion() {
		this.entregado = true;
	}
	
	
	//Getters y Setters
	
	
	/**
	 * 
	 * Getter del atributo nombre
	 * Obtiene el nombre que se le fijó a la orden.
	 * 
	 * @return           El nombre del pedido.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * Setter del atributo nombre.
	 * Establece el nombre de la orden.
	 * 
	 * @param nombre     Nombre que se le desea fijar a la orden.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * Getter del atributo dirección.
	 * Obtiene la dirección fijada como destino del pedido.
	 * 
	 * @return           Lugar de destino del pedido.
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * 
	 * Setter del atributo dirección.
	 * Se establece la dirección de destino del pedido
	 * 
	 * @param direccion  Lugar de destino del pedido.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * Getter del atributo teléfono.
	 * Se obtiene el número de contacto del usuario.
	 * 
	 * @return            Número de contacto del usuario.
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * 
	 * Setter del atributo teléfono.
	 * Establece el número de contacto del usuario.
	 *  
	 * @param telefono     Número de contacto del usuario.    
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * 
	 * Getter del atributo fecha_pedido.
	 * Se obtiene la fecha en la que se realizó el pedido.
	 * 
	 * @return             La fecha cuando se realizó el pedido.
	 */
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	
	/**
	 * 
	 * Setter del atributo fecha_pedido.
	 * Se establece una fecha en la que se realizó el pedido.
	 * 
	 * @param fecha_pedido La fecha cuando se realizó el pedido.
	 */
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	
	/**
	 * 
	 * Getter del Vector, de la clase Pizza, pizzas.
	 * Se obtienen las pizzas que se encuentran en el vector.
	 * 
	 * @return             Las pizzas que asociadas al vector.
	 */
	public Vector<Pizza> getPizzas() {
		return pizzas;
	}
	
	/**
	 * 
	 * Setter del vector, de la calse Pizza, pizzas.
	 * Se añaden pizzas al vector.
	 * 
	 * @param pizzas        Las pizzas que se desean asociar al vector.
	 */
	public void setPizzas(Vector<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	/**
	 * 
	 * Getter del atributo entregado.
	 * Se obtiene el resultado de comprobar si el pedido ha sido entregado o no.
	 * 
	 * @return               Devuelve true/false si el pedido ha sido entregado o no.
	 */
	public boolean isEntregado() {
		return entregado;
	}
	
	/**
	 * 
	 * Setter del atributo entregado.
	 * Se establece si la orden ha sido entregado o no.
	 * 
	 * @param entregado     True/false para establecer es estado de la orden, entregada o no.
	 */
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
}
