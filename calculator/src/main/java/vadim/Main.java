package vadim;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
//    public static double calculate(String input){
//        String strA = "";
//        String strSign = "";
//        String strB = "";
//
//        input = input.replaceAll("[^-+*/\\d]","");
//
//        Pattern patternNumber = Pattern.compile("-*\\d+");
//        Matcher matcherNumber = patternNumber.matcher(input);
//        boolean isFirst = true;
//        while (matcherNumber.find()) {
//            if(isFirst){
//                strA = input.substring(matcherNumber.start(), matcherNumber.end());
//                isFirst = false;
//            }
//            else{
//                strB = input.substring(matcherNumber.start(), matcherNumber.end());
//                break;
//            }
//        }
//
//        double a = Double.parseDouble(strA);
//
//        Pattern patternSign = Pattern.compile("[-+*/]");
//        Matcher matcherSign = patternSign.matcher(input);
//        boolean bool = a >= 0;
//        while (matcherSign.find()) {
//            if(bool) {
//                strSign = input.substring(matcherSign.start(), matcherSign.end());
//                break;
//            }
//            else bool = true;
//        }
//
//        if(strSign.equals("-")) strB = strB.substring(1);
//        double b = Double.parseDouble(strB);
//
//
//        return switch (strSign) {
//            case "+" -> a + b;
//            case "-" -> a - b;
//            case "*" -> a * b;
//            case "/" -> a / b;
//            default -> 1;
//        };
//
//    }

    public static double calculate(String first, String sign, String second) throws Exception {
        double res = 0;
        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);

        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("Can't find sign");
        };
    }

    public static String calcString(String first, String sign, String second) throws Exception {
        sign = sign.replaceAll("[^-+*/]","");
        if(sign.length() > 1) {
            Pattern patternSign = Pattern.compile("[-+*/]");
            Matcher matcherSign = patternSign.matcher(sign);
            if (matcherSign.find()) {
                    sign = sign.substring(matcherSign.start(), matcherSign.end());
            }
        }

        first = first.replaceAll("[^-\\deE]","");
        second = second.replaceAll("[^-\\deE]","");

        return String.valueOf(calculate(first, sign, second));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try{
                String first = scanner.nextLine();
                String sign = scanner.nextLine();
                String second = scanner.nextLine();
                System.out.print(calcString(first, sign, second));
                System.out.println("");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}