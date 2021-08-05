package EcomerceWebsite.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import EcomerceWebsite.Service.User.HomeServiceImpl;

//create a common base to control all model and view including homecontroller
@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeService;
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init () {
		_mvShare.addObject("menus", _homeService.GetDataMenus());
		return _mvShare;
	}
}
