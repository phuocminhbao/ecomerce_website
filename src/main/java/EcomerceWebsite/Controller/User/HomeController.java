package EcomerceWebsite.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	
	@RequestMapping(value = { "/", "/home" }) // redirect website's link include / and home to homepage
	//set model connect to view of data
	public ModelAndView Index() {
		_mvShare.addObject("category", _homeService.GetDataCategory());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	// request mapping to product url and connect to project.jsp file
	@RequestMapping(value = "/product")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
	}
}
