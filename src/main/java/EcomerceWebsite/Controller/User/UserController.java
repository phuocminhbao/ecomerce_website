package EcomerceWebsite.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import EcomerceWebsite.Entity.Users;
import EcomerceWebsite.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") Users user) {
		boolean checkEmail = accountService.checkEmail(user);
		if (checkEmail == false) {
			int count = accountService.AddAccount(user);
			if (count > 0) {
				_mvShare.addObject("status", "Sign Up Success!");
			}
			else {
				_mvShare.addObject("status", "Sign Up Fail!");
			}
		}
		else {
			_mvShare.addObject("status", "Email alreay existed");
		}
		
//		_mvShare.addObject("status", true);
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute Users user) {
		boolean checkEmail = accountService.checkEmail(user);
		if (checkEmail == true) {
			user = accountService.CheckAccount(user);
			if (user != null) {
				_mvShare.setViewName("redirect:home");
				session.setAttribute("LoginInfo", user);
			}
			else {
				_mvShare.addObject("statusLog", "Wrong password");
			}
		}
		else {
				_mvShare.addObject("statusLog", "Wrong email");
			}
		return _mvShare;
	}
	
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:" + request.getHeader("Referer");
	}
	
	
}
