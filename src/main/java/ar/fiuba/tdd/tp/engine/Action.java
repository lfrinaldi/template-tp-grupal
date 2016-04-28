package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.Box;
import ar.fiuba.tdd.tp.game.object.Disk;
import ar.fiuba.tdd.tp.game.object.Key;
import ar.fiuba.tdd.tp.game.object.Stick;

public interface Action {
    String getElementName();

/*
    String execute(Useable useable);
*/

    String execute(Key key);

    String execute(Box box);

    String execute(Disk disk);

    String execute(Stick stick);

    void setElementName(String word);


/*    String execute(Antipoison antipoison);

    String execute(Chest chest);

    String execute(Col col);

    String execute(Door door);

    String execute(Sheep sheep);

    String execute(Stack stack);

    String execute(Thief thief);

    String execute(Treasure treasure);

    String execute(Cupboard cupboard);

    String execute(Wolf wolf);

    String execute(Poison poison);*/


}
