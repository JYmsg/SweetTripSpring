package com.ssafy.trip.util;

import java.util.*;
import java.math.BigInteger;
import java.security.*;

public class SHA256Util {

    public static String generateSalt() {
        Random random = new Random();
        
        byte[] bytes = new byte[8]; // 랜덤 8바이트 base64 인코딩하여 return
        random.nextBytes(bytes);
        
        String salt = new String(Base64.getEncoder().encode(bytes));
        return salt;
    }
    
    public static String getEncrypt(String password, String salt) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update((password + salt).getBytes());
        String hex = String.format("%064x", new BigInteger(1, md.digest()));
        return hex;
    }
}