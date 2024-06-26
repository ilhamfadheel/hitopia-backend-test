package org.ilhamfadheel;

import java.util.Scanner;

public class HighestPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.print("s: ");
            String inputNumber = scanner.nextLine();

            System.out.print("k: ");
            int k = scanner.nextInt();
            scanner.nextLine();

            char[] numberArray = inputNumber.toCharArray();
            boolean isOddLength = numberArray.length % 2 != 0;

            if (k < 0) {
                System.out.println("-1");
            } else {
                Result result = highestPalindrome(numberArray, k, 0, isOddLength);
                numberArray = result.numberArray;
                k = result.k;

                if (k < 0) {
                    System.out.println("-1");
                } else {
                    if (k > 0 && isOddLength) {
                        numberArray[numberArray.length / 2] = '9';
                    }
                    System.out.println(new String(numberArray));
                }
            }

            System.out.println();
    }

    private static Result highestPalindrome(char[] numArray, int k, int pos, boolean isOddLength) {
        if (k < 0) {
            return new Result(numArray, k);
        }

        int leftIndex = (numArray.length / 2) - pos - 1;
        int rightIndex = isOddLength ? (numArray.length / 2) + pos + 1 : (numArray.length / 2) + pos;

        if (leftIndex >= 0) {
            char leftChar = numArray[leftIndex];
            char rightChar = numArray[rightIndex];

            if (leftChar != rightChar) {
                char maxChar = (char) Math.max(leftChar, rightChar);
                numArray[leftIndex] = maxChar;
                numArray[rightIndex] = maxChar;
                k--;
            }

//             Recursive call
            Result result = highestPalindrome(numArray, k, pos + 1, isOddLength);
            numArray = result.numberArray;
            k = result.k;

            if (k > 1 && numArray[leftIndex] != '9') {
                numArray[leftIndex] = '9';
                numArray[rightIndex] = '9';
                k -= 2;
            }
        }

        return new Result(numArray, k);
    }

    private static class Result {
        char[] numberArray;
        int k;

        Result(char[] numberArray, int k) {
            this.numberArray = numberArray;
            this.k = k;
        }
    }
}
