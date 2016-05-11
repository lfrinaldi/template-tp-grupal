package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public abstract class AbstractCondition<T> implements Condition<T> {

    public abstract boolean isSatisfiedBy(T t);

    public Condition<T> and(final Condition<T> condition) {
        return new AndCondition<T>(this, condition);
    }

    public Condition<T> or(final Condition<T> condition) {
        return new OrCondition<T>(this, condition);
    }

    public Condition<T> not(final Condition<T> condition) {
        return new NotCondition<T>(condition);
    }
}