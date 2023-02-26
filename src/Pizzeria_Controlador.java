

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * En esta clase se maneja el <b>Controlador</b> del M-V-C, siendo este el que establece la conexión entre la vista
 * y el modelo. 
 * 
 *@author Lian Salmerón López 
 *@author María Teresa Rodríguez Gómez
 *
 *@version 1.0
 *@see Pizzeria_Modelo
 *@see Pizzeria_Vista
 *@see Ventana1
 *@see Ventana2
 **/


public class Pizzeria_Controlador {
	
	//Atributos 
	Pizzeria_Vista ventanaPrincipal;
	Ventana1 ventana1;
	Ventana2 ventana2;
	Pizzeria_Modelo modelo;
	
	
	//Constructor 
	
	/**
	 * 
	 * Constructor que inicializa el controlador de la pizzeria, con sus respectivos parámetros con los que interactua:
	 * las diferentes ventanas (Vista); <b>ventanaPrincipal</b>, <b>ventana1</b>, <b>ventana2</b> y los datos (Modelo) 
	 * <b>modelo</b>.
	 * 
	 * @param ventanaPrincipal          Vista de la ventana principal, que se inicializa en la clase <b>Pizzeria_Modelo</b>.
	 * @param ventana1                  Vista de la ventana 1, que se inicializa en la calse <b>Ventana1</b>.
	 * @param ventana2                  Vista de la ventana 2, que se inicializa en la calse <b>Ventana2</b>.
	 * @param modelo                    Modelo de datos, de la calse <b>Pizzeria_Modelo</b>, donde se guarda la lógica del
	 *                                  sistema.
	 */
	public Pizzeria_Controlador(Pizzeria_Vista ventanaPrincipal, Ventana1 ventana1, Ventana2 ventana2, Pizzeria_Modelo modelo) {
		
		this.ventana1 = ventana1;
		this.ventana2 = ventana2;
		this.ventanaPrincipal = ventanaPrincipal;
		this.modelo = modelo;
		
		//Se crean los listeners que desembocarán en diferentes acciones.
		crearListeners();
		
		//La ventan principal se establece como visible
		this.ventanaPrincipal.setVisible(true);
		
	}
	
	//Métodos
	
