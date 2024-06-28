package DSA;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Format a string of numbers to display a currency - example" "1234.678" to "1,234.68".
 *
 * ***************************** SOLUTION **********************************************
 *
 * Formatting a string of numbers to display as currency in Java
 * can be achieved using the NumberFormat class from the java.text package.
 *
 * Parsing the Input String:-
 *
 * Convert the input string to a double using Double.parseDouble.
 *
 * Formatting the Number:-
 *
 * Use NumberFormat.getCurrencyInstance() to get a NumberFormat instance for the default locale.
 * Format the number using currencyFormatter.format(number).
 *
 * Removing the Currency Symbol:-
 *
 * The NumberFormat.getCurrencyInstance() method includes the currency symbol in the formatted string.
 * To get the formatted number without the currency symbol, you can remove it using a regular expression.
 * The regular expression "^[^\\d\\-]" matches any character at the beginning of the string that
 * is not a digit or a minus sign and removes it.
 * then remove the currency Symbol by using regex "[\\$€£¥₹]"
 */
public class CurrencyFormatter {

    public static String formatCurrency(String currency){
        double num = Double.parseDouble(currency);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        String formattedCurrency = currencyFormatter.format(num);
        // Removing the currency symbol
        formattedCurrency = formattedCurrency.replaceAll("^[^\\d\\-]","");
        String currencySymbols = "[\\\\$€£¥₹]";
        formattedCurrency = formattedCurrency.replaceAll(currencySymbols,"");
        return formattedCurrency;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String currency = sc.nextLine();
            System.out.println(formatCurrency(currency));
        }
    }
}
