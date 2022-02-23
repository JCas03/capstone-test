package com.hcl.ppmtool.security;

import com.hcl.ppmtool.PpmtoolApplication;
import com.hcl.ppmtool.domain.User;
import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.hcl.ppmtool.security.SecurityConstants.EXPIRATION_TIME;
import static com.hcl.ppmtool.security.SecurityConstants.SECRET;

@Component
public class JwtTokenProvider {
    Logger log = LogManager.getLogger(PpmtoolApplication.class);
    //Generate the token

    public String generateToken(Authentication authentication){
        User user = (User)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String,Object> claims = new HashMap<>();
        claims.put("id", (Long.toString(user.getId())));
        claims.put("username", user.getUsername());
        claims.put("fullName", user.getFullName());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        }

    //Validate the token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            log.info("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            log.info("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            log.info("Expired JWT token");
        }catch (UnsupportedJwtException ex){
            log.info("Unsupported JWT token");
        }catch (IllegalArgumentException ex){
            log.info("JWT claims string is empty");
        }
        return false;
    }


    //Get user Id from token

    public Long getUserIdFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String id = (String)claims.get("id");

        return Long.parseLong(id);
    }
}
