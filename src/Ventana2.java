

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;


/**
 * 
 * En esta clase se maneja la <b>Vista</b> de la segunda ventana, donde se crean las pizzas.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * 
 * @version 1.0
 *
 */


public class Ventana2 extends JFrame {

	//Atributos
	private JPanel contentPane;
	private JButton btnVolverPrincipal2;
	private JTextField textBase;
	private JTextField textIngrediente;
	private JLabel LabelBase;
	private JLabel LabelIngrediente;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JList listBases;
	private JList listIngredientes;
	private JButton btnCrearPizza;
	private JTextField textNombrePizza;
	private JLabel LabelNombrePizza;
	private JTextField textNombre;
	private JLabel LabelNombre;
	private JLabel LabelDireccion;
	private JTextField textDireccion;
	private JLabel LabelTelefono;
	private JTextField textTelefono;
	private JLabel LabelCoste;
	private JTextField textCoste;
	private JButton btnConfirmarPedido;

	
	
	/**
	 *
	 * Constructor que inicializa el contenido de la ventana 2.
	 *
	 */
	public Ventana2() {
		
		//Se establece el título de la ventana 2
		setTitle("Ventana 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Se establecen las dimensiones de la ventana
		setBounds(300, 50, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[35.00px,grow][35.00,grow][grow][63.00,grow][23.00,grow][35,grow][grow][25.00,grow][47.00,grow][45.00][grow][grow][grow][35,grow]", "[48px][grow][][grow][][grow][][][grow][grow][][][][grow][][][grow][grow][grow][][][][][][42.00][][][][]"));
		//Se establece el color del fondo a negro
		getContentPane().setBackground(Color.black);


		//Lista donde se muestran todas las bases
		listBases = new JList();


		//Se cambia el tipo de letra, tamaño etc...
		listBases.setFont(new Font("Asar", Font.ITALIC, 15));
		//Se lee el fichero bases.txt y se asocia con el JList de las bases
		listBases.setListData(leerLista("bases.txt"));
		//Se configura para que solo se pueda seleccionar una base
		listBases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Se añade la lista a un scroll
		scrollPane = new JScrollPane(listBases);
		contentPane.add(scrollPane, "cell 0 1 4 9,grow");


		//Lista donde se muestran todos los ingredientes
		listIngredientes = new JList();
		
		//Se cambia el tipo de letra, tamaño etc...
		listIngredientes.setFont(new Font("Asar", Font.ITALIC, 15));
		//Se lee el fichero ingredientes.txt y se asocia con el JList de los ingredientes
		listIngredientes.setListData(leerLista("ingredientes.txt"));
		//Se configura para que solo se pueda seleccionar un ingrediente
		listIngredientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Se añade la lista a un scroll
		scrollPane2 = new JScrollPane(listIngredientes);
		contentPane.add(scrollPane2, "cell 9 1 5 9,grow");

		
		LabelBase = new JLabel("Base:");
		LabelBase.setForeground(Color.white);
		contentPane.add(LabelBase, "cell 0 11,alignx center,growy");

		//Texto donde se muestra la base que el usuario seleccionó
		textBase = new JTextField();
		textBase.setEditable(false);
		contentPane.add(textBase, "cell 1 11 3 1,growx");
		textBase.setColumns(10);

		
		LabelIngrediente = new JLabel("Ingrediente:");
		LabelIngrediente.setForeground(Color.white);
		contentPane.add(LabelIngrediente, "cell 9 11,alignx center,growy");

		//Texto donde se muestra el ingrediente que el usuario seleccionó
		textIngrediente = new JTextField();
		textIngrediente.setEditable(false);
		textIngrediente.setColumns(10);
		contentPane.add(textIngrediente, "cell 10 11 4 1,growx");

		//Áreas donde el usuario escribe su información
		textNombrePizza = new JTextField();
		contentPane.add(textNombrePizza, "cell 5 2 3 1,growx");
		textNombrePizza.setColumns(10);
		
		
		LabelNombrePizza = new JLabel("Nombre de la pizza: ");
		LabelNombrePizza.setForeground(Color.white);
		contentPane.add(LabelNombrePizza, "cell 6 1,alignx center");


		LabelNombre = new JLabel("Nombre: ");
		LabelNombre.setForeground(Color.WHITE);
		contentPane.add(LabelNombre, "cell 6 4,alignx center");
		
		//Texto donde escribe su nombre
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 5 5 3 1,growx");
		textNombre.setColumns(10);

		LabelDireccion = new JLabel("Direccion: ");
		LabelDireccion.setForeground(Color.WHITE);
		contentPane.add(LabelDireccion, "cell 6 7,alignx center");
		
		//Texto donde escribe su dirección
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		contentPane.add(textDireccion, "cell 5 8 3 1,growx");

		LabelTelefono = new JLabel("Telefono: ");
		LabelTelefono.setForeground(Color.WHITE);
		contentPane.add(LabelTelefono, "cell 6 10,alignx center");
		
		//Texto donde escribe su número de teléfono
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		contentPane.add(textTelefono, "cell 5 11 3 1,growx");
		
		
		LabelCoste = new JLabel("Coste: ");
		LabelCoste.setForeground(Color.WHITE);
		contentPane.add(LabelCoste, "cell 6 14,alignx center");
		
		//Área que muestra el coste de la pizza
		textCoste = new JTextField();
		textCoste.setEditable(false);
		textCoste.setColumns(10);
		contentPane.add(textCoste, "cell 5 15 3 1,growx");
		
		
		
		//Boton para crear la pizza
		btnCrearPizza = new JButton("Crear Pizza");
		contentPane.add(btnCrearPizza, "cell 9 15,grow");
		
		//Boton para confirmar pedido
		btnConfirmarPedido = new JButton("Confirmar pedido");
		contentPane.add(btnConfirmarPedido, "cell 6 24,growx,aligny center");



		//Boton para volver a la ventana principal
		btnVolverPrincipal2 = new JButton("Volver al principal");
		contentPane.add(btnVolverPrincipal2, "cell 0 27 14 2,grow");


	}



	//Métodos

	/**
	 * 
	 * Método que lee el fichero que se desee y vuelca su contenido en un Vector de tipo String, para su fácil
	 * manejo en los elementos gráficos.
	 * 
	 * @param ruta                Ruta/nombre del fichero deseado a leer.
	 * @return                    El contenido del fichero en un vector de tipo String.
	 */
	private Vector<String> leerLista(String ruta) {
		
		File archivo = null;
		FileReader lectura = null;
		BufferedReader buffer = null;
		Vector<String> lines = new Vector<String>();


		try {
			archivo = new File (ruta);
			lectura = new FileReader (archivo);
			buffer = new BufferedReader(lectura);

			//Las lineas leidas se van añadiendo al vector
			String line;
			while((line=buffer.readLine())!=null) {
				lines.add(line);

			}         

		} catch(Exception e) {

		} finally {
			try{
				if(null != lectura ) {
					lectura.close();
				}
			} catch (Exception e2) {

			}
		}
		return lines;

	}



	//Getters y Setters

	
	/**
	 * 
	 * Getter del botón btnConfirmarPedido
	 * 
	 * @return              El botón para confirmar un pedido.
	 */
	public JButton getBtnConfirmarPedido() {
		return btnConfirmarPedido;
	}

	
	public void setBtnConfirmarPedido(JButton btnConfirmarPedido) {
		this.btnConfirmarPedido = btnConfirmarPedido;
	}

	/**
	 * 
	 * Getter del elemento TextCoste.
	 * 
	 * @return              El precio que se encuentra en el área de texto.
	 */
	public JTextField getTextCoste() {
		return textCoste;
	}

	/**
	 * 
	 * Setter del elemento TextCoste.
	 * 
	 * @param textCoste     El precio que se desea mostrar en el área de texto.
	 */
	public void setTextCoste(JTextField textCoste) {
		this.textCoste = textCoste;
	}

	/**
	 * 
	 * Getter del elemento ListBases.
	 * 
	 * @return             La lista donde se encuentra la información de las bases.
	 */
	public JList getListBases() {
		return listBases;
	}

	/**
	 * 
	 * Setter del elemento ListBases.
	 * 
	 * @param listBases        Las bases que se quieran mostrar en la lista.
	 */
	public void setListBases(JList listBases) {
		this.listBases = listBases;
	}

	/**
	 * 
	 * Getter del elemento ListIngredientes.
	 * 
	 * @return                  La lista donde se encuentra la información de los ingredientes.
	 */
	public JList getListIngredientes() {
		return listIngredientes;
	}

	/**
	 * 
	 * Setter del elemento JListIngredientes.
	 * 
	 * @param listIngredientes   Los ingredientes que se quieren mostrar en la lista.
	 */
	public void setListIngredientes(JList listIngredientes) {
		this.listIngredientes = listIngredientes;
	}

	
	/**
	 * 
	 * Getter del botón btnVolverPrincipal2.
	 * 
	 * @return                    El botón para volver a la ventana principal.
	 */
	public JButton getBtnVolverPrincipal2() {
		return btnVolverPrincipal2;
	}
	
	
	public void setBtnVolverPrincipal2(JButton btnVolverPrincipal2) {
		this.btnVolverPrincipal2 = btnVolverPrincipal2;
	}
	

	/**
	 * 
	 * Getter del elemento textNombrePizza.
	 * 
	 * @return                   El nombre de la pizza.
	 */
	public JTextField getTextNombrePizza() {
		return textNombrePizza;
	}

	/**
	 * 
	 * Setter del elemento textNombrePizza.
	 * 
	 * @param textNombrePizza    El nombre que se le desea establecer a la pizza.
	 */
	public void setTextNombrePizza(JTextField textNombrePizza) {
		this.textNombrePizza = textNombrePizza;
	}

	/**
	 * 
	 * Getter del elemento textNombre.
	 * 
	 * @return                   El nombre del usuario.
	 */
	public JTextField getTextNombre() {
		return textNombre;
	}

	/**
	 * 
	 * Setter del elemento textNombre.
	 * 
	 * @param textNombre         El nombre del usuario.
	 */
	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	/**
	 * 
	 * Getter del elemento textDireccion.
	 * 
	 * @return                   La dirección de la vivienda del usuario.
	 */
	public JTextField getTextDireccion() {
		return textDireccion;
	}

	/**
	 * 
	 * Setter del elemento textoDireccion.
	 * 
	 * @param textDireccion      La dirección de la vivienda del usuario.
	 */
	public void setTextDireccion(JTextField textDireccion) {
		this.textDireccion = textDireccion;
	}

	/**
	 * 
	 * Getter del elemento textTelefono.
	 * 
	 * @return                   El teléfono del usuario.
	 */
	public JTextField getTextTelefono() {
		return textTelefono;
	}

	/**
	 * 
	 * Setter del elemento textoTelefono.
	 * 
	 * @param textTelefono       El teléfono del usuario.
	 */
	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}

	/**
	 * 
	 * Getter del elemento textBases.
	 * 
	 * @return                  El contenido que se encuentra en el área de texto.
	 */
	public JTextField getTextBase() {
		return textBase;
	}

	/**
	 * 
	 * Setter del elemento textBases.
	 * 
	 * @param textBase          El contenido que se desea mostrar en el área de texo.
	 */
	public void setTextBase(JTextField textBase) {
		this.textBase = textBase;
	}

	/**
	 * 
	 * Getter del elemento textIngrediente.
	 * 
	 * @return                 El contenido que se encuentra en el área de texto.
	 */
	public JTextField getTextIngrediente() {
		return textIngrediente;
	}

	/**
	 * 
	 * Setter del elemento textIngrediente.
	 * 
	 * @param textIngrediente  El contenido que se desea mostrar en el área de texo.
	 */
	public void setTextIngrediente(JTextField textIngrediente) {
		this.textIngrediente = textIngrediente;
	}

	/**
	 * 
	 * Getter del botón btnCrearPizzas.
	 * 
	 * @return                 El botón para crear una pizza.
	 */
	public JButton getBtnCrearPizza() {
		return btnCrearPizza;
	}

	
	public void setBtnCrearPizza(JButton btnCrearPizza) {
		this.btnCrearPizza = btnCrearPizza;
	}


}
