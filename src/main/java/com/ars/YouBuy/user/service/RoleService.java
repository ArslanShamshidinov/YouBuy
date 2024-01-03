package com.ars.YouBuy.user.service;

import com.ars.YouBuy.user.mapper.RoleMapper;
import com.ars.YouBuy.user.model.RoleModel;
import com.ars.YouBuy.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
        private final RoleMapper roleMapper;
        private final RoleRepository roleRepository;

        public void save (RoleModel role){
            roleRepository.save(roleMapper.modelToEntity(role));
        }

        public List<RoleModel> findAll(){
            return roleRepository.findAll().stream()
                    .map(roleMapper::entityToModel)
                    .toList();
        }

        public Optional<RoleModel> findById(Integer id){
            return roleRepository.findById(id)
                    .map(roleMapper::entityToModel);
        }
        public void productDelete(Integer id){
            roleRepository.deleteById(id);
        }
}
