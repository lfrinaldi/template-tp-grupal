package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.object.Box;
import ar.fiuba.tdd.tp.game.object.Door;
import ar.fiuba.tdd.tp.game.object.Key;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Adrián on 4/27/2016.
 */
public class AbrirPuertaFactory {

    private static Room cretateRoomAbrirStandard() {
        Key key = new Key();
        key.setName("key");
        Room room2 = new Room("Room2", new ArrayList<>());
        Door door = new Door();
        door.setName("door");
        door.setKey(key);
        door.addNextRoom(room2);
        return new Room("Room1", new ArrayList<>(Arrays.asList(door)));
    }

    public static Room createRoomsAbrirPuertaUno() {
        Key key = new Key();
        key.setName("key");
        Room room = cretateRoomAbrirStandard();
        room.addObjects(new ArrayList<>(Arrays.asList(key)));
        return room;
    }

    public static Room createRoomsAbrirPuertaDos() {
        Box box = new Box();
        box.setName("box");
        Key key = new Key();
        key.setName("key");
        box.addObject(key);
        Room roomUno = cretateRoomAbrirStandard();
        roomUno.addObjects(Arrays.asList(box));
        return roomUno;
    }
}
