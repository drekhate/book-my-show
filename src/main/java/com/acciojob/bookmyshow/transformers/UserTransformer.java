package com.acciojob.bookmyshow.transformers;

import com.acciojob.bookmyshow.dtos.AddUserRequest;
import com.acciojob.bookmyshow.models.User;

public class UserTransformer {
    public static User convertAddUserReqToUser(AddUserRequest addUserRequest) {
        User user = User.builder()
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmailId())
                .userName(addUserRequest.getUserName())
                .mobNo(addUserRequest.getMobNo())
                .build();
        return user;
    }
}
