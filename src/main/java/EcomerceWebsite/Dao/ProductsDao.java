package EcomerceWebsite.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import EcomerceWebsite.Dto.ProductsDto;
import EcomerceWebsite.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	
	public ProductsDao(DataSource dataSource) {
		this._jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final boolean YES = true;
	private final boolean NO = false;
	
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer(); // add string builder for input other functions such as append...
		sql.append("SELECT ");
		sql.append("p.id AS id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id AS id_color ");
		sql.append(", c.name AS name_color ");
		sql.append(", c.code AS code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}
	
	private String SqlProductString(boolean newProduct, boolean highLight) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("WHERE 1 = 1 ");		// Make Condition always true
		if (highLight ) {
			sql.append("AND p.highlight = true ");
		}
		if (newProduct ) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highLight ) {
			sql.append("LIMIT 9 ");
		}
		if (newProduct ) {
			sql.append("LIMIT 12 ");
		}
		return sql.toString();
	}
	
	private String SqlProductByID(int id) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("WHERE 1 = 1 ");		// Make Condition always true
		sql.append("AND id_category = " + id + " ");

		return sql.toString();
	}
	
	private String SqlProductByPaginate(int start, int end) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("LIMIT  " + start + ", " + end);	
		return sql.toString();
	}
	
	//jdbc query to get data from product dto 
	public List<ProductsDto> GetDataHighlightProducts() {
		String sql = SqlProductString(NO, YES);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> GetDataNewProducts() {
		String sql = SqlProductString(YES, NO);
		List<ProductsDto> listProducts = 	_jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> GetAllProductsByID(int id) {
		String sql = SqlProductByID(id);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> GetDataProductsPaginate(int start, int end) {
		String sql = SqlProductByPaginate(start, end);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
}
