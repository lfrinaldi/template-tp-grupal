package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StateConditionTest {

    private GameObject myDoor;

    @Test
    public void isSatisfiedByBasicTest() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
            }
        });


        myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("name", "door");
                put("open", "true");
                put("colour", "red");
            }
        });

        Assert.assertTrue(doorIsOpenSpecification.isSatisfiedBy(myDoor));

    }

    @Test
    public void isNotSatisfiedByBasicTest() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
            }
        });


        myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("name", "door");
                put("open", "false");
                put("colour", "red");
            }
        });

        Assert.assertTrue(!doorIsOpenSpecification.isSatisfiedBy(myDoor));
        Assert.assertTrue(doorIsOpenSpecification.not(doorIsOpenSpecification).isSatisfiedBy(myDoor));

    }


    @Test
    public void isSatisfiedByTest() {

        StateCondition redDoorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
                put("colour", "red");
            }
        });


        myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("name", "door");
                put("open", "true");
                put("colour", "red");
            }
        });

        Assert.assertTrue(redDoorIsOpenSpecification.isSatisfiedBy(myDoor));

    }


    @Test
    public void isNotSatisfiedByTest() {

        StateCondition redDoorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
                put("colour", "red");
            }
        });


        myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("name", "door");
                put("open", "true");
                put("colour", "blue");
            }
        });

        Assert.assertTrue(!redDoorIsOpenSpecification.isSatisfiedBy(myDoor));

    }


    @Test
    public void isNotSatisfiedByLessAttributesTest() {

        StateCondition redBigDoorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {
            {
                put("open", "true");
                put("colour", "red");
                put("size", "big");
            }
        });

        myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("open", "true");
            }
        });

        Assert.assertTrue(!redBigDoorIsOpenSpecification.isSatisfiedBy(myDoor));

    }


    @Test
    public void isSatisfiedByAtomicSpecTest() {

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


        myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {
            {
                put("id", "0");
                put("nombre", "door");
                put("open", "true");
                put("colour", "red");
                put("size", "big");
            }
        });

        Assert.assertTrue(doorIsOpenSpecification.and(doorIsBigSpecification.and(doorIsRedSpecification)).isSatisfiedBy(myDoor));

    }


}
