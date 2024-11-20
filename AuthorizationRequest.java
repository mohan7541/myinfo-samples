package com.myinfo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AuthorizationRequest {
    public static String createAuthRequest(String authEndpoint, String clientId, String redirectUri, 
                                           String codeChallenge, String state, String nonce) {
        return authEndpoint + "?" +
                "response_type=code" +
                "&client_id=" + URLEncoder.encode(clientId, StandardCharsets.UTF_8) +
                "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8) +
                "&scope=openid%20profile%20email" +
                "&code_challenge=" + URLEncoder.encode(codeChallenge, StandardCharsets.UTF_8) +
                "&code_challenge_method=S256" +
                "&state=" + URLEncoder.encode(state, StandardCharsets.UTF_8) +
                "&nonce=" + URLEncoder.encode(nonce, StandardCharsets.UTF_8);
    }
}
