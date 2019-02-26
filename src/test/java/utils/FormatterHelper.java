package utils;

public class FormatterHelper {
    public static Double amountToDouble(String amount){
        String removeCurrency = amount.replace("kr","");
        String removedBlanks = removeCurrency.replace(" ","");
        return Double.parseDouble(removedBlanks);
    }
}
