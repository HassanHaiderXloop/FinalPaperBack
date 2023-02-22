package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.BDDMockito.*;

import com.example.final_exam.Entity.Product;
import com.example.final_exam.Repository.ProductRepository;
import org.junit.jupiter.api.Test;


@SpringBootTest
class FinalPaperApplicationTests {
	@Mock
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
	// @Test
	// void getAndSetProductId(){
	// 	Product cut = new Product();
	// 	Long myId = 1L;
	// 	cut.setId(myId);
	// 	assertEquals(myId, cut.getId());
	// }
	// // @Test
	// // void getAndSetProductName(){
	// // 	Product cut = new Product();
	// // 	Long myNmae = "";
	// // 	cut.setId(myId);
	// // 	assertEquals(myId, cut.getId());

	// // }

}
