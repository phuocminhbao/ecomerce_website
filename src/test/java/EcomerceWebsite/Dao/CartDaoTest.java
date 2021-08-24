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
	
	private ProductsDto _product1 = new ProductsDto(1,1,"Iphone1",499.0, 1, "white");
	private ProductsDto _product2 = new ProductsDto(2,1,"Iphone2",499.0, 2, "white");
	private ProductsDto _product3 = new ProductsDto(3,2,"latop1",499.0, 5, "red");
	
	
	
	@Test
	public void testAddCartWithAnEmptyCart() {
		HashMap<Long, CartDto> cart = new HashMap<Long, CartDto>();
		when(productsDao.FindProductByID(1)).thenReturn(_product1);
		cartDao.AddCart(1, cart);
		assertFalse(cartDao.AddCart(1, cart).isEmpty());
//		System.out.println(productsDao.FindProductByID(1).getId_color());

	}

}