	/**
	 * 
	 * Método que ejecuta una acción dependiendo de con qué, el usuario haga contacto. 
	 * 
	 */
	private void crearListeners() {
		
		//---- Listeners Ventana Principal ----//
		//El usuario pulsa el boton de visualizar pedidos se sacara la ventana 1
		this.ventanaPrincipal.getBtnVisualizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana1AbrirVentana();
				
			}
		});
		
		//El usuario pulsa el boton de ordenar pizzas se sacara la ventana 2
		this.ventanaPrincipal.getBtnPizzas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana2Nuevo();
				
			}
		});

	
	
		//---- Listeners Ventana1 ----//
		//El usuario pulsa el boton de volver a la ventana principal se sacara la ventana principal
		this.ventana1.getBtnVolverPrincipal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VolverVentanaPrincipal();
				
				}
			});
		
		//Boton para confirmar la llegada del pedido
		this.ventana1.getBtnConfirmar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarLlegada();
			}
		});
		
		//Boton para eliminar el pedido deseado
		this.ventana1.getBtnEliminarPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarPedido();
			}
		});
		
			
			//---- Listeners Ventana2 ----//	
			//El usuario pulsa el boton de volver a la ventana principal se sacara la ventana principal
		this.ventana2.getBtnVolverPrincipal2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VolverVentanaPrincipal();
				
				}
			});
		
		//El usuario elige el elemento de la lista de bases
		this.ventana2.getListBases().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				jListBasesValueChanged(event);
				
			}
			
		});
		
		//El usuario elige el elemento de la lista de ingredientes
		this.ventana2.getListIngredientes().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				jListIngredientesValueChanged(event);
	           }
			
		});
		
		//Se crea la pizza aniadiendola al vector de orden
		this.ventana2.getBtnCrearPizza().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearPizza();
				
				}
			});
		
		//Se crea un orden aniadiendolo al vector ordenes
		this.ventana2.getBtnConfirmarPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarPedido();
			}
		});
		
		
	}
			
			
	
	
	//Vuelve a la ventana principal
	
	/**
	 * 
	 * Método que establece visible la ventana principal y las demás se establecen ocultas.
	 * 
	 */
	private void VolverVentanaPrincipal() {
		this.ventana1.setVisible(false);
		this.ventana2.setVisible(false);
		this.ventanaPrincipal.setVisible(true);
		
		}
	
	
	//Abre la ventana 1
	
	/**
	 * 
	 * Método que hace visible la ventana 1 y la ventana principal se establece oculta.
	 * 
	 */
	private void ventana1AbrirVentana() {
		this.ventana1.setVisible(true);
		this.ventanaPrincipal.setVisible(false);
		
		}
	
	//Confirmar la llegada del pedido
	
	/**
	 * 
	 * Método que confirma la llegada de un pedido, estableciendo el atributo <b>entregado</b> de la orden a true.
	 * 
	 */
	private void confirmarLlegada() {
		
		//Si no hay ningún pedido a confirmar, se saca un mensaje de error
		if (this.ventana1.getTextConfirmarPedido().getText().isEmpty()) {
			 JOptionPane.showMessageDialog(this.ventana1.getContentPane(), "No se ha podido confirmar su pedido. "
				 		+ "\nCompruebe que ha rellenado el campo", "Error" , JOptionPane.ERROR_MESSAGE);
		}
		else {
			//Se recoge el nombre escrito
			String nombre_pedido = this.ventana1.getTextConfirmarPedido().getText();
			this.modelo.ConfirmarPedido(nombre_pedido);
			
		try {
			//Se lee el fichero y se muestra en el JtextArea
			this.ventana1.getTextHistorial().read(new BufferedReader(new FileReader("HistorialPedidos.txt")), null);
		} catch (Exception e) {
			
			}
			
		}
	}
	
	
	//Elimina el pedido deseado
	
	/**
	 * 
	 * Método que elimina un pedido del fichero <i>HistorialPedidos</i>.
	 * 
	 */
	private void eliminarPedido() {
		
		String pedido= "";
		//Se obtiene el nombre del pedido
		pedido = this.ventana1.getTextConfirmarPedido().getText();
		
		//Si no hay ningún pedido a eliminar, se saca un mensaje de error.
		if (this.ventana1.getTextConfirmarPedido().getText().isEmpty()) {
			 JOptionPane.showMessageDialog(this.ventana1.getContentPane(), "No se ha podido eliminar el pedido. "
				 		+ "\nCompruebe que ha rellenado el campo", "Error" , JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			//Se elimina el pedido
		    this.modelo.EliminarPedido(pedido);
		try {
			//Se lee el fichero y se muestra en el JTextArea.
			this.ventana1.getTextHistorial().read(new BufferedReader(new FileReader("HistorialPedidos.txt")), null);
		} catch (Exception e) {
			
			}
		}
		
	}
	
	
	//Abre la ventana 2
	
	/**
	 * 
	 * Método que hace visible la ventana 2 y oculta la ventana principal.
	 * 
	 */
	private void ventana2Nuevo() {
		this.ventana2.setVisible(true);
		this.ventanaPrincipal.setVisible(false);
	}
	
	
	
	//Recoge la seleccion de base escogida por el usuario
	
	/**
	 * 
	 * Método que recoge la selección del usuario de la lista de bases.
	 * 
	 * @param evt           El elemento que elige el usuario.
	 */
	 private void jListBasesValueChanged(ListSelectionEvent evt) {
		    if (!this.ventana2.getListBases().getValueIsAdjusting()) {
		    	this.ventana2.getTextBase().setText((String)this.ventana2.getListBases().getSelectedValue());
		       
		  }
		}
	 
	 
	 //Recoge la seleccion de ingrediente el egida por el usuario
	 
	 /**
	  * 
	  * Método que recoge la selección del usuario de la lista de ingredientes.
	  * 
	  * @param event         El elemento que elige el usuario.
	  */
	 private void jListIngredientesValueChanged(ListSelectionEvent event) {
		  if (!this.ventana2.getListIngredientes().getValueIsAdjusting()) {
		       this.ventana2.getTextIngrediente().setText((String)this.ventana2.getListIngredientes().getSelectedValue());
		  }	  
        }
	 
	 
	 //Confirmar el pedido 
	 
	 /**
	  * 
	  * Método que confirma el pedido, añadiéndolo al historial de ordenes.
	  * 
	  */
	 private void confirmarPedido() {
		 
		 String nombre = "";
		 String direccion = "";
		 String telefono = "";
		 
		 //Se recogen en las variables lo escrito o seleccionado por el usuario en la ventana 2
		 nombre = this.ventana2.getTextNombre().getText();
		 direccion = this.ventana2.getTextDireccion().getText();
		 telefono = this.ventana2.getTextTelefono().getText();
		 
		 //Si todos los campos no llegan a estar rellenos, se saca un mensaje de error.
		 if (this.ventana2.getTextNombre().getText().isEmpty() | this.ventana2.getTextDireccion().getText().isEmpty() 
			 | this.ventana2.getTextTelefono().getText().isEmpty()) {
			 
			 JOptionPane.showMessageDialog(this.ventana2.getContentPane(), "No se ha podido confirmar su pedido. "
			 		+ "\nCompruebe que ha rellenado todos los campos", "Error" , JOptionPane.ERROR_MESSAGE);
		 
		 }
		 else if (this.modelo.comprobarTelefono(telefono)==false) {
			 JOptionPane.showMessageDialog(this.ventana2.getContentPane(), "El número de teléfono es incorrecto. "
				 		+ "\nVuelva a escribir su teléfono.", "Error" , JOptionPane.ERROR_MESSAGE);
			 
			 
		 }
		 else {
			 //Se crea un orden con los datos recogidos
			 this.modelo.CrearOrden(nombre, direccion, telefono, new Date(), this.modelo.getPizzas(), false);
			 
			 try {
				 //Se lee el fichero y se añade tal orden al JTextArea
				this.ventana1.getTextHistorial().read(new BufferedReader(new FileReader("HistorialPedidos.txt")), null);
				JOptionPane.showMessageDialog(this.ventana2.getContentPane(), "Se ha confirmado su pedido.",
						"Informativo", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e) {

			}
			 //Se vacía el contenido de los vectores, para nuevas y próximas ordenes
			 this.modelo.getOrdenes().removeAllElements();
			 this.modelo.getPizzas().removeAllElements();
		 }
		 
		 
	 }
	 
	 
	 //Se crea la pizza
	 
	 /**
	  * 
	  * Método que crea una pizza, con la base e ingrediente seleccionados por el usuario.
	  * 
	  */
	 private void crearPizza() {
		 
		 String nombre = "";
		 String coste = "";
		 
		 String datos[][] = {};
		 boolean pizza_encontrada = false;
		//Se recoge el nombre de la pizza
		 nombre = this.ventana2.getTextNombrePizza().getText();
		 
		 
		 try {
			 //Se lee el contenido del fichero
			datos = this.modelo.leerFichero("pizzas.txt");
			for (int i=0; i<datos.length; i++) {
				for (int j=0; j<datos[0].length; j++) {
					//Se comprueba que tal pizza exista
				    if (datos[i][j].equals(nombre)) {
					pizza_encontrada = true;
					
					
					 
					 //Si no se han rellenado los campos necesarios para la creación de la pizza, se saca un mesaje de error
					 if (this.ventana2.getListBases().isSelectionEmpty() | this.ventana2.getListIngredientes().isSelectionEmpty() | nombre.isEmpty() 
							 | this.ventana2.getTextNombre().getText().isEmpty() | this.ventana2.getTextDireccion().getText().isEmpty() 
							 | this.ventana2.getTextTelefono().getText().isEmpty()) {
						 JOptionPane.showMessageDialog(this.ventana2.getContentPane(), "Su pizza no se ha podido crear. "
						 		+ "\nCompruebe que ha rellenado todos los campos.", "Error" , JOptionPane.ERROR_MESSAGE);
					 }
					 else {
						//Recoge el indice de la selección deñ usuario
						int base_numero = this.ventana2.getListBases().getSelectedIndex();
						int ingrediente_numero = this.ventana2.getListIngredientes().getSelectedIndex();
						//Se crea la pizza con los datos recogidos
						this.modelo.CrearPizza(nombre,this.modelo.getBases().get(base_numero), this.modelo.getIngredientes().get(ingrediente_numero));
						coste = this.modelo.CalcularCoste(this.modelo.getBases().get(base_numero).getPrecio(), this.modelo.getIngredientes().get(ingrediente_numero).getPrecio());
						this.ventana2.getTextCoste().setText(coste);
						JOptionPane.showMessageDialog(this.ventana2.getContentPane(), "Su pizza se ha creado. "
						 		, "Informativo" , JOptionPane.INFORMATION_MESSAGE);
						
					 }
					 
					
				    }
					
				}
			} 
			//Si el nomnbre de la pizza no se encuentra en el catálogo
			if (pizza_encontrada == false) {
				 JOptionPane.showMessageDialog(this.ventana2.getContentPane(), "El nombre de la pizza es incorrecto. "
					 		+ "\nCompruebe que ha puesto una pizza existente del catálogo.", "Error" , JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (FileNotFoundException e) {
			
		}
	 }
}
		 
			

			
			

