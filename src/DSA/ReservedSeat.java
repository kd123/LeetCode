package DSA;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given N rows of seats in a movie theatre, each row with seats labelled A to K some seats are reserved.
 * A 3 person family want seats next to each other (seats across the aisle is not allowed),
 * return all available options.
 *
 * Reserved seat will be given like "1A 2B 40G".
 */
public class ReservedSeat {

    public static List<String> findAvailableSeats(int n, String reservedSeat){
        Set<String> reservedSet = new HashSet<>();
        String[] reservedArray = reservedSeat.split(" ");
        for(String s: reservedArray){
            reservedSet.add(s);
        }

        List<String> availableOption = new ArrayList<>();
        for(int row=1;row<=n;row++){
            String rowString = String.valueOf(row);
            for(char seat='A';seat<='K';seat++) {
                if (!reservedSet.contains(rowString+seat)){
                    if(!reservedSet.contains(rowString+(char)(seat+1))
                            && !reservedSet.contains(rowString+(char)(seat+2))
                        ) {
                        availableOption.add(rowString+seat);
                    }
                }
            }
        }
        return availableOption;
    }

    public static void main(String[] args){
        int N = 40;
        String reservedSeats = "1A 2B 40G";
        List<String> availableOptions = findAvailableSeats(N, reservedSeats);
        System.out.println("Available options for the family to sit together: " + availableOptions);

    }
}
