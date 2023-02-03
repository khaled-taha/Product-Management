package com.kam.product.controllers;

import com.kam.product.models.Product;
import com.kam.product.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProduct();
    }
    @GetMapping("/{page}/{size}")
    List<Product> getAllProducts(@PathVariable("page") int page,
                                 @PathVariable("size") int size) {
        return productService.getPaginatedProducts(page, size);
    }
    @GetMapping("/{code}")
    Product getProduct(@PathVariable("code") String code) {
        return productService.getProductByCode(code);
    }

    @PostMapping
    Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{code}")
    void deleteProduct(@PathVariable("code") String code) {
        productService.deleteProductByCode(code);
    }

    @PutMapping("/{code}")
    Product updateProduct(@PathVariable("code") String code,
                          @RequestBody Product updateProduct) {
        return productService.updateProduct(code, updateProduct);
    }
}