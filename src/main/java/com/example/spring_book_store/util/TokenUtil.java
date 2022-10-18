package com.example.spring_book_store.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil
{
    private static final String TOKEN = "darshan";

    public String createToken(int id)
    {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN);
        return JWT.create().withClaim("id", id).sign(algorithm);
    }

    public int decodeToken(String token) throws SignatureVerificationException
    {
        Verification verification = JWT.require(Algorithm.HMAC256(TOKEN));
        JWTVerifier jwtVerifier = verification.build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Claim claim = decodedJWT.getClaim("id");
        return claim.asInt();
    }
}