package fr.esgi.tp1607.kernel;

public interface CommandBus {
    <C extends Command, R> R send(C command);
}
