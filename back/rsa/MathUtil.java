package back.rsa;

import java.math.BigInteger;
import java.util.Random;

public class MathUtil {

    public static BigInteger generatePrime() {

        Random Lal_random = new Random();

        return BigInteger.probablePrime(16, Lal_random);
    }

    public static BigInteger gcd(BigInteger Lal_a, BigInteger Lal_b) {

        while (!Lal_b.equals(BigInteger.ZERO)) {

            BigInteger Lal_temp = Lal_b;

            Lal_b = Lal_a.mod(Lal_b);

            Lal_a = Lal_temp;
        }

        return Lal_a;
    }

    // ALGORITMO DE EUCLIDES ESTENDIDO
    public static BigInteger modInverse(BigInteger Lal_e, BigInteger Lal_phi) {

        BigInteger Lal_t = BigInteger.ZERO;
        BigInteger Lal_newT = BigInteger.ONE;

        BigInteger Lal_r = Lal_phi;
        BigInteger Lal_newR = Lal_e;

        while (!Lal_newR.equals(BigInteger.ZERO)) {

            BigInteger Lal_q = Lal_r.divide(Lal_newR);

            BigInteger Lal_tempT = Lal_t.subtract(Lal_q.multiply(Lal_newT));
            Lal_t = Lal_newT;
            Lal_newT = Lal_tempT;

            BigInteger Lal_tempR = Lal_r.subtract(Lal_q.multiply(Lal_newR));
            Lal_r = Lal_newR;
            Lal_newR = Lal_tempR;
        }

        if (Lal_r.compareTo(BigInteger.ONE) > 0) {

            throw new ArithmeticException("e não possui inverso modular");
        }

        if (Lal_t.compareTo(BigInteger.ZERO) < 0) {

            Lal_t = Lal_t.add(Lal_phi);
        }

        return Lal_t;
    }
}