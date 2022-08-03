package com.graphql.test.ui.models.resolvers;

import com.graphql.test.service.UserService;
import com.graphql.test.share.UserDto;
import com.graphql.test.ui.models.UserResp;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;

    public UserResp getUser(String userId){
        UserResp userResp = new UserResp();
        UserDto userDto = new UserDto();

        userDto = userService.getUserByUserId(userId);

        System.out.println(userDto.getUserId());
        BeanUtils.copyProperties(userDto, userResp);
        System.out.println();
        return userResp;
    }
}
