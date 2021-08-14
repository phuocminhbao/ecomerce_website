package EcomerceWebsite.Service.User;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaginatesServiceImplTest {

	@Test
	public void testFindStart() {
		PaginatesServiceImpl paginate = new PaginatesServiceImpl();
		assertEquals(1, paginate.FindStart(1, 9));
	}

	@Test
	public void testFindEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetInfoTotalPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckCurrentPage() {
		fail("Not yet implemented");
	}

}
