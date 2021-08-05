package EcommerceWebsite.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import EcomerceWebsite.Dao.CategoryDao;
import EcomerceWebsite.Entity.Category;

class CategoryDaoTest {
	public DriverManagerDataSource dataSource;
	public CategoryDao dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecomercewebsite");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		dao = new CategoryDao(dataSource);
	}
	
	@Test
	void testGetDataCategory() {
		List<Category> listCategory = dao.GetDataCategory();
		assertTrue(!listCategory.isEmpty());
	}
	@Test
	void testGetDataCategorySize() {
		List<Category> listCategory = dao.GetDataCategory();
		assertEquals(3, listCategory.size());
	}
	@Test
	void testGetDataCategoryFirstElement() {
		List<Category> listCategory = dao.GetDataCategory();
		assertEquals(1, listCategory.get(0).getId());
		assertEquals("smartphone", listCategory.get(0).getName());
		assertEquals("iPhone, Vivo, Oppo...", listCategory.get(0).getDescription());
	}
	@Test
	void testGetDataCategorySecondElement() {
		List<Category> listCategory = dao.GetDataCategory();
		assertEquals(2, listCategory.get(1).getId());
		assertEquals("laptop", listCategory.get(1).getName());
		assertEquals("ASUS, MSI, HP...", listCategory.get(1).getDescription());
	}
	@Test
	void testGetDataCategoryThirdElement() {
		List<Category> listCategory = dao.GetDataCategory();
		assertEquals(3, listCategory.get(2).getId());
		assertEquals("ipad", listCategory.get(2).getName());
		assertEquals("ipad pro, ipad mini...", listCategory.get(2).getDescription());
	}

}