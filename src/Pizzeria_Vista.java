

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * 
 * Esta clase maneja la <b>Vista</b> del M-V-C, siendo esta la ventan principal.
 * 
 *@author Lian Salmerón López
 *@author María Teresa Rodríguez Gómez
 *@version 1.0
 *
 */

public class Pizzeria_Vista {

	//Atributos
	private JFrame frame;
	private JButton btnVisualizar;
	private JButton btnPizzas;
	private JLabel Labelimagen;
	private JTextField textTitulo;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel Labelimagen2;


	/**
	 * 
	 * Constructor que inicializa el contenido de la vista.
	 * 
	 */
	public Pizzeria_Vista() {
		initialize();
		
	}
	
	
	   /**
	    * 
	    * Método que permite visualizar la ventana principal.
	    * 
	    * @param estado        Estado de visualización de la ventana
	    *                      true: para que sea visible
	    *                      false: para que no sea visible
	    */

		// Para poner en modo visible la vista
		public void setVisible(boolean estado) {
			this.frame.setVisible(estado);
		}

		
	
	/**
	 * 
	 * Metódo donde se inicializa el contenido de la vista
	 * 
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		//Se establece el nombre de la ventana
		frame.setTitle("Ventana Principal");
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Medidas de la ventana: x, y, anchura, altura
		frame.setBounds(300, 50, 700, 600);
		
		frame.getContentPane().setLayout(new MigLayout("", "[160px][160px,grow][][160px]", "[30px][48px,grow][48px]"));
		frame.getContentPane().setBackground(Color.black);
		
		//Se crea un area de texto para desplegar el catalogo
	    textArea = new JTextArea();
	    textArea.setEditable(false);
	    try {
	    	//El JTextArea lee el contenido del fichero
			textArea.read(new BufferedReader(new FileReader("pizzas.txt")), null);
			//Se establece el estilo de letra
			Font font = new Font("Segoe Script", Font.BOLD, 20);
			textArea.setFont(font);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "No se ha podido encontrar el fichero deseado ",
					"Error" , JOptionPane.ERROR_MESSAGE);
		}
        
        
	    //Se le añade al catálogo un scroll
        scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, "cell 1 1,grow");
		
		
		
		
		
		//Boton para visualizar ordenes
		btnVisualizar = new JButton("Visualizar ordenes");
		
		frame.getContentPane().add(btnVisualizar, "cell 0 2,grow");

		//Boton para ordenar pizzas
		btnPizzas = new JButton("Ordenar Pizzas");
		frame.getContentPane().add(btnPizzas, "cell 3 2,grow");
		
		
		
		//Nombre de la pizzeria
		textTitulo = new JTextField();
		textTitulo.setEditable(false);
		textTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textTitulo.setText("MOSTOCHELY");
		frame.getContentPane().add(textTitulo, "cell 1 0,grow");
		textTitulo.setColumns(10);
		
		
		//Se añaden dos JLabel a los lados de las ventanas
		Labelimagen = new JLabel();
	        
		Labelimagen.setBounds(0, 0, 696, 573);
		Labelimagen.setIcon(new ImageIcon("pizzas1.jpg"));
		frame.getContentPane().add(Labelimagen, "cell 0 1,growy");
		
		
		Labelimagen2 = new JLabel("");
		Labelimagen2.setIcon(new ImageIcon("pizzas2.jpg"));
		frame.getContentPane().add(Labelimagen2, "cell 3 1");
		
		
		
	}
	
	
	//Getters y Setters


	/**
	 * 
	 * Getter del elemento JTextArea.
	 * 
	 * @return             El texto que se encuentra el área de texto.
	 */
	public JTextArea getTextArea() {
		
		return textArea;
	}
	
	/**
	 * 
	 * Setter del elemento JTextArea.
	 * 
	 * @param textArea     El texto que se desea mostrar en el JTextArea.
	 *                     El texto tiene que ser del mismo tipo (JTextArea).
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
		
	}


	/**
	 * 
	 * Getter del botón btnVisualizar.
	 * 
	 * @return             El botón btnVisualizar.
	 */
	public JButton getBtnVisualizar() {
		return btnVisualizar;
	}
	
	
	public void setBtnVisualizar(JButton btnVisualizar) {
		this.btnVisualizar = btnVisualizar;
	}


	/**
	 * 
	 * Getter del botón btnPizzas.
	 * 
	 * @return             El botón btnPizzas
	 */
	public JButton getBtnPizzas() {
		return btnPizzas;
	}
	
	
	public void setBtnPizzas(JButton btnPizzas) {
		this.btnPizzas = btnPizzas;
	}


}
