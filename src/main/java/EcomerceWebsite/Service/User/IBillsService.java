package EcomerceWebsite.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import EcomerceWebsite.Dto.CartDto;
import EcomerceWebsite.Entity.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);
	
	public void AddBillsDetail(HashMap<Long, CartDto> carts);
	
}
