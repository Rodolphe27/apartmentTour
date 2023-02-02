package apartmentTour;

import apartmentTour.rooms.Bathroom;
import apartmentTour.rooms.Kitchen;
import apartmentTour.rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Room hallway = new Room("Hallway", scanner);
        Room bedroom = new Room("Bedroom", scanner);
        Room kitchen = new Kitchen(scanner);

        List<Room> initialRooms = new ArrayList<>(List.of(hallway, bedroom, kitchen));

        Apartment apartment = new Apartment(hallway, initialRooms);

        Room workroom = new Room("Workroom", scanner);
        Room bathroom = new Bathroom(scanner);

        apartment.addNewRoom(workroom);
        apartment.addNewRoom(bathroom);

        apartment.neighbourRooms(hallway, bedroom);
        apartment.neighbourRooms(hallway, kitchen);
        apartment.neighbourRooms(hallway, workroom);
        apartment.neighbourRooms(hallway, bathroom);
        apartment.neighbourRooms(bedroom, workroom);

        Room hallway2 = new Room("Other Hallway", scanner);
        apartment.neighbourRooms(bedroom, hallway2);

        apartment.enter();
    }
}
