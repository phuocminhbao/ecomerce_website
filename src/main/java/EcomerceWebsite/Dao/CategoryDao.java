package EcomerceWebsite.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import EcomerceWebsite.Entity.Category;
import EcomerceWebsite.Entity.MapperCategory;
@Repository
public class CategoryDao {
	@Autowired
	public JdbcTemplate _jbdcTemplate;
	
	public List<Category> GetDataCategory(){
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		list = _jbdcTemplate.query(sql, new MapperCategory());
		return list;
		
	}
}
