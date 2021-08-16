package EcomerceWebsite.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import EcomerceWebsite.Dto.ProductsDto;
@Service
public interface ICategoryService {
	public List<ProductsDto> GetALLProductsByID(int id);
	
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage);
		
}
