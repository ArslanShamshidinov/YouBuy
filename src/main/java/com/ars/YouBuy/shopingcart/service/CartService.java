package com.ars.YouBuy.shopingcart.service;


import com.ars.YouBuy.shopingcart.mapper.CartMapper;
import com.ars.YouBuy.shopingcart.model.CartModel;
import com.ars.YouBuy.shopingcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;
    private final CartRepository cartRepository;

    public void save (CartModel shoppingCart){
        cartRepository.save(cartMapper.modelToEntity(shoppingCart));
    }

    public List<CartModel> findAll(){
        return cartRepository.findAll().stream()
                .map(cartMapper::entityToModel)
                .toList();
    }

    public Optional<CartModel> findById(Integer id){
        return cartRepository.findById(id)
                .map(cartMapper::entityToModel);
    }
    public void delete(Integer id){
        cartRepository.deleteById(id);
    }

    public void removeItems(Integer id){
        cartRepository.findById(id).get().getItems().clear();
    }


}
