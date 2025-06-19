package com.senac.ProjetoIntegrador.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaMD5 {
    
    public static String gerarHashMD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mensagemDigest = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : mensagemDigest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash MD5", e);
        }
    }
}
