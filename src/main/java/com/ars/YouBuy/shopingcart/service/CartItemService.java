package com.ars.YouBuy.shopingcart.service;


import com.ars.YouBuy.shopingcart.mapper.CartItemMapper;
import com.ars.YouBuy.shopingcart.model.CartItemModel;
import com.ars.YouBuy.shopingcart.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemMapper cartItemMapper;
    private final CartItemRepository cartItemRepository;

    public void save(CartItemModel shoppingCartItem) {
        cartItemRepository.save(CartItemMapper.modelToEntity(shoppingCartItem));
    }

    public List<CartItemModel> findAll() {
        return cartItemRepository.findAll().stream().map(cartItemMapper::entityToModel).toList();
    }

    public Optional<CartItemModel> findById(Integer id) {
        return cartItemRepository.findById(id).map(cartItemMapper::entityToModel);
    }

    public void delete(Integer id) {
        cartItemRepository.deleteById(id);
    }

}
