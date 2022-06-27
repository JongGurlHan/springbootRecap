package com.jghan.springbootRecap.web;

import com.jghan.springbootRecap.config.auth.PrincipalDetails;
import com.jghan.springbootRecap.service.UserService;
import com.jghan.springbootRecap.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final UserService userService;

    @GetMapping({"/"})
    public String main(@AuthenticationPrincipal PrincipalDetails principalDetails,
                       Model model){

        UserProfileDto dto = userService.userProfile(principalDetails.getUser().getId());

        model.addAttribute("dto", dto);

        return "main";
    }


}
