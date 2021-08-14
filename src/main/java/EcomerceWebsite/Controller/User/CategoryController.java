package EcomerceWebsite.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import EcomerceWebsite.Dto.PaginatesDto;
import EcomerceWebsite.Service.User.CategoryServiceImpl;
import EcomerceWebsite.Service.User.PaginatesServiceImpl;

@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginateService;
	
	@RequestMapping(value = "/items/{id}")
	public ModelAndView Product(@PathVariable String id) {
		int totalProductsEachPage = 9;
		int startPage = 1;
		int totalData = categoryService.GetALLProductsByID(Integer.parseInt(id)).size();
		
		_mvShare.setViewName("user/products/category");
		
		// Category page will start with the page 1 and each page will have maximum 9 products showed
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsEachPage, startPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(paginateInfo.getStart(), paginateInfo.getEnd()));

		return _mvShare;
	}
	
}