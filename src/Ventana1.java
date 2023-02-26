

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * 
 * En esta clase se maneja la <b>Vista</b> de la primera ventana, donde se visualiza el historial de ordenes.
 * 
 *@author Lian Salmerón López 
 *@author María Teresa Rodríguez Gómez
 *
 *@version 1.0
 **/


public class Ventana1 extends JFrame {

	//Atributos
	private JPanel contentPane;
	private JButton btnVolverPrincipal;
	private JScrollPane scrollPane;
	private JTextField textConfirmarPedido;
	private JLabel LabelBusquedaPedido;
	private JButton btnConfirmar;
	private JTextArea textHistorial;
	private JButton btnEliminarPedido;

	/**
	 * 
	 * Constructor que inicializa el contenido de la ventana 1.
	 * 
	 */
	public Ventana1() {
		
		//Se establece el título de la ventana 1
		setTitle("Ventana 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Se establecen las dimensiones de la ventana 1
		setBounds(300, 50, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[24.00px][20.00][13.00,grow][35][35,grow][grow][63.00][24.00][][][35][][grow][35.00,grow][31.00][grow][grow][][grow][grow][35.00,grow][35.00,grow][][][grow][35.00][35.00][][][][]", "[20.00px][grow][28.00,grow][][grow][][][][][][][][][][][][][][]"));
		//Se establece el color del fondo a negro
		getContentPane().setBackground(Color.black);
		
		//Se añade
		textHistorial = new JTextArea();
		textHistorial.setEditable(false);
		
		 try {
		    	//El JTextArea lee el contenido del fichero
				textHistorial.read(new BufferedReader(new FileReader("HistorialPedidos.txt")), null);
				//Se establece el estilo de letra
				Font font = new Font("Arial", Font.BOLD, 20);
				textHistorial.setFont(font);
				
				
			} catch (Exception e) {
				System.out.println("Error: El fichero no se ha podido encontrar");
			}
		
		
		
		scrollPane = new JScrollPane(textHistorial);
		contentPane.add(scrollPane, "cell 3 1 23 2,grow");
		
		//Boton para confirmar la llegada del pedido
		btnConfirmar = new JButton("Confirmar entrega");
		contentPane.add(btnConfirmar, "cell 17 7,alignx center,aligny center");
		
		
		LabelBusquedaPedido = new JLabel("Busqueda del pedido:");
		LabelBusquedaPedido.setForeground(Color.WHITE);
		contentPane.add(LabelBusquedaPedido, "cell 6 8,growx");
		
		//Texto donde se escribe el pedido a buscar/eliminar etc
		textConfirmarPedido = new JTextField();
		contentPane.add(textConfirmarPedido, "cell 7 8 8 1,growx");
		textConfirmarPedido.setColumns(10);
		
		//Boton para eliminar el pedido deseado
		btnEliminarPedido = new JButton("Eliminar pedido");
		contentPane.add(btnEliminarPedido, "cell 17 9,growx,aligny center");
		
		
		//Boton para volver a la ventana Principal
		btnVolverPrincipal = new JButton("Volver al principal");
		contentPane.add(btnVolverPrincipal, "cell 0 17 31 2,growx,aligny center");
		
		
	}

	
	
	//Getters y Setters
	
	/**
	 * 
	 * Getter del botón btnEliminarPedido.
	 * 
	 * @return           El botón para eliminar un pedido.
	 */
	public JButton getBtnEliminarPedido() {
		return btnEliminarPedido;
	}


	public void setBtnEliminarPedido(JButton btnEliminarPedido) {
		this.btnEliminarPedido = btnEliminarPedido;
	}


	/**
	 * 
	 * Getter del elemento TextHistorial.
	 * 
	 * @return                  El contenido que se encuentra en el área de texto.
	 */
	public JTextArea getTextHistorial() {
		return textHistorial;
	}
	
	/**
	 * 
	 * Setter del elemento TextHistorial.
	 * 
	 * @param textHistorial        El texto que se desea mostrar en el área de texto.
	 *                             El texto tiene que ser del mismo tipo (JTextArea).  
	 */
	public void setTextHistorial(JTextArea textHistorial) {
		this.textHistorial = textHistorial;
	}

	/**
	 * 
	 * Getter del elemento TextConfirmarPedido.
	 * 
	 * @return                      El contenido que se encuentra en el área de texto.
	 */
	public JTextField getTextConfirmarPedido() {
		return textConfirmarPedido;
	}

	/**
	 * 
	 * Setter del elemento TextConfirmarPedido.
	 * 
	 * @param textConfirmarPedido    El texto que se desea mostrar en el área de texto. 
	 *                               El texto tiene que ser del mismo tipo (JTextField).  
	 */
	public void setTextConfirmarPedido(JTextField textConfirmarPedido) {
		this.textConfirmarPedido = textConfirmarPedido;
	}

	/**
	 * 
	 * Getter del botón btnConfirmar.
	 * 
	 * @return          El botón para confirmar un pedido.
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}


	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	/**
	 * 
	 * Getter del botón btnVolverPrincipal
	 * 
	 * @return           El botón para volver a la ventana principal.
	 */
	public JButton getBtnVolverPrincipal() {
		return btnVolverPrincipal;
	}

	
	public void setBtnVolverPrincipal(JButton btnVolverPrincipal) {
		this.btnVolverPrincipal = btnVolverPrincipal;
	}
		

}
