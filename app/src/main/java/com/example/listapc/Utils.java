package com.example.listapc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


    public class Utils {

        public static String convertirSHA256(String password){
            MessageDigest md = null;
            try{
                md = MessageDigest.getInstance("SHA-256");
            }catch (NoSuchAlgorithmException ex){
                ex.printStackTrace();
                return null;
            }

            byte[] hash=md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();

            for(byte b : hash){
                sb.append(String.format("%02x",b));
            }

            return sb.toString();
        }
    }
