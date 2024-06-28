//package DSA;
//
//
///**
// * Write a program which takes JSON as input and gives prettified JSON.
// *
// */
//
//import java.util.Scanner;
//
//public class JsonPrettifier {
//
//    public static String prettifyJson(String jsonStr){
//        Object json = new JSONTokener(jsonStr).nextValue();
//        if(json instanceof JSONObject)
//            return ((JSONObject)json).toString(4);
//        else if(json instanceof JSONArray)
//            return ((JSONArray)json).toString(4);
//        else throw new IllegalArgumentException("Invalid JSON Input");
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter JSON string:");
//        String jsonString = scanner.nextLine();
//
//        try {
//            String prettyJson = prettifyJson(jsonString);
//            System.out.println("Prettified JSON:");
//            System.out.println(prettyJson);
//        } catch (Exception e) {
//            System.out.println("Error prettifying JSON: " + e.getMessage());
//        }
//    }
//}
