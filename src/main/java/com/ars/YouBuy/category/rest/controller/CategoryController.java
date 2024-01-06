package com.ars.YouBuy.category.rest.controller;

import com.ars.YouBuy.category.rest.dto.dto.CategoryResponse;
import com.ars.YouBuy.category.mapper.CategoryMapper;
import com.ars.YouBuy.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryResponse> getAll() {
        return categoryService.findAll().stream()
                .map(CategoryMapper::modelToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<CategoryResponse> getById(@PathVariable Integer id) {
        return categoryService.findById(id).map(CategoryMapper::modelToDto);
    }
}
