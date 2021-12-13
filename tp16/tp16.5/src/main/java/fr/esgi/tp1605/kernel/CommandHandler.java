package fr.esgi.tp1605.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
