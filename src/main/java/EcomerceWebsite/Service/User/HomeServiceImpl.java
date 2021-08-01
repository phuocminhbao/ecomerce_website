package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EcomerceWebsite.Dao.CategoryDao;
import EcomerceWebsite.Entity.Category;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> GetDataCategory() {
		return categoryDao.GetDataCategory();
	}

}
