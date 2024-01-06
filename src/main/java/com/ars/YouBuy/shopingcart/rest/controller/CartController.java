package com.ars.YouBuy.shopingcart.rest.controller;

import com.ars.YouBuy.product.service.ProductService;
import com.ars.YouBuy.shopingcart.entity.CartItem;
import com.ars.YouBuy.shopingcart.mapper.CartItemMapper;
import com.ars.YouBuy.shopingcart.mapper.CartMapper;
import com.ars.YouBuy.shopingcart.model.CartModel;
import com.ars.YouBuy.shopingcart.rest.dto.dto.CartItemResponse;
import com.ars.YouBuy.shopingcart.rest.dto.dto.CartResponse;
import com.ars.YouBuy.shopingcart.service.CartItemService;
import com.ars.YouBuy.shopingcart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final CartItemService cartItemService;

    @GetMapping("/{id}")
    public CartResponse getById(@PathVariable Integer id) {
        return cartService.findById(id).map(CartMapper::modelToDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = {"/", " "})
    public Iterable<CartResponse> getAll() {
        return cartService.findAll().stream().map(CartMapper::modelToDto).toList();
    }

    @PostMapping("/create")
    public CartResponse create() {
        CartModel cart = new CartModel();
        cart.setCreated(ZonedDateTime.now());

        cartService.save(cart);

        return CartMapper.modelToDto(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartService.delete(id);
    }

    @GetMapping("/{cartId}/items/{productId}")
    public CartItemResponse getShoppingCartItem(@PathVariable("cartId") Integer cartId, @PathVariable("productId") Integer productId) {
        Set<CartItem> items = cartService.findById(cartId).map(CartModel::getItems).orElseThrow();

        return items.stream().filter(item -> Objects.equals(item.getProductId(), productId)).map(item -> new CartItemResponse(item.getId(), item.getQuantity(), item.getProductId())).findFirst().orElse(null);
    }

    @PostMapping("/{cartId}/items")
    public CartResponse createShoppingCartItem(@PathVariable Integer cartId, @RequestBody CartItemResponse request) {

        CartModel cart = cartService.findById(cartId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        productService.findById(request.getProductId()).ifPresent(productModel -> {
            CartItemResponse item = CartItemResponse.builder().quantity(request.getQuantity()).productId(request.getProductId()).build();

            var cartItem = CartItemMapper.dtoToModel(item);

            cartItemService.save(cartItem);
            cart.getItems().add(CartItemMapper.modelToEntity(cartItem));
            cartService.save(cart);
        });

        return CartMapper.modelToDto(cart);
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public CartResponse deleteCartItem(@PathVariable Integer cartId, @PathVariable Integer productId) {

        var cart = cartService.findById(cartId).orElseThrow();

        cart.getItems().stream().filter(item -> Objects.equals(item.getProductId(), productId)).forEach(item -> {
            cart.getItems().remove(item);
            cartItemService.delete(cartId);
            cartService.save(cart);
        });

        return CartMapper.modelToDto(cart);
    }

    @DeleteMapping("/{cartId}/clear")
    public CartResponse clearShoppingCart(@PathVariable Integer cartId) {
        CartModel cart = cartService.findById(cartId).orElseThrow();

        cartService.removeItems(cartId);
        cartService.save(cart);

        cart.getItems().forEach(item -> cartItemService.delete(cartId));

        return CartMapper.modelToDto(cart);
    }


}
