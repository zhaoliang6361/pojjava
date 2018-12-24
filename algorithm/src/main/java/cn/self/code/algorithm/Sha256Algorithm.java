package cn.self.code.algorithm;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class Sha256Algorithm {

    public static void main(String[] args) {
        Sha256Algorithm obj = new Sha256Algorithm();
        String token = obj.createToken();
        System.out.println(token);

        DecodedJWT jwt = obj.decodedToken(token);
        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("pn: " + jwt.getClaim("pn").asString());
        System.out.println("expireDate: " + jwt.getExpiresAt());
    }

    private static String secret = "jp_platform";

    public String createToken(){
        String token = "";
        Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
        try {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("pn","CN2008")
                    .withClaim("name","e.cnipr.com")
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(secret));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public DecodedJWT decodedToken(String token){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer("auth0")
                    .build();
            jwt = verifier.verify(token);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return jwt;
    }


}
