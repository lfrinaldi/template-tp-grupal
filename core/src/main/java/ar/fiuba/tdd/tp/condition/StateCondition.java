package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.condition.core.AbstractCondition;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.Map;

public class StateCondition extends AbstractCondition<GameObject> {

    private Map<String, String> state;


    public StateCondition(Map state) {
        this.state = state;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {

        Map<String, String> map = gameObject.getAttributes();
        boolean isSatisfied = true;

        for (String key : state.keySet()) {
            if ((map.containsKey(key) && (!state.get(key).equals(map.get(key))))
                    || !map.containsKey(key)) {
                isSatisfied = false;
            }
        }

        return isSatisfied;
    }

}
