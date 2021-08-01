package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import EcomerceWebsite.Dao.CategoryDao;
import EcomerceWebsite.Entity.Category;

class HomeServiceImplTest {
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
//		for (Category aCategory : listCategory) {
//			System.out.println(aCategory);
//		}
		assertFalse(listCategory.isEmpty());
	}

}
