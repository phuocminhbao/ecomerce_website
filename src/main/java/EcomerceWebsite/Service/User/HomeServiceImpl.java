package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EcomerceWebsite.Dao.CategoryDao;
import EcomerceWebsite.Dao.MenuDao;
import EcomerceWebsite.Dao.ProductsDao;
import EcomerceWebsite.Dto.ProductsDto;
import EcomerceWebsite.Entity.Category;
import EcomerceWebsite.Entity.Menus;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private ProductsDao productsDao;

	// get list category
	public List<Category> GetDataCategory() {
		return categoryDao.GetDataCategory();
	}
	
	// get list menus
	public List<Menus> GetDataMenus() {
		return menuDao.GetDataMenus();
	}
	
	// get list product
	public List<ProductsDto> GetDataNewProducts() {
		List<ProductsDto> listProducts = productsDao.GetDataNewProducts();
		listProducts.get(0).getId_color();
		return listProducts;
	}
	
	public List<ProductsDto> GetDataHighlightProducts(){
		List<ProductsDto> listProducts = productsDao.GetDataHighlightProducts();
		listProducts.get(0).getId_color();
		return listProducts;
	}

}
