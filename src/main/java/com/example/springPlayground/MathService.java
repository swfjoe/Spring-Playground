package com.example.springPlayground;

import java.util.List;

import static java.lang.Integer.parseInt;

public class MathService {


    public static String calculate(String operation, String x, String y) {
        switch (operation) {
            case "add": {
                int total;
                total = parseInt(x) + parseInt(y);
                return String.format("%s + %s = %s", x, y, total);
            }
            case "subtract": {
                int total;
                total = parseInt(x) - parseInt(y);
                return String.format("%s - %s = %s", x, y, total);
            }
            case "multiply": {
                int total;
                total = parseInt(x) * parseInt(y);
                return String.format("%s * %s = %s", x, y, total);
            }
            case "divide": {
                int total;
                total = parseInt(x) / parseInt(y);
                return String.format("%s / %s = %s", x, y, total);
            }
            default:
                return String.format("Operation is: %s, x is: %s, y is: %s", operation, x, y);
        }
    }
    public static String sum (List<String> n) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (String number : n) {
            sb.append(number).append(" + ");
            sum += parseInt(number);
        }
        sb.delete(sb.lastIndexOf("+") - 1, sb.length()).append(" = ").append(sum);
        return sb.toString();
    }

    public static String calculateVolume(String x, String y, String z) {
                int product;
                product = parseInt(x) * parseInt(y) * parseInt(z);
                return String.format("The volume of a %sx%sx%s rectangle is %s", x, y, z, product);
    }
}
