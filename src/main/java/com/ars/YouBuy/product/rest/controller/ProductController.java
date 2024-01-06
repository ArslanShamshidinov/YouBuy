package com.ars.YouBuy.product.rest.controller;

import com.ars.YouBuy.category.model.CategoryModel;
import com.ars.YouBuy.category.service.CategoryService;
import com.ars.YouBuy.common.service.FileStorageService;
import com.ars.YouBuy.product.rest.dto.dto.ProductResponse;
import com.ars.YouBuy.product.mapper.ProductMapper;
import com.ars.YouBuy.product.model.ProductModel;
import com.ars.YouBuy.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final FileStorageService fileStorageService;


    @GetMapping("/all")
    public List<ProductResponse> getAll() {
        return productService.findAll().stream().map(ProductMapper::modelToDto).toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return productService.findById(id).map(ProductMapper::modelToDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

    }

    @PostMapping("/create")
    public void addProduct(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam BigDecimal price, @RequestParam Integer categoryId) throws FileNotFoundException {

        CategoryModel category = categoryService.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category is selected"));
        var imageUrl = fileStorageService.storeFile(file);

        var productModel = ProductModel.builder().categoryId(categoryId).name(name).price(price).imageUrl(imageUrl).build();

        productService.save(productModel);

    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable("id") Integer id, @RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("name") String name, @RequestParam("price") BigDecimal price, @RequestParam("categoryId") Integer categoryId) throws FileNotFoundException {

        CategoryModel category = categoryService.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category is selected"));

        ProductModel oldProduct = productService.findById(id).orElseThrow(() -> new IllegalArgumentException("Product by id " + id + " not found"));
        String fileName = "";

        if (file != null) {
            fileName = fileStorageService.storeFile(file);
            String url = oldProduct.getImageUrl();
            String oldFileName = url.substring(url.lastIndexOf('/') + 1, url.length());
            fileStorageService.deleteFile(oldFileName);
        }

        var productModel = ProductModel.builder().id(id).name(name).price(price).categoryId(categoryId).imageUrl(file != null ? "http://localhost:8081/api/files/download/" + fileName : oldProduct.getImageUrl()).build();

        this.productService.save(productModel);
    }

}
