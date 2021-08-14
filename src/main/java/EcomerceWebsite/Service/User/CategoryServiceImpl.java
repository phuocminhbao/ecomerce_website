package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EcomerceWebsite.Dao.ProductsDao;
import EcomerceWebsite.Dto.ProductsDto;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private ProductsDao productsDao;
	
	@Override
	public List<ProductsDto> GetALLProductsByID(int id) {
		List<ProductsDto> list = productsDao.GetAllProductsByID(id);
		return list;
	}
	
	@Override
	public List<ProductsDto> GetDataProductsPaginate(int start, int end){
		List<ProductsDto> list = productsDao.GetDataProductsPaginate(start, end);
		return list;
	}

	
}
