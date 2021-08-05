

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import EcomerceWebsite.Dao.MenuDao;
import EcomerceWebsite.Entity.Menus;

class MenuDaoTest {
	public DriverManagerDataSource dataSource;
	public MenuDao dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecomercewebsite");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		dao = new MenuDao(dataSource);
	}
	@Test
	void testGetDataMenu() {
		List<Menus> listCategory = dao.GetDataMenus();
		assertTrue(!listCategory.isEmpty());
	}
	@Test
	void testGetDataMenuSize() {
		List<Menus> listCategory = dao.GetDataMenus();
		assertEquals(3, listCategory.size());
	}
	@Test
	void testGetDataMenuFirstElement() {
		List<Menus> listCategory = dao.GetDataMenus();
		assertEquals(1, listCategory.get(0).getId());
		assertEquals("home", listCategory.get(0).getName());
		
	}
	@Test
	void testGetDataMenuSecondElement() {
		List<Menus> listCategory = dao.GetDataMenus();
		assertEquals(2, listCategory.get(1).getId());
		assertEquals("product", listCategory.get(1).getName());
	
	}
	@Test
	void testGetDataMenuThirdElement() {
		List<Menus> listCategory = dao.GetDataMenus();
		assertEquals(3, listCategory.get(2).getId());
		assertEquals("cart", listCategory.get(2).getName());
		
	}
}
