package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.*;

public interface Action {
    String getElementName();

/*
    String execute(Useable useable);
*/

    String execute(Key key);

    String execute(Box box);

    String execute(Disk disk);

    String execute(Stick stick);

    String execute(Door door);

    void setElementName(String word);




/*    String execute(Antipoison antipoison);

    String execute(Chest chest);

    String execute(Col col);



    String execute(Sheep sheep);

    String execute(Stack stack);

    String execute(Thief thief);

    String execute(Treasure treasure);

    String execute(Cupboard cupboard);

    String execute(Wolf wolf);

    String execute(Poison poison);*/


}
