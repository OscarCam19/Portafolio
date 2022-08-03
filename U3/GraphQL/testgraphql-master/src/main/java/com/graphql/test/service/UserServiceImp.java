package com.graphql.test.service;

import com.graphql.test.io.entity.UserEntity;
import com.graphql.test.io.repository.UserRepository;
import com.graphql.test.share.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);
        BeanUtils.copyProperties(userEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDto, userEntity);
        userEntity.setUserId(userDto.getFirstName() + "2");

        UserEntity storedValue = userRepository.save(userEntity);

        BeanUtils.copyProperties(storedValue, returnValue);

        return returnValue;
    }


}
