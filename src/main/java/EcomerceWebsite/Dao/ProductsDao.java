package EcomerceWebsite.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import EcomerceWebsite.Dto.ProductsDto;
import EcomerceWebsite.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	
	private String SqlString() {
		StringBuffer  sql = new StringBuffer(); // add string builder for input other functions such as append...
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		sql.append("LIMIT 9 ");
		return sql.toString();
	}
	
	//jdbc query to get data from product dto 
	public List<ProductsDto> GetDataProducts() {
		String sql = SqlString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
}
