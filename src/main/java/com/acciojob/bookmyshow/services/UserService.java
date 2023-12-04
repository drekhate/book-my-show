package com.acciojob.bookmyshow.services;

import com.acciojob.bookmyshow.dtos.AddUserRequest;
import com.acciojob.bookmyshow.models.User;
import com.acciojob.bookmyshow.repositorys.UserRepository;
import com.acciojob.bookmyshow.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest) {
//        create user obj and save it
//        User user = new User();
//        user.setAge(addUserRequest.getAge());
//        user.setName(addUserRequest.getName());
//        user.setEmailId(addUserRequest.getEmailId());
//        user.setMobNo(addUserRequest.getMobNo());
//        User user = User.builder()
//                .age(addUserRequest.getAge())
//                .emailId(addUserRequest.getEmailId())
//                .name(addUserRequest.getName())
//                .mobNo(addUserRequest.getMobNo())
//                .build();
        User user = UserTransformer.convertAddUserReqToUser(addUserRequest);
        userRepository.save(user);
        return "user has been added successfully";
    }
}
