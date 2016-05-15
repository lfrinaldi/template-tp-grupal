package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;

public class ContainsCondition extends AbstractCondition<GameObject> {

    private String name;

    public ContainsCondition(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {
        return gameObject.find(name) != null;
    }
}
