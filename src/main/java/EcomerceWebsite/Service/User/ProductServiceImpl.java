package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EcomerceWebsite.Dao.ProductsDao;
import EcomerceWebsite.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductsDao productDao = new ProductsDao();
	
	@Override
	public ProductsDto GetProductByID(long id) {
		List<ProductsDto> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}
	@Override
	public List<ProductsDto> GetProductByIDCategory(int id) {
		return productDao.GetAllProductsByID(id);
	}

	@Override
	public List<ProductsDto> GetAllProductByName(String name) {
		return productDao.GetAllProductsByName(name);
	}
	@Override
	public List<ProductsDto> GetDataProductsPaginateByName(String name, int start, int totalPage) {
		List<ProductsDto> list = productDao.GetDataProductsPaginateByName(name, start, totalPage);
		return list;
	}

}
