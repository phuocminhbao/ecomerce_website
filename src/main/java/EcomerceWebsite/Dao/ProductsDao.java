package EcomerceWebsite.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import EcomerceWebsite.Dto.ProductsDto;
import EcomerceWebsite.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

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
	
	private StringBuffer SqlProductByID(int id) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("WHERE 1 = 1 ");		// Make Condition always true
		sql.append("AND id_category = " + id + " ");

		return sql;
	}
	
	private StringBuffer SqlProductByName(String name) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("WHERE 1 = 1 ");		// Make Condition always true
		sql.append("AND p.name LIKE \"%" + name + "%\"");
		return sql;
	}
	
	private String SqlProductByPaginate(int id, int start, int totalPage) {
		StringBuffer  sql = SqlProductByID(id); // add string builder for input other functions such as append...
		sql.append("LIMIT  " + start + ", " + totalPage);	
		return sql.toString();
	}
	
	private String SqlProductByPaginateName(String name, int start, int totalPage) {
		StringBuffer  sql = SqlProductByName(name); // add string builder for input other functions such as append...
		sql.append("LIMIT  " + start + ", " + totalPage);	
		return sql.toString();
	}
	
	private StringBuffer SortProductByID(int id, String order) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("WHERE 1 = 1 ");		// Make Condition always true
		sql.append("AND id_category = " + id + " ");
		sql.append("ORDER BY p.price " + order + " ");
		return sql;
	}
	
	private StringBuffer SortProductByName(String name, String order) {
		StringBuffer  sql = SqlString(); // add string builder for input other functions such as append...
		sql.append("WHERE 1 = 1 ");		// Make Condition always true
		sql.append("AND p.name LIKE \"%" + name + "%\"");
		sql.append("ORDER BY p.price " + order + " ");
		return sql;
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
		String sql = SqlProductByID(id).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> GetAllProductsByName(String name) {
		String sql = SqlProductByName(name).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> SortProductsByID(int id, String order) {
		String sql = SortProductByID(id, order).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> SortProductsByName(String name, String order) {
		String sql = SortProductByName(name, order).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductByID(id);
		List<ProductsDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if(listProductsByID.size() > 0) {
			String sql = SqlProductByPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return listProducts;
	}
	
	public List<ProductsDto> GetDataProductsPaginateByName(String name, int start, int totalPage) {
		StringBuffer sqlGetDataByName = SqlProductByName(name);
		List<ProductsDto> listProductsByName= _jdbcTemplate.query(sqlGetDataByName.toString(), new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if(listProductsByName.size() > 0) {
			String sql = SqlProductByPaginateName(name, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return listProducts;
	}

	private String SqlProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}
	
	public List<ProductsDto> GetProductByID(long id) {
		String sql = SqlProductByID(id);
		List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	}
	
	public ProductsDto FindProductByID(long id) {
		String sql = SqlProductByID(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}
	
}
