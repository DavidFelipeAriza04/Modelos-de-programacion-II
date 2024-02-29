import java.math.BigInteger;

public class Cifras {
    public static BigInteger suma(BigInteger num1, BigInteger num2) {
        return num1.add(num2);
    }

    public static BigInteger resta(BigInteger num1, BigInteger num2) {
        return num1.subtract(num2);
    }

    public static BigInteger multiplicacion(BigInteger num1, BigInteger num2) {
        return num1.multiply(num2);
    }

    public static BigInteger division(BigInteger numl, BigInteger num2) {
        return numl.divide(num2);
    }

    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("3446337816708764726311443549387477515954");
        BigInteger num2 = new BigInteger("1920842773784952972573043271360104463375");
        long startTime = System.nanoTime();
        suma(num1, num2);
        // resta(num1, num2);
        // multiplicacion(num1, num2);
        // division(num1, num2);
        long endTime = System.nanoTime() - startTime;
        System.out.println((endTime) / 1e6 + " ms");
    }
}