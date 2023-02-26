

import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;

/**
 * 
 * Pruebas unitarias JUnit de la clase Pizza.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * @version 1.0
 */


public class PizzaTest {

	
	
	@Test
	public void testPonerIngrediente() {
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Ingrediente ingrediente2 = new Ingrediente("Bacon", false, 4);
		
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		Vector <Ingrediente> ingredientes = new Vector<Ingrediente>();
		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		int capacidad = ingredientes.size();
		pizza.ponerIngrediente(ingrediente1);
		//Se comprueba que la capacidad de los vectores es la misma
		assertEquals(capacidad, pizza.getIngredientes().size());
		
	}

	@Test
	public void testPonerBase() {
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Pizza pizzaEsperada = new Pizza("Margarita", base1, ingrediente1);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		pizza.ponerBase(base1);
		//Se comprueba que los vectores tengan la misma base
		assertEquals(pizzaEsperada.getBase(), pizza.getBase());
		
	}

	@Test
	public void testCalcularCostePizza() {
		double coste = 0;
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		coste = pizza.calcularCostePizza();
		//Se comprueba que el coste sea 9.0
		assertEquals("9.0", Double.toString(coste));
		
	}

	@Test
	public void testAptaCeliacos() {
		boolean apta = false;
		
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", false, 3);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		apta = pizza.aptaCeliacos();
		//Se comprueba que la pizza sea apta para celiacos
		assertTrue(apta);
	}

}
