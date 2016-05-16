package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;

/**
 * Created by leandro on 15/05/16.
 */
public abstract class GameCondition<T> extends AbstractCondition<T> {
    protected Game game;
    protected Parameter parameter;

    public GameCondition(Game game, Parameter parameter) {
        this.game = game;
        this.parameter = parameter;
    }

    public abstract boolean isSatisfiedBy(T elementT);
}
