package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

@SuppressWarnings("CPD-START")
public class ComplexConditionTest {

    @Test
    public void isSatisfiedBy() {
        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
            }
        });
        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("colour", "red");
            }
        });
        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("size", "big");
            }
        });
        GameObject myDoor = new GameObject("");
        myDoor.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "door");
                put("open", "true");
                put("colour", "red");
                put("size", "big");
            }
        });
        boolean result = doorIsOpenSpecification.and(doorIsRedSpecification.and(doorIsBigSpecification)).isSatisfiedBy(myDoor);
        Assert.assertTrue(result);
    }


    @Test
    public void isNotSatisfiedBy() {
        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
            }
        });
        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("colour", "blue");
            }
        });
        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("size", "big");
            }
        });
        GameObject myDoor = new GameObject("");
        myDoor.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "door");
                put("open", "true");
                put("colour", "red");
                put("size", "big");
            }
        });

        boolean result = doorIsOpenSpecification.and(doorIsRedSpecification.and(doorIsBigSpecification)).isSatisfiedBy(myDoor);
        Assert.assertFalse(result);

    }


    @Test
    public void playerCanOpenSpecification() {
        GameObject door = this.buildDoor();
        GameObject key = new GameObject("gold key");
        key.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "gold key");
                put("key", "gold key");
            }
        });
        GameObject player = new GameObject("");
        player.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "player");
                put("lla", "true");
                put("colour", "red");
                put("size", "big");
            }
        });
        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributes().get("key"));
        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));

    }

    @Test
    public void playerCanNotOpenSpecification() {
        GameObject incorrectKey = new GameObject("key");
        incorrectKey.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "key");
                put("key", "incorrect key");
            }
        });
        GameObject player = new GameObject("");
        player.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "player");
                put("lla", "true");
                put("colour", "red");
                put("size", "big");
            }
        });
        GameObject door = this.buildDoor();
        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributes().get("key"));
        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));
        player.getChildren().add(incorrectKey);
        Assert.assertTrue(!playerCanOpenDoor.isSatisfiedBy(player));
    }


    private GameObject buildDoor() {
        GameObject door = new GameObject("");
        door.getAttributes().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "puerta");
                put("key", "gold key");
                put("colour", "red");
                put("size", "big");
            }
        });
        return door;
    }


}
