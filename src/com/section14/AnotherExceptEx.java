package com.section14;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AnotherExceptEx {

    // The stack trace can be printed to the standard error by calling the public void printStackTrace() method of an exception.
    // Java Call Stacks and Machine Call Stacks. The performance tools collect their data by recording events in
    // the life of each thread, along with the call stack at the time of the event. At any point in the
    // execution of any application, the call stack represents where the program is in its execution, and how it got there

    public static void main(String []args){
        try{
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }

    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("no suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }


    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer ");
        while(true){
            try {
                return s.nextInt();

            } catch(InputMismatchException e) {
                // go around again...read past the end of the line in the input first
                s.nextLine();
                System.out.println("Enter a number using only the digits 0 to 9 ");
            }
        }
    }
}
