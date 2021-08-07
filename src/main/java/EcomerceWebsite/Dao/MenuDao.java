package EcomerceWebsite.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import EcomerceWebsite.Entity.MapperMenus;
import EcomerceWebsite.Entity.Menus;

//Get menu data from SQL database
@Repository
public class MenuDao extends BaseDao{
	
	public MenuDao(DataSource dataSource) {
		this._jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Menus> GetDataMenus(){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	} 
	
}