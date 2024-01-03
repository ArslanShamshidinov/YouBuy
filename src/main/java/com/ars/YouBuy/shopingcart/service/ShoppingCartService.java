package com.ars.YouBuy.shopingcart.service;


import com.ars.YouBuy.shopingcart.mapper.ShoppingCartMapper;
import com.ars.YouBuy.shopingcart.model.ShoppingCartModel;
import com.ars.YouBuy.shopingcart.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService{
    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartRepository shoppingCartRepository;

    public void save (ShoppingCartModel shoppingCart){
        shoppingCartRepository.save(shoppingCartMapper.modelToEntity(shoppingCart));
    }

    public List<ShoppingCartModel> findAll(){
        return shoppingCartRepository.findAll().stream()
                .map(shoppingCartMapper::entityToModel)
                .toList();
    }

    public Optional<ShoppingCartModel> findById(Integer id){
        return shoppingCartRepository.findById(id)
                .map(shoppingCartMapper::entityToModel);
    }
    public void shoppingCartDelete(Integer id){
        shoppingCartRepository.deleteById(id);
    }

}
