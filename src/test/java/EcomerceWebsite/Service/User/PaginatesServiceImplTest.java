package EcomerceWebsite.Service.User;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaginatesServiceImplTest {
	PaginatesServiceImpl service = new PaginatesServiceImpl();
	
	@Test
	public void testFindEndWhenTotaldataDivisibleByLimit() {
		int end = 9;
		int limit = 9;
		
		//Test at starting as first product 
		int start1 =1;
		assertEquals(end, service.FindEnd(start1, limit, 9));		//End must = limit
		assertEquals(end, service.FindEnd(start1, limit, 90));
		
		//Test at starting as different order of product
		assertTrue(service.FindEnd(5, limit, 18) > 5);		//End must higher than start
		assertTrue(service.FindEnd(5, limit, 18) > limit);	//End must higher than limit of product in each page

	}
	
	@Test
	public void testFindEndWhenTotaldataNotDivisibleByLimit() {
		int limit =5;
		
		assertEquals(5, service.FindEnd(1, limit, 6));		//End must = limit	
		assertEquals(27, service.FindEnd(25, limit, 27));	//End must = total data
		assertTrue(service.FindEnd(1, limit, 3) < limit);	//End must less than limit for the first page
		
	}
	
	@Test
	public void testFindStartFromPage1To3() {		//Assume current page can not be negative because it already checked 
		int startList[] = {0, 9, 18};
		int pages[] = {1, 2, 3};
		int limit =9;
		for (int i = 0; i < startList.length; i++) {
			assertEquals(startList[i], service.FindStart(pages[i], limit));
		}
		
//		assertEquals(0, service.FindStart(1, 9));	//Order of first product showed in first page
//		assertEquals(9, service.FindStart(2, 9));	//Order of first product showed in second page
//		assertEquals(18, service.FindStart(3, 9));	//Order of first product showed in third page
	}
	
	
	@Test
	public void testSetInfoTotalPageWhenTotalPageDivisibleByLimit() {
		int limit = 9;
		assertEquals(1, service.SetInfoTotalPage(9, limit));	
		assertEquals(4, service.SetInfoTotalPage(36, limit));	
		assertEquals(7, service.SetInfoTotalPage(35, 5));	
		assertTrue(service.SetInfoTotalPage(35, 5) > 1);		//This case will more than 1 page 
		assertTrue(service.SetInfoTotalPage(35, 5) > 3);
	}
	
	@Test
	public void testSetInfoTotalPageWhenTotalPageNotDivisibleByLimit() {
		int limit = 9;
		//1 more page must be needed for show remain products
		assertEquals(2, service.SetInfoTotalPage(12, limit));	
		assertEquals(5, service.SetInfoTotalPage(38, limit));	
		assertEquals(7, service.SetInfoTotalPage(31, 5));	
		assertTrue(service.SetInfoTotalPage(38, 5) > 1);		//This case will more than 1 page 
		assertTrue(service.SetInfoTotalPage(38, 5) > 3);
	}

	@Test
	public void testCheckCurrentPageWithDifferentInput() {		//Assume total page can not be negative because it already checked
		// Normal current page input
		assertEquals(1, service.CheckCurrentPage(1, 3));
		assertEquals(5, service.CheckCurrentPage(5, 8));
		
		// Negative current page input
		assertEquals(1, service.CheckCurrentPage(-1, 3));
		assertEquals(1, service.CheckCurrentPage(-5, 20));
		
		// Current page input higher than total pages
		assertEquals(1, service.CheckCurrentPage(2, 1));
		assertEquals(5, service.CheckCurrentPage(8, 5));
		assertTrue(service.CheckCurrentPage(1, 6) <= 6);		//Current page must less than or equal to total pages
		assertFalse(service.CheckCurrentPage(5, 13) > 13);
	}
	
}
