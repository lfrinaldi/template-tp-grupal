package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

/**
 * Abrir Puerta
 * El jugador está en una habitación que contiene una llave y una puerta.
 * Gana al atravesar la puerta y pasar a la siguiente habitación.
 */
public class AbrirPuerta extends Game {

    private ComplexObject room = new ComplexObject();
    private ComplexObject character = new ComplexObject();

    public AbrirPuerta() {

        room.setName("room");
        GameObject door = new ComplexObject();
        door.setName("door");
        room.addObject(door);
        GameObject key = new ComplexObject();
        key.setName("key");
        room.addObject(key);
    }

    @Override
    public String receiveMessage(String input) {

        final String lookAroundInput = "look around";
        final String openInput = "open ";
        final String pickInput = "pick ";

        String message = null;

        if (input.startsWith(lookAroundInput)) {
            message = lookAround(null);
        } else if (input.startsWith(openInput)) {
            String name = input.substring(openInput.length(), input.length());
            message = open(name);
        } else if (input.startsWith(pickInput)) {
            String name = input.substring(pickInput.length(), input.length());
            message = pick(name);
        }

        return message;

    }

    public String lookAround(String name) {

        try {

            List<GameObject> objects = room.getObjects();
            StringBuilder message = new StringBuilder("There’s a ");

            for (GameObject gameObject : objects) {
                message.append(gameObject.getName());
                message.append(" and ");
            }

            message = new StringBuilder(message.toString().substring(0, message.toString().length() - 4));
            message.append(String.format("in the %s.", room.getName()));

            return message.toString();

        } catch (Exception e) {
            return error(e);
        }

    }

    public String pick(String name) {

        try {

            ComplexObject key = (ComplexObject) room.getObject(name);
            boolean hasKey = character.hasElement("key");

            if (hasKey) {
                return "You already has the key";
            } else {
                character.getObjects().add(key);
                return "There you go!";
            }

        } catch (Exception e) {
            return error(e);
        }
    }

    public String open(String name) {

        try {

            String message;

            if (checkEndGame()) {
                message = String.format("You enter %s. You won the game!", room.getName());
            } else {
                message = String.format("Ey! Where do you go?! %s %s ", room.getName(), " is locked");
            }

            return message;

        } catch (Exception e) {
            return error(e);
        }
    }

    @Override
    public boolean checkEndGame() {
        return character.hasElement("key");
    }
}
