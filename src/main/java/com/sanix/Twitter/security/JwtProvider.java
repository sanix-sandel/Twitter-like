/*package com.sanix.Twitter.security;

import com.sanix.Twitter.exceptions.TwitterException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

import static io.jsonwebtoken.Jwts.parser;

@Service
public class JwtProvider {

    //private KeyStore keyStore;
    private Key key;
    /*@PostConstruct
    public void init(){
        try{
            keyStore=keyStore.getInstance("JKS");
            InputStream resourceAsStream=getClass().getResourceAsStream("/springblog");
            keyStore.load(resourceAsStream, "secret".toCharArray());

        }catch(KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e){
            throw new TwitterException("Exception occured while loading keystore", e);
        }
    }*/

  /*  @PostConstruct
    public void init(){
        key=Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(Authentication authentication){
        User principal=(User)authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
                .compact();
    }

    /*private PrivateKey getPrivateKey(){
        try{
            return (PrivateKey) keyStore.getKey("springtwitter", "secret".toCharArray());

        }catch(KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e){
            throw new TwitterException("Exception occured while retrieving public key from keystore", e);
        }
    }*/

    /*public boolean validateToken(String jwt){
        parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }*/

    /*private PublicKey getPublickey(){
        try{
            return keyStore.getCertificate("springtwitter").getPublicKey();
        }catch(KeyStoreException e){
            throw new TwitterException("Exception occured while retrieving public"+
                "key frrom keyStore", e);
        }
    }*/

    /*public String getUsernameFromJWT(String token){
        Claims claims=parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }*/


/*}
*/