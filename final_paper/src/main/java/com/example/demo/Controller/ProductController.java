package com.example.demo.Controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;


@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
      //  // List<Product> products = productServiceImpl.getAllProduct();
      //  // return new ResponseEntity<>(products, HttpStatus.OK);
        return ResponseEntity.ok().body(productRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(productRepository.findById(id).get());

      //  // Optional<Product> product = productServiceImpl.getProductById(id);
      //  // if (product.isPresent()){
      //  //     return new ResponseEntity<>(product.get(), HttpStatus.OK);
      //  // }else{
      //  //     return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
      //  // }
    }

    
}
