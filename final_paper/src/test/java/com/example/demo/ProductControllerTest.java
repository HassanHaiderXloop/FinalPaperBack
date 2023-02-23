package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
// import org.hibernate.annotations.UpdateTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void postANewCart() throws Exception{
        Product product = Product.builder()
                            .name("table")
                            .shortDescription("it's a table")
                            .longDescription("it's a table it's a table it's a table")
                            .image("it's a table")
                            .price("987654")
                            .build();
        given(productRepository.save(any(Product.class))).willAnswer((invocation) -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/product/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(product)));
        response.andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name",is(product.getName())))
            .andExpect(jsonPath("$.shortDescription",is(product.getImage())))
           .andExpect(jsonPath("$.longDescription", is(product.getLongDescription())))
           .andExpect(jsonPath("$.image",is(product.getImage())))
           .andExpect(jsonPath("$.price", is(product.getPrice())));
    }

    @Test
    public void getAllTheProduct() throws Exception{
        Product product1 = Product.builder()
        .name("table")
        .shortDescription("it's a table")
        .longDescription("it's a table it's a table it's a table")
        .image("it's a table")
        .price("987654")
        .build(); 
        Product product2 = Product.builder()
        .name("table")
        .shortDescription("it's a table")
        .longDescription("it's a table it's a table it's a table")
        .image("it's a table")
        .price("987654")
        .build(); 
        List<Product> products = List.of(product1,product2);
        // given(cartRepository.findAll()).willReturn();
        given(productRepository.findAll()).willReturn(products);


        ResultActions response = mockMvc.perform(get("/product/all"));
        
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(products.size())));
    }

    @Test
    public void getOneProductById() throws Exception{
       // Long thingId = 1L;
        Product product = Product.builder()
        .id(1L)
        .name("table")
        .shortDescription("it's a table")
        .longDescription("it's a table it's a table it's a table")
        .image("it's a table")
        .price("987654")
        .build(); 
        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        ResultActions response = mockMvc.perform(get("/product/{id}", product.getId()));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.shortDescription", is(product.getShortDescription())))
                .andExpect(jsonPath("$.price", is(product.getPrice())));
    }




}
