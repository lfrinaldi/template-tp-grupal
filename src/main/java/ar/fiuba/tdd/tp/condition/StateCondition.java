package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;

import java.util.Map;

/**
 * Created by arissola on 11/05/2016.
 */
public class StateCondition extends AbstractCondition<GameObject> {

    private Map state;


    public StateCondition(Map state) {
        this.state = state;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {
        return state.equals(gameObject.getState());
    }\

}
