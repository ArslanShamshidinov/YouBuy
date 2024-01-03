package com.ars.YouBuy.product.service;

import com.ars.YouBuy.product.mapper.ProductMapper;
import com.ars.YouBuy.product.model.ProductModel;
import com.ars.YouBuy.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public void save (ProductModel product){
        productRepository.save(productMapper.modelToEntity(product));
    }

    public List<ProductModel> findAll(){
        return productRepository.findAll().stream()
                .map(productMapper::entityToModel)
                .toList();
    }

    public Optional<ProductModel> findById(Integer id){
        return productRepository.findById(id)
                .map(productMapper::entityToModel);
    }
    public void productDelete(Integer id){
        productRepository.deleteById(id);
    }

}
