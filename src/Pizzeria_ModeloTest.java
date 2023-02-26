
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Vector;
import org.junit.Test;

/**
 * 
 * Pruebas unitarias JUnit de la clase Pizzeria_Modelo.
 * 
 * @author Lian Salmerón López
 * @author María Teresa Rodríguez Gómez
 * @version 1.0
 *
 */

public class Pizzeria_ModeloTest {

        Pizzeria_Modelo modelo = new Pizzeria_Modelo();

        @Test
        public void testCrearPizza() {
        Vector<Pizza>pizzas = new Vector<Pizza>();
        Base base1 = new Base("Fina",true,5,"pequenia");
        Ingrediente ingre1 = new Ingrediente("Queso",true,3);
        Ingrediente ingre2 = new Ingrediente("Champinion",true,3);
        Base base2 = new Base("Fina",true,5,"pequenia");
        String nombre = "lian";
        Pizza pizza1 = new Pizza ("Margarita",base2, ingre2);
        pizzas.add(pizza1);
        modelo.CrearPizza("Lian", base1 , ingre1);
        assertEquals(pizzas.size(),modelo.getPizzas().size());  
            
        }

        @Test
        public void testCrearOrden() {
            Vector<Pizza>pizzas = new Vector<Pizza>();
            Base base1 = new Base("Fina",true,5,"pequenia");
            Ingrediente ingre1 = new Ingrediente("Queso",true,3);
            Pizza pizza1 = new Pizza ("Margarita",base1, ingre1);
            pizzas.add(pizza1);
            Vector<Orden>orden = new Vector<Orden>();
            Orden orden1 = new Orden ("nom","calle","num",new Date(), pizzas,false );
            orden.add(orden1);
            modelo.CrearOrden("Lian", "Villaviciosa", "123456", new Date(), modelo.getPizzas() , false);
            assertEquals(orden.size(),modelo.getOrdenes().size());
        }

        @Test
        public void testCalcularCoste() {
            String valorEsperado = "5.5";
            String calcular = modelo.CalcularCoste(4, 1.5);
            assertEquals(valorEsperado, calcular);
        }

        @Test
        public void testConfirmarPedido() throws FileNotFoundException {
            assertTrue(modelo.ConfirmarPedido("Lian"));
            
        }

        @Test
        public void testEliminarPedido() {
            assertFalse(modelo.EliminarPedido("reghtrhr"));
            
        }

        @Test
        public void testLeerFichero() throws FileNotFoundException {
            String[][] valorEsperado = {{"Carbonara"}, {"Barbacoa"}, {"Margarita"}, {"Pepperoni"}, {"Mostochely"}};

            modelo.leerFichero("pizzas.txt");
            assertArrayEquals(valorEsperado, modelo.leerFichero("pizzas.txt"));
        }


    }