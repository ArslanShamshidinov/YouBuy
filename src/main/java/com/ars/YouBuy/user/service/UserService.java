package com.ars.YouBuy.user.service;


import com.ars.YouBuy.user.mapper.UserMapper;
import com.ars.YouBuy.user.model.UserModel;
import com.ars.YouBuy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public void save (UserModel user){
        userRepository.save(userMapper.modelToEntity(user));
    }

    public List<UserModel> findAll(){
        return userRepository.findAll().stream()
                .map(userMapper::entityToModel)
                .toList();
    }

    public Optional<UserModel> findById(Integer id){
        return userRepository.findById(id)
                .map(userMapper::entityToModel);
    }
    public void productDelete(Integer id){
        userRepository.deleteById(id);
    }

}
