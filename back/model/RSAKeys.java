package back.model;

import java.math.BigInteger;

public class RSAKeys {

    public BigInteger e;
    public BigInteger d;
    public BigInteger n;

    public RSAKeys(BigInteger e, BigInteger d, BigInteger n) {

        this.e = e;
        this.d = d;
        this.n = n;
    }
}