package fr.esgi.tp1607.kernel;

public interface CommandBus {
    <R, C extends Command> R send(C command);
}
