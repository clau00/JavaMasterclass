package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry, seat is taken!");
        }

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry, seat is taken!");
        }

        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        Collections.reverse(seatCopy);
        System.out.println("\n\tPrinting the reversed seatCopy: ");
        printList(seatCopy);
        System.out.println("\tPrinting the original theatre.seats:");
        printList(theatre.seats);

        Collections.shuffle(seatCopy);
        System.out.println("\n\tPrinting the shuffled seatCopy: ");
        printList(seatCopy);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("\n\tPrinting sorted seatCopy:");
        printList(seatCopy);

    }

    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===================================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        for(int i=0; i<list.size() -1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) >0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
