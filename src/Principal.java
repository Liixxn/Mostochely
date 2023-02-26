

import java.util.Vector;

/**
 * 
 * En esta clase se inicializan todos los elementos para comprobar que todo funciona.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodruíguez Gómez
 * @version 1.0 
 */
public class Principal {
	
	
	
	public static void main(String[] args) {
		
		//Creamos una vista, una ventana1 y una ventana2
		Pizzeria_Vista vistaPrincipal = new Pizzeria_Vista();
		Ventana1 ventana1 = new Ventana1();
		Ventana2 ventana2 = new Ventana2();
		
		//Creamo un modelo
		Pizzeria_Modelo modelo = new Pizzeria_Modelo();
		
		//Creamos un controlador al que le pasamos las diferentes vistas y el modelo
		Pizzeria_Controlador controlador = new Pizzeria_Controlador(vistaPrincipal, ventana1, ventana2, modelo);
		
		
		//creamos unas bases
	    Base base1 = new Base("Fina",true,5,"pequenia");
	    Base base2 = new Base("Normal",false,7,"mediana");
	    Base base3 = new Base("Fina",true,8,"grande");
	    Base base4 = new Base("Normal",false,6,"mediana");
	    //Creamos un vector de tipo Base
	    Vector <Base> bases = new Vector <Base>();
	    
	    //Se añadedn al vector
	    bases.add(base1);
	    bases.add(base2);
	    bases.add(base3);
	    bases.add(base4);
	    
	    //Se asocian las bases al modelo
	    modelo.setBases(bases);
	    

	    //creamos ingredientes
	    
	    Vector <Ingrediente> ingredientes = new Vector <Ingrediente>();
	    
	    //Creamos unos ingredientes
	    Ingrediente ingre1 = new Ingrediente("Queso",true,3);
	    Ingrediente ingre2 = new Ingrediente("Jamon",true,2.5);
	    Ingrediente ingre3 = new Ingrediente("Bacon",false,3.5);
	    Ingrediente ingre4 = new Ingrediente("Pimiento",true,1.5);
	    Ingrediente ingre5 = new Ingrediente("Cebolla",false,2);
	    Ingrediente ingre6 = new Ingrediente("Champinion",false,4.5);
	    
	    //Se añaden al vector
	    ingredientes.add(ingre1);
	    ingredientes.add(ingre2);
	    ingredientes.add(ingre3);
	    ingredientes.add(ingre4);
	    ingredientes.add(ingre5);
	    ingredientes.add(ingre6);
	    
	    //Se asocian los ingredientes al modelo
	    modelo.setIngredientes(ingredientes);
	    
	    
	    
	    //se establece que la ventan principal sea visible
		vistaPrincipal.setVisible(true);
		
		
	}

	
}
