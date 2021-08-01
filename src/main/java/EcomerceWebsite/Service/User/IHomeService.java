package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import EcomerceWebsite.Entity.Category;
import EcomerceWebsite.Entity.Menus;

public interface IHomeService {
	@Autowired
	public List<Category> GetDataCategory();
	public List<Menus> GetDataMenus();
}
