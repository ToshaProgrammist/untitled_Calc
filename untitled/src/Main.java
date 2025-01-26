import java.io.*;
import java.util.Scanner;

import Exception.*;
import Enum.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("HELLO GUYS");
        System.out.println("HELLO GUYS 2");
        System.out.println("HELLO GUYS 3");
        Scanner s = new Scanner(System.in);
        System.out.println("Введите пример согласно формату:\n" +
                "(римское число/арабское) (операнд) (римское число/арабское)\n" +
                "3 + 4 или V / I");
        String example = s.nextLine();
        System.out.println(calc(example));
    }

    public static String calc(String input) {
        String[] regex = input.split(" ");
        Processing.ProcessingString(regex);

        switch (regex[1]) {
            case "+": {
                if (regex[0].matches("\\D{0,}") && regex[2].matches("\\D{0,}")) {
                    Roman number1 = Roman.getCurrentString(regex[0]);
                    Roman number2 = Roman.getCurrentString(regex[2]);

                    int result = number1.getNumber() + number2.getNumber();
                    Roman result1 = Roman.getCurrentNumber(result);
                    return result1.toString();
                } else {
                    int result = Integer.parseInt(regex[0]) + Integer.parseInt(regex[2]);
                    return String.valueOf(result);
                }
            }
            case "-": {
                if (regex[0].matches("\\D{0,}") && regex[2].matches("\\D{0,}")) {
                    Roman number1 = Roman.getCurrentString(regex[0]);
                    Roman number2 = Roman.getCurrentString(regex[2]);

                    int result = number1.getNumber() - number2.getNumber();
                    try {
                        Roman result1 = Roman.getCurrentNumber(result);
                        return result1.toString();
                    } catch (NullPointerException e) {
                        System.err.println("Получено отрицательное число в ходе операции вычисления с использованием римских цифр");
                        break;
                    }


                } else {
                    int result = Integer.parseInt(regex[0]) - Integer.parseInt(regex[2]);
                    return String.valueOf(result);
                }
            }
            case "*": {
                if (regex[0].matches("\\D{0,}") && regex[2].matches("\\D{0,}")) {
                    Roman number1 = Roman.getCurrentString(regex[0]);
                    Roman number2 = Roman.getCurrentString(regex[2]);

                    int result = number1.getNumber() * number2.getNumber();
                    Roman result1 = Roman.getCurrentNumber(result);
                    return result1.toString();
                } else {
                    int result = Integer.parseInt(regex[0]) * Integer.parseInt(regex[2]);
                    return String.valueOf(result);
                }

            }
            case "/": {
                if (regex[0].matches("\\D{0,}") && regex[2].matches("\\D{0,}")) {
                    Roman number1 = Roman.getCurrentString(regex[0]);
                    Roman number2 = Roman.getCurrentString(regex[2]);

                    Double result = (number1.getNumber() / number2.getNumber()) * 1.0;
                    Roman result1 = Roman.getCurrentNumber((int) Math.floor(result));
                    return result1.toString();
                } else {
                    Double result = (Integer.parseInt(regex[0]) / Integer.parseInt(regex[2])) * 1.0;
                    return String.valueOf((int) Math.floor(result));
                }
            }
        }
        return "";
    }
}
