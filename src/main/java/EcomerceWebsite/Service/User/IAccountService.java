package EcomerceWebsite.Service.User;

import org.springframework.beans.factory.annotation.Autowired;

import EcomerceWebsite.Entity.Users;

public interface IAccountService {
	@Autowired
	public int AddAccount(Users user);
}
