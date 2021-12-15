package fr.esgi.tp1607.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
