package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

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
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
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
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
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
        key.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "gold key");
                put("key", "gold key");
            }
        });
        GameObject player = new GameObject("");
        player.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "player");
                put("lla", "true");
                put("colour", "red");
                put("size", "big");
            }
        });
        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributesMap().get("key"));
        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));
        player.getChildrenMap().put(key.getName(), key);
        Assert.assertTrue(playerCanOpenDoor.isSatisfiedBy(player));
    }

    @Test
    public void playerCanNotOpenSpecification() {
        GameObject incorrectKey = new GameObject("key");
        incorrectKey.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "key");
                put("key", "incorrect key");
            }
        });
        GameObject player = new GameObject("");
        player.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "player");
                put("lla", "true");
                put("colour", "red");
                put("size", "big");
            }
        });
        GameObject door = this.buildDoor();
        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributesMap().get("key"));
        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));
        player.getChildrenMap().put(incorrectKey.getName(), incorrectKey);
        Assert.assertTrue(!playerCanOpenDoor.isSatisfiedBy(player));
    }


    private GameObject buildDoor() {
        GameObject door = new GameObject("");
        door.getAttributesMap().putAll(new HashMap<String, String>() {
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
