package com.example.oauth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the OAuth2 Client Demo!";
    }

    @GetMapping("/userinfo")
    public String userInfo(@AuthenticationPrincipal OidcUser oidcUser) {
        return "User Info: " + oidcUser.getAttributes();
    }
}
