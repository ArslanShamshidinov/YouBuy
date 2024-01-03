package com.ars.YouBuy.product.mapper;

import com.ars.YouBuy.product.dto.ProductResponse;
import com.ars.YouBuy.product.entity.Product;
import com.ars.YouBuy.product.model.ProductModel;
import org.springframework.stereotype.Component;

@Component()
public class ProductMapper {
    public ProductModel entityToModel(Product product){
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
                .imageUrl(product.getImageUrl())
                .build();
    }
    public Product modelToEntity(ProductModel product){
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public ProductResponse modelToDto(ProductModel product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
                .imageUrl(product.getImageUrl())
                .build();
    }
     public ProductModel dtoToModel(ProductResponse product){
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
                .imageUrl(product.getImageUrl())
                .build();
    }


}
