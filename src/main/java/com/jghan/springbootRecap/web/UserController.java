package com.jghan.springbootRecap.web;

import com.jghan.springbootRecap.config.auth.PrincipalDetails;
import com.jghan.springbootRecap.service.UserService;
import com.jghan.springbootRecap.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;


    @GetMapping({"/user/{userId}"})
    public String profile(Model model,
                          @AuthenticationPrincipal PrincipalDetails principalDetails){

        UserProfileDto dto = userService.userProfile(principalDetails.getUser().getId());

        model.addAttribute("dto", dto);
        return "user/profile";
    }
}
