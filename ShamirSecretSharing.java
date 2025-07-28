/*
 * Shamir's Secret Sharing (Java Edition)
 * --------------------------------------
 * Author: Aryan (definitely not an AI)
 *
 * This code reconstructs the secret constant term of a polynomial
 * using Lagrange interpolation. It's like magic, but with more math.
 *
 * If you can read this, congrats! You have unlocked the source code.
 *
 * May your secrets be safe and your bugs be few. 🚀
 */

import java.math.BigInteger;
import java.util.*;

public class ShamirSecretSharing {
    // Point class: because Java doesn't have tuples and we like to be extra
    static class Point {
        BigInteger x, y;
        Point(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Welcome to the Shamir's Secret Sharing Show! 🎩✨");
            System.out.println("Solving Test Case 1 (let's warm up):");
            solveTestCase1();

            System.out.println("\nSolving Test Case 2 (now with more digits):");
            solveTestCase2();

            System.out.println("\nAll done! Go flex your math skills on LinkedIn. 💪");
        } catch (Exception e) {
            System.out.println("Oops! Something went wrong. Blame the compiler, not me.");
            e.printStackTrace();
        }
    }

    // Test Case 1: Small numbers, big dreams
    public static void solveTestCase1() {
        int n = 4;
        int k = 3;
        System.out.println("n = " + n + ", k = " + k);

        // Points decoded from the JSON (no cap)
        List<Point> points = new ArrayList<>();
        points.add(new Point(BigInteger.ONE, BigInteger.valueOf(4))); // (1, 4)
        points.add(new Point(BigInteger.valueOf(2), BigInteger.valueOf(7))); // (2, 7)
        points.add(new Point(BigInteger.valueOf(3), BigInteger.valueOf(12))); // (3, 12)
        points.add(new Point(BigInteger.valueOf(6), BigInteger.valueOf(39))); // (6, 39)

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            System.out.println("Point " + (i+1) + ": (" + p.x + ", " + p.y + ")");
        }

        // Only need the first k points for the secret sauce
        List<Point> interpolationPoints = points.subList(0, k);
        BigInteger secret = findConstantTerm(interpolationPoints);
        System.out.println("Secret (constant term c): " + secret + " 🤫");
    }

    // Test Case 2: Big numbers, bigger vibes
    public static void solveTestCase2() {
        int n = 10;
        int k = 7;
        System.out.println("n = " + n + ", k = " + k);

        List<Point> points = new ArrayList<>();
        points.add(new Point(BigInteger.ONE, new BigInteger("13444211440455345511", 6)));
        points.add(new Point(BigInteger.valueOf(2), new BigInteger("aed7015a346d63", 15)));
        points.add(new Point(BigInteger.valueOf(3), new BigInteger("6aeeb69631c227c", 15)));
        points.add(new Point(BigInteger.valueOf(4), new BigInteger("e1b5e05623d881f", 16)));
        points.add(new Point(BigInteger.valueOf(5), new BigInteger("316034514573652620673", 8)));
        points.add(new Point(BigInteger.valueOf(6), new BigInteger("2122212201122002221120200210011020220200", 3)));
        points.add(new Point(BigInteger.valueOf(7), new BigInteger("20120221122211000100210021102001201112121", 3)));
        points.add(new Point(BigInteger.valueOf(8), new BigInteger("20220554335330240002224253", 6)));
        points.add(new Point(BigInteger.valueOf(9), new BigInteger("45153788322a1255483", 12)));
        points.add(new Point(BigInteger.valueOf(10), new BigInteger("1101613130313526312514143", 7)));

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            System.out.println("Point " + (i+1) + ": (" + p.x + ", " + p.y + ")");
        }

        List<Point> interpolationPoints = points.subList(0, k);
        BigInteger secret = findConstantTerm(interpolationPoints);
        System.out.println("Secret (constant term c): " + secret + " 🤐");
    }

    /**
     * Lagrange interpolation: the real MVP
     *
     * In plain English:
     * - For each point, we build a "mini-polynomial" that's 1 at that point and 0 at all others.
     * - We multiply each y-value by its mini-polynomial (the Lagrange coefficient).
     * - Add them all up, and you get the value of the original polynomial at x=0 (the secret!).
     *
     * Formula:
     *   f(0) = sum_{i=0}^{n-1} y_i * product_{j!=i} (0 - x_j) / (x_i - x_j)
     *
     * It's like making a smoothie: each fruit (point) gets blended in with its own special weight,
     * and the result is delicious (the secret)!
     */
    public static BigInteger findConstantTerm(List<Point> points) {
        int n = points.size();
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // For each other point, multiply by (0 - x_j) for numerator
                    numerator = numerator.multiply(BigInteger.ZERO.subtract(points.get(j).x));
                    // And (x_i - x_j) for denominator
                    denominator = denominator.multiply(points.get(i).x.subtract(points.get(j).x));
                }
            }
            // Lagrange coefficient: not a coffee order
            BigInteger coefficient = numerator.divide(denominator);
            // Add this term's contribution to the result
            result = result.add(points.get(i).y.multiply(coefficient));
        }
        return result;
    }
}

/*
   ASCII Art Easter Egg:

      (\__/)
      (•ㅅ•)   <--- This bunny knows your secret, but won't tell.
     / 　 づ
*/ 