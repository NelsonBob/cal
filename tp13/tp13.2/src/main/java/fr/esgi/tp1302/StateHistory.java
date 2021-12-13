package fr.esgi.tp1302;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class StateHistory {

    private final List<State> history;

    private StateHistory(List<State> history) {
        this.history = history;
    }

    public static StateHistory create(State state) {
        return new StateHistory(List.of(state));
    }

    public StateHistory append(State state) {
//        this.history.add(state);
//        return new StateHistory(this.history);
        List<State> newSates = new ArrayList<>(history);
        newSates.add(state);
        return new StateHistory(newSates);
    }

    public List<State> getStates() {
        return Collections.unmodifiableList(history);
    }
}
