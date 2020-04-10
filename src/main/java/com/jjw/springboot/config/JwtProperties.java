package com.jjw.springboot.config;

import com.jjw.springboot.util.RsaUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@Slf4j
@Data
@ConfigurationProperties(prefix = "qihui.jwt")
public class JwtProperties {

    private String secret;

    private String pubKeyPath;

    private String priKeyPath;

    private Integer expire;

    private PublicKey publicKey;

    private PrivateKey privateKey;


    @PostConstruct
    public void init() {
        try {
            File pubKey = new File(pubKeyPath);
            File priKey = new File(priKeyPath);

            if (!priKey.exists() || !pubKey.exists()) {
                RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
            }

            //获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        }catch (Exception e) {

            log.info("初始化公钥和私钥失败");
            throw new RuntimeException("初始化公钥和私钥失败");
        }
    }

}
