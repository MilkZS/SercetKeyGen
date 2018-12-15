package RSA;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class RSAGenSercet {

    public static final int BASE64 = 10;

    private static final Base64.Encoder encoder = Base64.getEncoder();

    public static boolean exportKey(RSAbean rsAbean,int mode) {
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        // 密钥位数
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 公钥
        PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        byte[] publicKeyData = publicKey.getEncoded();
        byte[] privateKeyData = privateKey.getEncoded();

        switch (mode){
            case BASE64:{
                rsAbean.setPubKey(encoder.encodeToString(publicKeyData));
                rsAbean.setPriKey(encoder.encodeToString(privateKeyData));
                return true;
            }
        }

        return false;
    }


}
