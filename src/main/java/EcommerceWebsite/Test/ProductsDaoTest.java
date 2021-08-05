package EcommerceWebsite.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import EcomerceWebsite.Dao.ProductsDao;
import EcomerceWebsite.Dto.ProductsDto;

class ProductsDaoTest {
	public DriverManagerDataSource dataSource;
	public ProductsDao dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecomercewebsite");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		dao = new ProductsDao(dataSource);
	}
	@Test
	void testGetDataProducts() {
		List<ProductsDto> listProducts = dao.GetDataProducts();
		assertFalse(listProducts.isEmpty());
	}
	
	@Test
	void testGetDataProductsSize() {
		List<ProductsDto> listProducts = dao.GetDataProducts();
		assertEquals(3, listProducts.size());
	}
	

}
