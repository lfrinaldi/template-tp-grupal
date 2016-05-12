package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.condition.StateCondition;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Adrián on 5/11/2016.
 */
public class StateConditionTest {

    private StateCondition doorIsOpenSpecification;

    private GameObject myDoor;

    @Before
    public void setup() {

    }

    @Test
    public void isSatisfiedBySuccessfullTest() {

        doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("id", "0");
            put("name", "door");
            put("open", "true");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("name", "door");
            put("open", "true");
        }});


        Assert.assertTrue(doorIsOpenSpecification.isSatisfiedBy(myDoor));

    }
}
