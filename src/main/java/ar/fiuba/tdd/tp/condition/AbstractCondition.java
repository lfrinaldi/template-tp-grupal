package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public abstract class AbstractCondition<T> implements Condition<T> {

    public abstract boolean isSatisfiedBy(T elementT);

    public Condition<T> and(final Condition<T> condition) {
        return new AndCondition<>(this, condition);
    }

    public Condition<T> or(final Condition<T> condition) {
        return new OrCondition<>(this, condition, (elem, elem2) -> elem || elem2);
    }

    public Condition<T> not(final Condition<T> condition) {
        return new NotCondition<>(condition);
    }
}