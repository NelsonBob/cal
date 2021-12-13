package fr.esgi.tp1604.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
