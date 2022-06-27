package com.jghan.springbootRecap.service;


import com.jghan.springbootRecap.domain.user.User;
import com.jghan.springbootRecap.domain.user.UserRepository;
import com.jghan.springbootRecap.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserProfileDto userProfile(int principalId){
        UserProfileDto dto = new UserProfileDto();

        User userEntity = userRepository.findById(principalId).orElseThrow();

        return dto;




    }


}
