/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primary;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author ThinkRedstone
 */
public class Fraction {

    /**
     * Breaks fraction into numerator and denominator and constructs
     * PrimeCaculator with both
     *
     * @param fraction
     * @throws java.lang.Exception
     */
    public Fraction(String fraction) throws Exception {
        this.fraction = fraction;
        Scanner s = new Scanner(this.fraction);
        s.useDelimiter("/\\s*");
        try {
            numerator = new PrimeCaculator(s.nextInt());
            denominator = new PrimeCaculator(s.nextInt());
        } catch (InputMismatchException e) {
            System.err.println("Only natrual numbers");
            System.exit(5);
            throw new Exception("");

        } catch (NoSuchElementException e) {
            System.err.println("Input doesn't obey the template");
            System.exit(5);
            throw new Exception("");
        }
    }

    private final String fraction;
    private final PrimeCaculator numerator;
    private final PrimeCaculator denominator;

    /**
     *
     * @return minFraction
     */
    public String minimizeFraction() {
        int logNum;
        int[] arrNum = new int[numerator.getNumber()];
        int[] arrDen = new int[denominator.getNumber()];
        if (numerator.getNumber() < denominator.getNumber()) {
            do {
                logNum = numerator.getNumber();
                System.out.println("working... Current Fraction:" + numerator.getNumber() + "/" + denominator.getNumber());
                arrNum = numerator.primaryFactors();
                for (int i = 0; i < arrNum.length; i++) {
                    if (arrNum[i] != 0) {
                        if (denominator.getNumber() % arrNum[i] == 0) {
                            numerator.setNumber(numerator.getNumber() / arrNum[i]);
                            denominator.setNumber(denominator.getNumber() / arrNum[i]);
                        }
                    }

                }

            } while (logNum != numerator.getNumber());

        } else {
            do {
                logNum = numerator.getNumber();
                System.out.println("Working... Current Fraction:" + numerator.getNumber() + "/" + denominator.getNumber());
                arrDen = denominator.primaryFactors();
                for (int i = 0; i < arrDen.length; i++) {
                    if (arrDen[i] != 0) {
                        if (numerator.getNumber() % arrDen[i] == 0) {
                            numerator.setNumber(numerator.getNumber() / arrDen[i]);
                            denominator.setNumber(denominator.getNumber() / arrDen[i]);
                        }
                    }

                }

            } while (logNum != numerator.getNumber());
        }
        String minFraction = numerator.getNumber() + "/" + denominator.getNumber();
        return minFraction;
    }
}
