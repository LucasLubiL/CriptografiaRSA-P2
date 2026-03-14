package back.rsa;

import java.math.BigInteger;

public class RSA {

    public static BigInteger encrypt(BigInteger Lal_message, BigInteger Lal_e, BigInteger Lal_n) {

        return Lal_message.modPow(Lal_e, Lal_n);
    }

    public static BigInteger decrypt(BigInteger Lal_cipher, BigInteger Lal_d, BigInteger Lal_n) {

        return Lal_cipher.modPow(Lal_d, Lal_n);
    }
}