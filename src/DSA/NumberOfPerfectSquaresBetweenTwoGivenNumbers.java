package DSA;

import java.util.Scanner;

public class NumberOfPerfectSquaresBetweenTwoGivenNumbers {

    public static int countSquares(int a, int b){
        int result = 0;
        result = (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)))+1;
        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());
            System.out.println(countSquares(a,b));
        }
    }
}
