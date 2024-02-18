package com.mrizkisaputra.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Data
@Component
public class RSAKeyProperties {
    private RSAPublicKey publicKey;

    private RSAPrivateKey privateKey;

    public RSAKeyProperties() {
        KeyPair keyPair = KeyGeneratorUtil.generateRsaKey();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
    }
}
