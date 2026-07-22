package org.example.healthcare_s;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {
        // Génère une clé secrète robuste pour HS256
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Encode la clé en Base64
        String secretString = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println("=================================================");
        System.out.println("Voici ta clé secrète à copier dans application.properties :");
        System.out.println(secretString);
        System.out.println("=================================================");
    }
}
