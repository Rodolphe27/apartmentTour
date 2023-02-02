package apartmentTour.rooms;

import java.util.Scanner;

public class Kitchen extends Room {
    private boolean stove;

    public Kitchen(Scanner scanner) {
        super("Kitchen", scanner, 4);
        this.stove = false;
    }

    private void switchStove() {
        this.stove = !stove;
    }

    public boolean isStoveOn() {
        return stove;
    }

    @Override
    public void checkRoomState() {
        super.checkRoomState();
        if (isStoveOn()) {
            System.out.println("Warning: The stove in " + getName() + " is still switched on.");
        }
    }

    @Override
    protected void offerOptionsToUser() {
        super.offerOptionsToUser();
        System.out.println("4) Switch stove");
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
                switchStove();
                break;
            default:
                printInvalidOptionSelected();
        }

        interactWithUser();
    }
}
