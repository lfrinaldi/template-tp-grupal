package ar.fiuba.tdd.tp.game;

import java.util.HashMap;
import java.util.Map;

public abstract class GameObject {

    protected String name;
    protected Map<String, Object> attributes = new HashMap<>();

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
