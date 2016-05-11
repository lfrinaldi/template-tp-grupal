package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public class AndCondition<T> extends AbstractCondition<T> {

    private Condition<T> cond1;
    private Condition<T> cond2;

    /**
     * Create a new AND condition based on two other cond.
     *
     * @param cond1 Condition one.
     * @param cond2 Condition two.
     */
    public AndCondition(final Condition<T> cond1, final Condition<T> cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }

    public boolean isSatisfiedBy(final T elementT) {
        return cond1.isSatisfiedBy(elementT) && cond2.isSatisfiedBy(elementT);
    }
}
