package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EcomerceWebsite.Dao.CategoryDao;
import EcomerceWebsite.Dao.MenuDao;
import EcomerceWebsite.Entity.Category;
import EcomerceWebsite.Entity.Menus;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private MenuDao menuDao;

	public List<Category> GetDataCategory() {
		return categoryDao.GetDataCategory();
	}
	
	public List<Menus> GetDataMenus() {
		return menuDao.GetDataMenus();
	}
}
