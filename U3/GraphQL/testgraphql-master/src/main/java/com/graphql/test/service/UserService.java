package com.graphql.test.service;

import com.graphql.test.share.UserDto;

public interface UserService {
    UserDto getUserByUserId(String userId);
    UserDto createUser(UserDto userDto);
}
