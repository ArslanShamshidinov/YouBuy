package com.ars.YouBuy.category.mapper;

import com.ars.YouBuy.category.dto.CategoryResponse;
import com.ars.YouBuy.category.entity.Category;
import com.ars.YouBuy.category.model.CategoryModel;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {
    public CategoryModel entityToModel(Category category) {
        return CategoryModel.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category modelToEntity(CategoryModel category) {
        return Category.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public CategoryModel dtoToModel(CategoryResponse category) {
        return CategoryModel.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public CategoryResponse modelToDto(CategoryModel category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
