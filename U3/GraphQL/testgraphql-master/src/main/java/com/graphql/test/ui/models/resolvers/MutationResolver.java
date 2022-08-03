package com.graphql.test.ui.models.resolvers;

import com.graphql.test.service.UserService;
import com.graphql.test.share.UserDto;
import com.graphql.test.ui.models.UserResp;
import com.graphql.test.ui.models.userDetail;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    UserService userService;

    public UserResp createUser(userDetail userDetail){
        UserResp returnValue = new UserResp();
        UserDto userDto = new UserDto();
        userDto.setFirstName(userDetail.getFirstName());
        userDto.setLastName(userDetail.getLastName());
        userDto.setEmail(userDetail.getEmail());
        userDto = userService.createUser(userDto);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }
}
