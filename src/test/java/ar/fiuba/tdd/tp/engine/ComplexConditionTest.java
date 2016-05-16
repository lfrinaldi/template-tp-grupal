package ar.fiuba.tdd.tp.engine;

public class ComplexConditionTest {

    /*@Test
    public void isSatisfiedBy() {
        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});
        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {{
            put("colour", "red");
        }});
        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {{
            put("size", "big");
        }});
        GameObject myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "door");
            put("open", "true");
            put("colour", "red");
            put("size", "big");
        }});
        List<AbstractCondition> specs = new ArrayList<AbstractCondition>();
        specs.add(doorIsOpenSpecification);
        specs.add(doorIsRedSpecification);
        specs.add(doorIsBigSpecification);
        ComplexCondition redBigDoorIsOpenSpecification = new ComplexCondition(specs);
        Assert.assertTrue(redBigDoorIsOpenSpecification.isSatisfiedBy(myDoor));
    }


    @Test
    public void isNotSatisfiedBy() {
        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});
        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {{
            put("colour", "blue");
        }});
        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {{
            put("size", "big");
        }});
        GameObject myDoor = new GameObject("");
        myDoor.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "door");
            put("open", "true");
            put("colour", "red");
            put("size", "big");
        }});
        List<AbstractCondition> specs = new ArrayList<AbstractCondition>();
        specs.add(doorIsOpenSpecification);
        specs.add(doorIsRedSpecification);
        specs.add(doorIsBigSpecification);
        ComplexCondition redBigDoorIsOpenSpecification = new ComplexCondition(specs);
        Assert.assertTrue(!redBigDoorIsOpenSpecification.isSatisfiedBy(myDoor));
    }

    public void playerCanOpenSpecification() {
        GameObject door = new GameObject("");
        door.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "puerta");
            put("key", "gold key");
            put("colour", "red");
            put("size", "big");
        }});
        GameObject key = new GameObject("");
        key.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "key");
            put("key", "gold key");
        }});
        GameObject player = new GameObject("");
        player.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "player");
            put("lla", "true");
            put("colour", "red");
            put("size", "big");
        }});
        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributesMap().get("key"));
        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));
        player.getChildrenMap().put(key.getName(), key);
        Assert.assertTrue(playerCanOpenDoor.isSatisfiedBy(player));
    }


    public void playerCanNotOpenSpecification() {
        GameObject incorrectKey = new GameObject("");
        incorrectKey.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "key");
            put("key", "incorrect key");
        }});
        GameObject player = new GameObject("");
        player.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "player");
            put("lla", "true");
            put("colour", "red");
            put("size", "big");
        }});
        GameObject door = new GameObject("");
        door.getAttributesMap().putAll(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "puerta");
            put("key", "gold key");
            put("colour", "red");
            put("size", "big");
        }});
        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributesMap().get("key"));
        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));
        player.getChildrenMap().put(incorrectKey.getName(), incorrectKey);
        Assert.assertTrue(playerCanOpenDoor.isSatisfiedBy(player));
    }

*/
}
