package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import EcomerceWebsite.Entity.Category;

public interface IHomeService {
	@Autowired
	public List<Category> GetDataCategory();
}
