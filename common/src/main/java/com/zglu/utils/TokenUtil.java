package com.zglu.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Component
public class TokenUtil {

    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
    private static String encodedKey = "zglu";
    private static Key secretKey;

    static {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        secretKey = new SecretKeySpec(decodedKey, signatureAlgorithm.getJcaName());
    }

    public static String createToken(Map map, long millis) {
        long expMillis = System.currentTimeMillis() + millis;
        Date exp = new Date(expMillis);
        String token = Jwts.builder()
                .setClaims(map)
                .setExpiration(exp)
                .signWith(signatureAlgorithm, secretKey).compact();
        return token;
    }

    public static Map parserToken(String token) {
        try {
            Map map = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
            return map;
        } catch (Exception e) {
            return null;
        }
    }
}