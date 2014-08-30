/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primary;

/**
 *
 * @author ThinkRedstone
 */
public class PrimeCaculator {

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public PrimeCaculator(int number) {
        this.number = number;
        if (number < 0) {
            System.err.println("Only natrual numbers");
            System.exit(5);

        }
    }

    private int number;

    /**
     *
     * @param array
     */
    private static int[] fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        return arr;
    }

    /**
     * @return prime numbers up to number in an array filled with 0
     */
    private int[] primesUpToX(int lim) {
        int[] arr = new int[lim];
        arr = fillArr(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] % arr[i] == 0) {
                        arr[j] = 0;
                    }
                }
            }
        }
        return arr;

    }

    /**
     *
     * @return array
     */
    public int[] primaryFactors() {
        int[] arr = new int[this.number];
        arr = primesUpToX(this.number);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (number % arr[i] != 0) {
                    arr[i] = 0;
                }
            }

        }
        return arr;
    }
}
