package EcomerceWebsite.Dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import EcomerceWebsite.Dto.CartDto;
import EcomerceWebsite.Dto.ProductsDto;

@RunWith(MockitoJUnitRunner.class)
public class CartDaoTest {
	
	@InjectMocks
	CartDao cartDao;
	
	@Mock
	ProductsDao productsDao = new ProductsDao();
	
	
	@Before
	public void setUp()  throws Exception {
		 MockitoAnnotations.initMocks(this);
    }
	
	//Create some product for testing
	private ProductsDto _product1 = new ProductsDto(1,1,"Iphone1",499.0, 1, "white");
	private ProductsDto _product2 = new ProductsDto(2,1,"Iphone2",399.0, 2, "white");
	private ProductsDto _product3 = new ProductsDto(3,2,"latop1",999.0, 5, "red");
	
	
	
	@Test
	public void testAddCartWithAnEmptyCart() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();		//create an empty cart
		assertTrue(cart.isEmpty());										//Check the cart is empty
		when(productsDao.FindProductByID(1)).thenReturn(_product1);		//Mock the find function instead get data form database
		cartDao.AddCart(1, cart);
		assertFalse(cart.isEmpty());				//Check if item is been added to the cart
//		System.out.println(cart.get((long)1));
		assertEquals(_product1.getName(),cart.get((long)1).getProduct().getName());	//Check name of first item
		assertEquals(_product1.getPrice(),cart.get((long)1).getProduct().getPrice(), 0.0f);	//Check price of first item

	}
	
	@Test
	public void testAddCartWithNotEmptyCart() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();		//create an empty cart
		assertTrue(cart.isEmpty());										//Check the cart is empty
		when(productsDao.FindProductByID(1)).thenReturn(_product1);		//Mock the find function instead get data form database
		cartDao.AddCart(1, cart);										//Add first item
		when(productsDao.FindProductByID(2)).thenReturn(_product2);	
		cartDao.AddCart(2, cart);										//Add second item
		
		when(productsDao.FindProductByID(1)).thenReturn(_product1);		
		cartDao.AddCart(1, cart);										//Add the first item again
		assertEquals(2 ,cart.get((long)1).getQuanty());					//Check if the quantity of first item is creased 1
		assertEquals(1 ,cart.get((long)2).getQuanty());					//Check if the quantity of second item is not changed
		assertEquals(_product1.getPrice()*cart.get((long)1).getQuanty() ,cart.get((long)1).getTotalPrice(), 0.0f);		//Check if the total price of first item is double
	}
	
	
	@Test
	public void testEditCart() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();		//create an empty cart
		CartDto item1 = new CartDto();
		item1.setProduct(_product1);
		item1.setQuanty(1);
		item1.setTotalPrice(_product1.getPrice());
		CartDto item2 = new CartDto();
		item2.setProduct(_product2);
		item2.setQuanty(2);
		item2.setTotalPrice(_product2.getPrice() * item2.getQuanty());
		CartDto item3 = new CartDto();
		item3.setProduct(_product3);
		item3.setQuanty(6);
		item3.setTotalPrice(_product3.getPrice() * item3.getQuanty());
		
		//Add some items for cart
		cart.put((long) 1, item1);
		cart.put((long) 2, item2);
		cart.put((long) 3, item3);
		
		assertEquals(3, cartDao.EditCart(1, 3, cart).get((long)1).getQuanty());			//Quantity of first item changed into 3
		assertEquals(item2.getQuanty(), cart.get((long)2).getQuanty());					//Quantity of second item keep same
		assertEquals(_product3.getPrice() * 99, cartDao.EditCart(3, 99, cart).get((long)3).getTotalPrice(), 0.0f);		//Price of third item increase 99 times
	}

	
	@Test
	public void testDeleteCart() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();		//create an empty cart
		CartDto item1 = new CartDto();
		item1.setProduct(_product1);
		item1.setQuanty(1);
		item1.setTotalPrice(_product1.getPrice());
		CartDto item2 = new CartDto();
		item2.setProduct(_product2);
		item2.setQuanty(2);
		item2.setTotalPrice(_product2.getPrice() * item2.getQuanty());
		CartDto item3 = new CartDto();
		item3.setProduct(_product3);
		item3.setQuanty(6);
		item3.setTotalPrice(_product3.getPrice() * item3.getQuanty());
		
		//Add some items for cart
		cart.put((long) 1, item1);
		cart.put((long) 2, item2);
		cart.put((long) 3, item3);
		
		assertFalse(cartDao.DeleteCart(1, cart).isEmpty());			//Check if all items will not be deleted after delete 1 item
		assertEquals(2, cartDao.DeleteCart(1, cart).size());		//Check number of items after delete 1 item
		cartDao.DeleteCart(3, cart);								//Delete item 3 in cart
		assertFalse(cart.containsKey((long) 3));					//Check the third item is not exist
		assertFalse(cart.containsValue(item3));
		assertTrue(cart.containsKey((long) 2));						//item 2, 3 still exist 
		assertTrue(cart.containsValue(item2));						// in the cart
	}
	
	@Test
	public void testTotalQuanty() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();		//create an empty cart
		CartDto item1 = new CartDto();
		item1.setProduct(_product1);
		item1.setQuanty(1);
		item1.setTotalPrice(_product1.getPrice());
		CartDto item2 = new CartDto();
		item2.setProduct(_product2);
		item2.setQuanty(5);
		item2.setTotalPrice(_product2.getPrice() * item2.getQuanty());
		CartDto item3 = new CartDto();
		item3.setProduct(_product3);
		item3.setQuanty(25);
		item3.setTotalPrice(_product3.getPrice() * item3.getQuanty());
		
		//Add some items for cart
		cart.put((long) 1, item1);
		cart.put((long) 2, item2);
		cart.put((long) 3, item3);
		
		int totalQuanty = item1.getQuanty() + item2.getQuanty() + item3.getQuanty();		//Calculate total quantity of all items in cart
		assertEquals(totalQuanty, cartDao.TotalQuanty(cart));
	}
	
	
	@Test
	public void testTotalPrice() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();		//create an empty cart
		CartDto item1 = new CartDto();
		item1.setProduct(_product1);
		item1.setQuanty(1);
		item1.setTotalPrice(_product1.getPrice());
		CartDto item2 = new CartDto();
		item2.setProduct(_product2);
		item2.setQuanty(5);
		item2.setTotalPrice(_product2.getPrice() * item2.getQuanty());
		CartDto item3 = new CartDto();
		item3.setProduct(_product3);
		item3.setQuanty(25);
		item3.setTotalPrice(_product3.getPrice() * item3.getQuanty());
		
		//Add some items for cart
		cart.put((long) 1, item1);
		cart.put((long) 2, item2);
		cart.put((long) 3, item3);
		
		double totalPrice = item1.getTotalPrice() + item2.getTotalPrice() + item3.getTotalPrice();	//Calculate total price of all items in cart
		assertEquals(totalPrice, cartDao.TotalPrice(cart), 0.0f);
	}
}
