package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

import com.example.demo.Entity.Product;

import static org.mockito.BDDMockito.*;

// // import com.example.final_exam.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


@SpringBootTest
class FinalPaperApplicationTests {
	@Mock
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void getAndSetProductId(){
		Product cut = new Product();
		Long myId = 1L;
		cut.setId(myId);
		assertEquals(myId, cut.getId());
	}
	@Test
	void getAndSetProductName(){
		Product cut = new Product();
		String myNmae = "Chocolate Pudding";
		cut.setName(myNmae);
		assertEquals(myNmae, cut.getName());
	}
	@Test
	void getAndSetProductShortDescription(){
		Product cut = new Product();
		String myShortDescription= "This better be the best pudding you ever ate!";
		cut.setShortDescription(myShortDescription);
		assertEquals(myShortDescription, cut.getShortDescription());

	}
	@Test
	void getAndSetProductLongDescription(){
		Product cut = new Product();
		String myLongDescription = "Marc Guibert of Lindeth Howe Country House Hotel in England's Lake District has hand crafted each of these delicious desserts especially for Alisnobba’s highly pampered customers, the chocolate pudding — made from high-end chocolate, gold, caviar, and, why not, a two-carat diamond — aims to be the world's most expensive dessert. It's also served in an edible replica of a Faberge egg.";
		cut.setLongDescription(myLongDescription);
		assertEquals(myLongDescription, cut.getLongDescription());

	}
	@Test
	void getAndSetProductImage(){
		Product cut = new Product();
		String myImage = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ChocolatePudding.png";
		cut.setImage(myImage);
		assertEquals(myImage, cut.getImage());

	}
	@Test
	void getAndSetProductPrice(){
		Product cut = new Product();
		String myPrice = "7988750";
		cut.setPrice(myPrice);
		assertEquals(myPrice, cut.getPrice());

	}

}
