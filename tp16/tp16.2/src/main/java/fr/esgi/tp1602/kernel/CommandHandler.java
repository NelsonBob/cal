package fr.esgi.tp1602.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
