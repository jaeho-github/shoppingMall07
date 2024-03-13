package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;


/*
 *	FileName :  ProductServiceTest.java
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {	"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

//	@Test
//	public void testAddProduct() throws Exception {
//		
//		Product product = new Product();
//		product.setProdNo(3);
//		product.setManuDate("20230526");
//		product.setPrice(60000);
//		product.setProdDetail("최고짱짱제품");
//		product.setProdName("성남이의 비밀상자");
//		
//		productService.addProduct(product);
//		
//		product = productService.getProduct(3);
//
//		//==> console 확인
//		//System.out.println(product);
//		
//		//==> API 확인
//		Assert.assertEquals(3, product.getProdNo());
//		Assert.assertEquals("20230526", product.getManuDate());
//		Assert.assertEquals(60000, product.getPrice());
//		Assert.assertEquals("최고짱짱제품", product.getProdDetail());
//		Assert.assertEquals("성남이의 비밀상자", product.getProdName());
//		Assert.assertNotNull(productService.getProduct(3));	
//	}
//}

//	@Test
//	 public void testUpdateProduct() throws Exception{
//		 
//		Product product = productService.getProduct(3);
//		Assert.assertNotNull(product);
//		
//		Assert.assertEquals(3, product.getProdNo());
//		Assert.assertEquals("20230526", product.getManuDate());
//		Assert.assertEquals(60000, product.getPrice());
//		Assert.assertEquals("최고짱짱제품", product.getProdDetail());
//		Assert.assertEquals("성남이의 비밀상자", product.getProdName());
//
//		product.setManuDate("20220526");
//		product.setPrice(50);
//		product.setProdDetail("최고구린제품");
//		product.setProdName("수빈누나노트북");
//		
//		productService.updateProduct(product);
//		
//		product = productService.getProduct(3);
//		Assert.assertNotNull(product);
//		
////		==> console 확인
//		System.out.println(product);
//			
//		//==> API 확인
//		Assert.assertEquals("20220526", product.getManuDate());
//		Assert.assertEquals(50, product.getPrice());
//		Assert.assertEquals("최고구린제품", product.getProdDetail());
//		Assert.assertEquals("수빈누나노트북", product.getProdName());
//	 }
//}


	 //==>  주석을 풀고 실행하면....
	 @Test
	 public void testGetProductListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확인
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	//==> console 확인
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
}
//	 
//	 //@Test
//	 public void testGetProductListByProductId() throws Exception{
//		 
//	 	Search search = new Search();
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	search.setSearchCondition("0");
//	 	search.setSearchKeyword("admin");
//	 	Map<String,Object> map = productService.getProductList(search);
//	 	
//	 	List<Object> list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(1, list.size());
//	 	
//		//==> console 확인
//	 	//System.out.println(list);
//	 	
//	 	Integer totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 	
//	 	System.out.println("=======================================");
//	 	
//	 	search.setSearchCondition("0");
//	 	search.setSearchKeyword(""+System.currentTimeMillis());
//	 	map = productService.getProductList(search);
//	 	
//	 	list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(0, list.size());
//	 	
//		//==> console 확인
//	 	//System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }
//	 
//	 //@Test
//	 public void testGetProductListByProductName() throws Exception{
//		 
//	 	Search search = new Search();
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	search.setSearchCondition("1");
//	 	search.setSearchKeyword("SCOTT");
//	 	Map<String,Object> map = productService.getProductList(search);
//	 	
//	 	List<Object> list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(3, list.size());
//	 	
//		//==> console 확인
//	 	System.out.println(list);
//	 	
//	 	Integer totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 	
//	 	System.out.println("=======================================");
//	 	
//	 	search.setSearchCondition("1");
//	 	search.setSearchKeyword(""+System.currentTimeMillis());
//	 	map = productService.getProductList(search);
//	 	
//	 	list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(0, list.size());
//	 	
//		//==> console 확인
//	 	System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }	 
//}