package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

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
//    private ComplexObject character;
//    private Room torre1;
//    private Room torre2;
//    private Room torre3;
//    private Disk disk1;
//    private Disk disk2;
//    private Disk disk3;

    public TorresHanoi() {
//        character = new ComplexObject("character");
//        disk1 = new Disk("Disco1", 10);
//        disk2 = new Disk("Disco2", 20);
//        disk3 = new Disk("Disco3", 30);
//        torre1 = new Room("Torre1", new ArrayList<>(Arrays.asList(disk1, disk2, disk3)));
//        torre2 = new Room("Torre2", new ArrayList<>(Arrays.asList()));
//        torre3 = new Room("Torre3", new ArrayList<>(Arrays.asList()));
//        addRoom(torre1);
//        addRoom(torre2);
//        addRoom(torre3);
    }

//    private boolean checkWinRule() {
//        // Gana el juego si el todos los discos estan en la Torre 3
//        return torre3.getObjects().contains(disk1) && torre3.getObjects().contains(disk2) && torre3.getObjects().contains(disk3);
//    }

    @Override
    protected boolean checkWinRule() {
        // Gana el juego si el Character tiene el stick
        return false;
    }

    @Override
    protected boolean checkLoseRule() {
        return false;
    }
}
