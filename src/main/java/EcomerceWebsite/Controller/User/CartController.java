package EcomerceWebsite.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import EcomerceWebsite.Dto.CartDto;
import EcomerceWebsite.Entity.Bills;
import EcomerceWebsite.Entity.Users;
import EcomerceWebsite.Service.User.BillsServiceImpl;
import EcomerceWebsite.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	
	@RequestMapping(value = "cart")
	public ModelAndView Index() {
		_mvShare.addObject("category", _homeService.GetDataCategory());
		_mvShare.addObject("highlightProducts", _homeService.GetDataHighlightProducts());
		_mvShare.addObject("newProducts", _homeService.GetDataNewProducts());
		_mvShare.setViewName("user/cart/list_cart");
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut (HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		if (loginInfo !=null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplayName(loginInfo.getDisplayName());
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills", bills);
		return _mvShare;
	}
	
	@RequestMapping(value = "checkout",  method = RequestMethod.POST)
	public String CheckOutBill (HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bill) {
//		bill.setQuanty(Integer.parseInt((String) session.getAttribute("TotalPriceCart")));
//		bill.setTotal(Double.parseDouble((String)session.getAttribute("TotalQuantyCart")));
		if (billsService.AddBills(bill) > 0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billsService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:successorder";
	}
	
	@RequestMapping(value = "successorder")
	public ModelAndView Successful () {
		_mvShare.setViewName("user/bills/successorder");
		return _mvShare;
	}
}
