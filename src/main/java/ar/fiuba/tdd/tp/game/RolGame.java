package ar.fiuba.tdd.tp.game;

/**
 * Created by leandro on 03/05/16.
 */
public abstract class RolGame extends Game {
    protected Player player;
    protected ComplexObject currentRoom;

    public ComplexObject getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ComplexObject getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(ComplexObject currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String lookAround() {
        StringBuffer message = new StringBuffer();
        message.append(getCurrentRoom().getName() + " has:");
        for (GameObject component : getCurrentRoom().getObjects()) {
            message.append(" A " + component.getName() + ".");
        }
        return message.toString();
    }

    public String pick(String elementToPick) {
        String response = "There is no such thing to pick.";
        boolean hasElem = currentRoom.hasElement(elementToPick);

        if (hasElem && player.canPick()) {
            player.addObject(currentRoom.getObject(elementToPick));
            response = "You picked " + elementToPick;
        } else if (hasElem) {
            response = "Can't carry anymore items.";
        }
        return response;
    }

    public String help() {
        return "Allowed Commands: open, look around, pick";
    }
}
