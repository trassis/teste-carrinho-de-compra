/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;
  private Item item1, item2;
  private double EPSILON;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();

    item1 = new Item("Item1", 10.0);    
    item2 = new Item("Item2", 20.0);    

    EPSILON = 1e-5;
  }

  @Test
  public void testAddItem() {
    shoppingCart.addItem(item1);
    shoppingCart.addItem(item2);

    Item cartItem1 = shoppingCart.getItems().get(0);
    Item cartItem2 = shoppingCart.getItems().get(1);

    assertEquals(item1.getName(), cartItem1.getName());
    assertEquals(item1.getPrice(), cartItem1.getPrice(), EPSILON);

    assertEquals(item2.getName(), cartItem2.getName());
    assertEquals(item2.getPrice(), cartItem2.getPrice(), EPSILON);
  }

  @Test
  public void testRemoveItem() {
    shoppingCart.addItem(item1);
    shoppingCart.addItem(item2);

    shoppingCart.removeItem(item1);
    assertEquals(shoppingCart.getItemCount(), 1);
    shoppingCart.removeItem(item2);
    assertEquals(shoppingCart.getItemCount(), 0);
  }

  @Test
  public void testGetTotalPrice() {
    shoppingCart.addItem(item1);
    assertEquals(shoppingCart.getTotalPrice(), 10.0, EPSILON);

    shoppingCart.addItem(item2);
    assertEquals(shoppingCart.getTotalPrice(), 30.0, EPSILON);
  }

  @Test
  public void testClearCart() {
    shoppingCart.addItem(item1);
    shoppingCart.addItem(item2);

    shoppingCart.clearCart();
    assertEquals(shoppingCart.getItemCount(), 0);
  }
}
