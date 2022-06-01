import java.util.Map;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        try {
        System.out.println("Введите арабские или римские числа");
        Scanner scanner = new Scanner(System.in);
        String mainInput = scanner.nextLine();
        String[] separateInputs = mainInput.split(" ");

        String a = separateInputs[0];
        String c = separateInputs[1];
        String b = separateInputs[2];

        int number1 = 0;
        int number2 = 0;

        char operator = c.charAt(0);

        int e = fromRomanNumber(a);
        int f = fromRomanNumber(b);


        if ((a.equals("I") || a.equals("II") || a.equals("III") || a.equals("IV") || a.equals("V") || a.equals("VI")
                || a.equals("VII") || a.equals("VIII") || a.equals("IX") || a.equals("X"))) {
            number1 = e;
        }
        if (b.equals("I") || b.equals("II") || b.equals("III") || b.equals("IV") || b.equals("V") || b.equals("VI")
                || b.equals("VII") || b.equals("VIII") || b.equals("IX") || b.equals("X")) {
            number2 = f;
        }
        else if (a.equals("1") || a.equals("2") || a.equals("3") || a.equals("4") || a.equals("5") || a.equals("6")
                || a.equals("7") || a.equals("8") || a.equals("9") || a.equals("10")) {
            number1 = Integer.parseInt(a);
        }
        else if (b.equals("1") || b.equals("2") || b.equals("3") || b.equals("4") || b.equals("5") || b.equals("6")
                || b.equals("7") || b.equals("8") || b.equals("9") || b.equals("10")) {
            number2 = Integer.parseInt(b);
        } else {
            System.out.println("Недопустимые числа");
        }

        int d = myMethod(operator,number1,number2);
        System.out.println(d);

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Строка не является математической операцией");
        }
        catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }
    }

    static Map<Character, Integer> valueMap = Map.of('I', 1, 'V', 5, 'X', 10);

    static int fromRomanNumber(final String romanNumber) {
        int value = 0;
        int lastDigitValue = 0;
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            final char romanDigit = romanNumber.charAt(i);
            final int digitValue = valueMap.getOrDefault(romanDigit, 0);
            final boolean addMode = digitValue >= lastDigitValue;
            if (addMode) {
                value += digitValue;
                lastDigitValue = digitValue;
                }  else {
                value -= digitValue;
            }
        }
        return value;
    }

    static int myMethod (char operator, Integer number1, Integer number2) {
        int value = 0;
        if (operator == '+') {
            value = number1 + number2;
        }
        else if (operator == '-') {
            value = number1 - number2;
            }
        else if (operator == '*') {
            value = number1 * number2;
            }
        else if (operator == '/') {
            value = number1 / number2;
            } else {
            System.out.println("Неправильное арифметическое действие");
        }
        return value;
    }

}