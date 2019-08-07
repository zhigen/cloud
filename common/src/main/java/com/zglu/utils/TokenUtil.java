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

    private static final String encodedKey = "zglu";
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
    private static Key secretKey;

    static {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        secretKey = new SecretKeySpec(decodedKey, signatureAlgorithm.getJcaName());
    }

    public static String createToken(Map<String, Object> map, long millis) {
        long expMillis = System.currentTimeMillis() + millis;
        Date exp = new Date(expMillis);
        return Jwts.builder()
                .setClaims(map)
                .setExpiration(exp)
                .signWith(signatureAlgorithm, secretKey)
                .compact();
    }

    public static Map parserToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer parserTokenToId(String token) {
        try {
            Map map = parserToken(token);
            return (Integer) map.get("id");
        } catch (Exception e) {
            return Integer.parseInt(token);
        }
    }
}