package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import EcomerceWebsite.Dto.ProductsDto;
import EcomerceWebsite.Entity.Category;
import EcomerceWebsite.Entity.Menus;

//get many data from connected tables and data from database
public interface IHomeService {
	@Autowired
	public List<Category> GetDataCategory();
	public List<Menus> GetDataMenus();
	public List<ProductsDto> GetDataProducts();
}
