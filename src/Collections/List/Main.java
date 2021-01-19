package Collections.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int numRows = 8;
    private static int setsPerRow = 12;

    public static void main(String[] args){

        Theatre theatre = new Theatre("Olympian", numRows, setsPerRow);

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }else{
            System.out.println("Seat D12 already reserved!");
        }

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }else{
            System.out.println("Seat D12 already reserved!");
        }

        if(theatre.reserveSeat("B13")){
            System.out.println("Please pay for B13");
        }else{
            System.out.println("Seat B13 already reserved!");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list){
        int countSeatsPerRow = 0;
        System.out.println();
        for(Theatre.Seat seat : list){
            countSeatsPerRow++;
            System.out.print("   " + seat.getSeatNumber() + " $" + seat.getPrice());
            if(countSeatsPerRow % setsPerRow == 0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("===================================================================");
    }

}
