

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Vector;

import org.junit.Test;

/**
 * 
 * Pruebas unitarias JUnit de la clase Orden.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * @version 1.0
 *
 */

public class OrdenTest {

	@Test
	public void testAniadirPizza() {
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		Vector <Pizza> pizzas = new Vector<Pizza>();
		pizzas.add(pizza);
		
		Orden ordenEsperado = new Orden("Lian" , "Mostoles", "57394322", new Date(0), pizzas, true);
		Orden orden = new Orden();
		orden.aniadirPizza(pizza);
		//Se comprueba que la capacidad de los vectores sea igual
		assertEquals(pizzas.size(), orden.getPizzas().size());
	}

	@Test
	public void testEliminarUltimaPizza() {
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		Pizza pizza2 = new Pizza("Margarita", base1, ingrediente1);
		Vector <Pizza> pizzas = new Vector<Pizza>();
		pizzas.add(pizza);
		pizzas.add(pizza2);
		
		Orden orden = new Orden("Lian" , "Mostoles", "57394322", new Date(0), pizzas, true);
		
		orden.eliminarUltimaPizza();
		//Comrpueba que la capacidad de los vectores sea igual
		assertEquals(1, orden.getPizzas().size());
		
	}

	@Test
	public void testCalcularCostePedido() {
		double coste = 0;
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		Vector <Pizza> pizzas = new Vector <Pizza>();
		pizzas.add(pizza);
		
		Orden orden = new Orden("Lian" , "Mostoles", "57394322", new Date(0), pizzas, true);
		coste = orden.calcularCostePedido();
		//Se comprueba que el coste sea igual al esperado
		assertEquals("9.0", Double.toString(coste));
	}

	@Test
	public void testConfirmarRecepcion() {
		Base base1 = new Base("Fina" , false, 6, "mediana");
		Ingrediente ingrediente1 = new Ingrediente("Queso", true, 3);
		Pizza pizza = new Pizza("Margarita", base1, ingrediente1);
		Vector <Pizza> pizzas = new Vector <Pizza>();
		pizzas.add(pizza);
		
		Orden orden = new Orden("Lian" , "Mostoles", "57394322", new Date(0), pizzas, false);
		orden.confirmarRecepcion();
		//Se comprueba que se ha cambiado el estado del atributo entregado a true
		assertTrue(orden.isEntregado());
	}

}
