package com.ars.YouBuy.category.service;

import com.ars.YouBuy.category.mapper.CategoryMapper;
import com.ars.YouBuy.category.model.CategoryModel;
import com.ars.YouBuy.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
        private final CategoryMapper categoryMapper;
        private final CategoryRepository categoryRepository;

        public void save (CategoryModel category){
            categoryRepository.save(categoryMapper.modelToEntity(category));
        }

        public List<CategoryModel> findAll(){
            return categoryRepository.findAll().stream()
                    .map(categoryMapper::entityToModel)
                    .toList();
        }

        public Optional<CategoryModel> findById(Integer id){
            return categoryRepository.findById(id)
                    .map(categoryMapper::entityToModel);
        }
        public void productDelete(Integer id){
            categoryRepository.deleteById(id);
        }
}
