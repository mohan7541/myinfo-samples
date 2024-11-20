package com.myinfo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TokenExchange {
    public static String exchangeToken(String tokenEndpoint, String clientId, String code, String redirectUri, 
                                       String codeVerifier) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, String> body = new HashMap<>();
        body.put("grant_type", "authorization_code");
        body.put("code", code);
        body.put("redirect_uri", redirectUri);
        body.put("client_id", clientId);
        body.put("code_verifier", codeVerifier);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(tokenEndpoint, HttpMethod.POST, request, String.class);

        return response.getBody(); // Contains access_token, id_token, etc.
    }
}

