package fr.esgi.tp1607.kernel;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}
