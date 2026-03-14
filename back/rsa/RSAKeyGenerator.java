package back.rsa;

import java.math.BigInteger;
import back.model.RSAKeys;

public class RSAKeyGenerator {

    public static RSAKeys generateKeys() {

        BigInteger Lal_p = MathUtil.generatePrime();

        BigInteger Lal_q = MathUtil.generatePrime();

        BigInteger Lal_n = Lal_p.multiply(Lal_q);

        BigInteger Lal_phi =
                (Lal_p.subtract(BigInteger.ONE))
                        .multiply(Lal_q.subtract(BigInteger.ONE));

        BigInteger Lal_e = BigInteger.valueOf(65537);

        while (!MathUtil.gcd(Lal_e, Lal_phi).equals(BigInteger.ONE)) {

            Lal_e = Lal_e.add(BigInteger.TWO);
        }

        BigInteger Lal_d = MathUtil.modInverse(Lal_e, Lal_phi);

        return new RSAKeys(Lal_e, Lal_d, Lal_n);
    }
}