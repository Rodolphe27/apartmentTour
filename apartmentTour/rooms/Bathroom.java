package apartmentTour.rooms;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Bathroom extends Room {
    private boolean shower;
    private Instant showerTurnedOnAt;

    public Bathroom(Scanner scanner) {
        super("Bathroom", scanner, 4);
        this.shower = false;
        this.showerTurnedOnAt = null;
    }

    @Override
    protected void offerOptionsToUser() {
        super.offerOptionsToUser();
        System.out.println("4) Switch shower");
    }

    @Override
    protected void executeAction(int actionId) {
        switch(actionId) {
            case 1:
                switchLight();
                printLightingStatus();
                break;
            case 2:
                leave();
                return;
            case 3:
                switchRoom();
                break;
            case 4:
                switchShower();
                break;
            default:
                printInvalidOptionSelected();
        }

        interactWithUser();
    }

    @Override
    public void checkRoomState() {
        super.checkRoomState();
        if (isShowerOn()) {
            System.out.println("Warning: The shower in " + getName() + " is still switched on.");
        }
    }

    private void switchShower() {
        this.shower = !shower;
        if (shower) {
            showerTurnedOnAt = Instant.now();
        } else {
            Instant showerTurnedOffAt = Instant.now();
            long timeElapsed = Duration.between(showerTurnedOnAt, showerTurnedOffAt).toMillis();
            double consumedWater = timeElapsed / 5;

            showerTurnedOnAt = null;
            System.out.println(String.format("Consumed %f ml of water.", consumedWater));
        }
    }

    public boolean isShowerOn() {
        return shower;
    }
}
