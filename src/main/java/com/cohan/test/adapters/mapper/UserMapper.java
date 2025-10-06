package com.cohan.test.adapters.mapper;

import com.cohan.test.adapters.outbound.persistence.jpa.User;
import com.cohan.test.domain.model.payload.UserResponse;

public class UserMapper {

    public static UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        return userResponse;
    }

}
