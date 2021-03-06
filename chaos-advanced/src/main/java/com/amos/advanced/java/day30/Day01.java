package com.amos.advanced.java.day30;

import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: Hello, World
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day01 {

    public static void main(String[] args) {
        // Create a Scanner object to read input from stdin.
        Scanner scan = new Scanner(System.in);

        // Read a full line of input from stdin and save it to our variable, inputString.
        String inputString = scan.nextLine();

        // Close the scanner object, because we've finished reading
        // all of the input from stdin needed for this challenge.
        scan.close();

        // Print a string literal saying "Hello, World." to stdout.
        System.out.println("Hello, World.");

        // Write a line of code here that prints the contents of inputString to stdout.
        System.out.println(inputString);
    }

}
