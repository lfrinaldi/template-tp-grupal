package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

/**
 * Created by leandro on 10/05/16.
 */
public class ComplexAction extends Action {

    private List<Action> steps;
    private List<Result> resultList;

    public List<Action> getSteps() {
        return steps;
    }

    public void setSteps(List<Action> steps) {
        this.steps = steps;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String execute(List<GameObject> objects) {
        return null;
    }
}
