package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

/**
 * Torres de Hanoi
 * El juego empieza con 3 pilares donde donde el primero tiene un pila de discos, donde el disco de mas abajo de la
 * pila es de mayor tamaño y siendo los otros consecutivamente de menor tamaño.
 * El objetivo del juego es mover la pila de discos a otro pilar, cumpliendo las siguientes reglas:
 * + Solo se puede mover un disco por vez.
 * + Cada movimiento consiste en tomar el disco superior de una pila y en la sima de otra pila. Es decir solo se puede
 * mover un disco que está en la sima de la pila.
 * + Ningun disco se puede apilar sobre otro más pequeño.
 */
public class TorresHanoi extends Game {

    private static final int maxStacks = 3;
    private static final int maxDisks = 2;
    private ComplexObject board = new ComplexObject();

    public TorresHanoi() {

        ComplexObject stack;

        for (int index = 1; index <= maxStacks; index++) {
            stack = new ComplexObject();
            stack.setName("stack " + Integer.toString(index));
            board.addObject(stack);
        }

        stack = (ComplexObject) board.getObject("stack 1");

        for (int index = 1; index <= maxDisks; index++) {
            GameObject disk = new ComplexObject();
            disk.setName("disk " + Integer.toString(index));
            disk.getAttributes().put("size", index);
            stack.addObject(disk);
        }
    }

    public String lookAround(String name) {

        try {

            ComplexObject stack = (ComplexObject) board.getObject(name);
            List<GameObject> objects = stack.getObjects();
            int objectsSize = objects.size();
            boolean full = (objectsSize == maxDisks);
            boolean empty = objects.isEmpty();

            if (full) {
                return "You can check top.";
            } else if (empty) {
                return "You can move top.";
            } else {
                return "You can check top/move top.";
            }

        } catch (Exception e) {
            return error(e);
        }
    }

    public String help(String name) {

        try {

            ComplexObject stack = (ComplexObject) board.getObject(name);
            List<GameObject> objects = stack.getObjects();
            boolean objectsEmpty = objects.isEmpty();
            String message;

            if (objectsEmpty) {
                message = name + " is empty";
            } else {
                ComplexObject topDisk = (ComplexObject) objects.get(objects.size() - 1);
                message = "Size of top from " + name + " is " + topDisk.getAttributes().get("size") + ".";
            }

            return message;

        } catch (Exception e) {
            return error(e);
        }
    }

    private boolean invalidMovement(ComplexObject topDiskFrom, ComplexObject stackTo) {

        List<GameObject> objectsTo = stackTo.getObjects();
        boolean objectsToEmpty = objectsTo.isEmpty();

        if (!objectsToEmpty) {

            ComplexObject topDiskTo = (ComplexObject) objectsTo.get(objectsTo.size() - 1);

            if ((Integer) topDiskTo.getAttributes().get("size") > (Integer) topDiskFrom.getAttributes().get("size")) {
                return true;
            }
        }

        return false;
    }

    public String move(String what, String from, String to) {

        try {

            ComplexObject stackFrom = (ComplexObject) board.getObject(from);
            List<GameObject> objectsFrom = stackFrom.getObjects();
            boolean objectsFromEmpty = objectsFrom.isEmpty();

            if (objectsFromEmpty) {
                return from + " is empty";
            } else {

                return tryToMove(to, objectsFrom);
            }

        } catch (Exception e) {
            return error(e);
        }
    }

    private String tryToMove(String to, List<GameObject> objectsFrom) {

        ComplexObject topDiskFrom = (ComplexObject) objectsFrom.get(objectsFrom.size() - 1);
        ComplexObject stackTo = (ComplexObject) board.getObject(to);

        if (invalidMovement(topDiskFrom, stackTo)) {
            return "invalid movement";
        } else {

            List<GameObject> objectsTo = stackTo.getObjects();
            objectsTo.add(topDiskFrom);
            objectsFrom.remove(objectsFrom.size() - 1);

            if (checkEndGame()) {
                return "moved! you won!";
            } else {
                return "moved!";
            }
        }
    }

    @Override
    public String receiveMessage(String input) {

        final String lookAroundInput = "What can I do with ";
        final String helpInput = "check top ";
        final String moveInput = "move top ";

        String message = null;

        if (input.startsWith(lookAroundInput)) {
            String name = input.substring(lookAroundInput.length(), input.length() - 1);
            message = lookAround(name);
        } else if (input.startsWith(helpInput)) {
            String name = input.substring(helpInput.length());
            message = help(name);
        } else if (input.startsWith(moveInput)) {
            String[] tokens = input.split(" ");
            String from = tokens[2] + " " + tokens[3];
            String to = tokens[4] + " " + tokens[5];
            message = move(null, from, to);
        }

        return message;
    }

    @Override
    public boolean checkEndGame() {

        ComplexObject stack = (ComplexObject) board.getObject("stack 3");
        List<GameObject> objects = stack.getObjects();
        int objectsSize = objects.size();

        return objectsSize == maxDisks;
    }
}
