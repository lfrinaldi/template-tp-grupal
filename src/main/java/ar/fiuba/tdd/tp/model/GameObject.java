package ar.fiuba.tdd.tp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameObject {

    private String name;
    private GameObject parent = null;
    private Map<String, GameObject> childrenMap = new HashMap<>();
    private Map<String, String> attributesMap = new HashMap<>();

    public GameObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GameObject getParent() {
        return parent;
    }

    public void setParent(GameObject parent) {
        this.parent = parent;
    }

    public Map<String, GameObject> getChildrenMap() {
        return childrenMap;
    }

    public List<GameObject> getChildrenList() {
        return new ArrayList<>(childrenMap.values());
    }

    public void addChild(GameObject gameObject) {
        String name = gameObject.getName();
        gameObject.setParent(this);
        childrenMap.put(name, gameObject);
    }

    public GameObject getChild(String name) {
        return childrenMap.get(name);
    }

    public GameObject removeChild(String name) {
        GameObject gameObject = childrenMap.remove(name);
        gameObject.setParent(null);
        return gameObject;
    }

    public Map<String, String> getAttributesMap() {
        return attributesMap;
    }

    public List<String> getAttributesList() {
        return (List) attributesMap.values();
    }

    public void addAtribute(String name, String value) {
        attributesMap.put(name, value);
    }

    public String getAttribute(String name) {
        return attributesMap.get(name);
    }

    public boolean changeAtribute(String name, String value) {

        if (attributesMap.containsKey(name)) {
            attributesMap.replace(name, value);
            return true;
        }

        return false;
    }

    public String removeAttribute(String name) {
        return attributesMap.remove(name);
    }

    public List<GameObject> getSiblingsList() {

        List<GameObject> siblingsList = new ArrayList<>();
        List<GameObject> parentChildren = parent.getChildrenList();

        for (GameObject sibling : parentChildren) {
            if (!sibling.getName().equals(name)) {
                siblingsList.add(sibling);
            }
        }

        return siblingsList;
    }

    public boolean moveChild(String childName, GameObject target) {

        GameObject child = removeChild(childName);

        if (child != null) {
            target.addChild(child);
            return true;
        }

        return false;
    }

    public GameObject find(String name) {

        if (this.name.equals(name)) {
            return this;
        } else {

            for (GameObject gameObject : getChildrenList()) {

                String gameObjectName = gameObject.getName();

                if (gameObjectName.equals(name)) {
                    return gameObject;
                } else {

                    GameObject found = gameObject.find(name);

                    if (found != null) {
                        return found;
                    }
                }
            }
        }

        return null;
    }
}
