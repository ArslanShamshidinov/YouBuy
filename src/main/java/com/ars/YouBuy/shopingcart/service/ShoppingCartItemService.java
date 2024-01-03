package com.ars.YouBuy.shopingcart.service;


import com.ars.YouBuy.shopingcart.mapper.ShoppingCartItemMapper;
import com.ars.YouBuy.shopingcart.model.ShoppingCartItemModel;
import com.ars.YouBuy.shopingcart.repository.ShoppingCartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemService{
    private final ShoppingCartItemMapper shoppingCartItemMapper;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public void save (ShoppingCartItemModel shoppingCartItem){
        shoppingCartItemRepository.save(shoppingCartItemMapper.modelToEntity(shoppingCartItem));
    }

    public List<ShoppingCartItemModel> findAll(){
        return shoppingCartItemRepository.findAll().stream()
                .map(shoppingCartItemMapper::entityToModel)
                .toList();
    }

    public Optional<ShoppingCartItemModel> findById(Integer id){
        return shoppingCartItemRepository.findById(id)
                .map(shoppingCartItemMapper::entityToModel);
    }
    public void shoppingCartItemDelete(Integer id){
        shoppingCartItemRepository.deleteById(id);
    }

}
