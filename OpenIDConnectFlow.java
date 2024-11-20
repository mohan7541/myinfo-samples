package com.myinfo;

import java.util.UUID;

public class OpenIDConnectFlow {
    public static void main(String[] args) throws Exception {
        // Constants
        String authEndpoint = "https://example.com/authorize";
        String tokenEndpoint = "https://example.com/token";
        String userInfoEndpoint = "https://example.com/userinfo";
        String clientId = "your-client-id";
        String redirectUri = "http://localhost:8080/callback";

        // PKCE
        String codeVerifier = PKCEUtil.generateCodeVerifier();
        String codeChallenge = PKCEUtil.generateCodeChallenge(codeVerifier);

        // State and Nonce
        String state = UUID.randomUUID().toString();
        String nonce = UUID.randomUUID().toString();

        // Authorization Request
        String authUrl = AuthorizationRequest.createAuthRequest(authEndpoint, clientId, redirectUri, codeChallenge, state, nonce);
        System.out.println("Visit this URL for authentication: " + authUrl);

        // Simulate receiving the authorization code (you'll capture this from the redirect URL in a real app)
        String authorizationCode = "received-authorization-code";

        // Token Exchange
        String tokenResponse = TokenExchange.exchangeToken(tokenEndpoint, clientId, authorizationCode, redirectUri, codeVerifier);
        System.out.println("Token Response: " + tokenResponse);

        // Extract access_token from response (parse JSON)
        String accessToken = "extracted-access-token";

        // Fetch UserInfo
        String userInfo = UserInfo.fetchUserInfo(userInfoEndpoint, accessToken);
        System.out.println("User Info: " + userInfo);
    }
}
