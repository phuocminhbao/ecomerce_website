package EcomerceWebsite.Service.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import EcomerceWebsite.Dao.UsersDao;
import EcomerceWebsite.Entity.Users;
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

	@InjectMocks
	private AccountServiceImpl accService;
	
	@Mock
	private UsersDao userDao;
	
	@Before
	public void setUp()  throws Exception {
		 MockitoAnnotations.initMocks(this);
    }
	
	//create test user
	private Users inputUser = new Users(1, "phuoc@gmail.com", "123", "Phuoc", "933A");
	private Users storedUser = new Users(1, "phuoc@gmail.com", "123", "Phuoc", "933A");
	
	@Test
	public void testCheckAccountWithRightPass() {
		//Make the test user's pass same format as stored in database 
		storedUser = accService.setPassword(storedUser);
		when(userDao.GetUserByAccount(inputUser)).thenReturn(storedUser);		
		//Check if 2 password are the same
		assertTrue(storedUser.getPassword() == accService.CheckAccount(inputUser).getPassword());
//		System.out.println(storedUser.getPassword());
	}
	
	@Test
	public void testCheckAccountWithWrongPass() {
		//Change pass stored test user
		Users inputUser1 = new Users(1, "phuoc@gmail.com", "456", "Phuoc", "933A");
		storedUser = accService.setPassword(storedUser);
//		System.out.println(storedUser.getPassword());
		when(userDao.GetUserByAccount(inputUser1)).thenReturn(storedUser);
//		Return null when 2 password are different
		assertTrue(accService.CheckAccount(inputUser1) == null);
	}

}
