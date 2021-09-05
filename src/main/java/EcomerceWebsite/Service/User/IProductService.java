package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import EcomerceWebsite.Dto.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto GetProductByID(long id);
	
	public List<ProductsDto> GetProductByIDCategory(int id);
	
	public List<ProductsDto> GetAllProductByName(String name);
	
	public List<ProductsDto> GetDataProductsPaginateByName(String name, int start, int totalPage);
}
