package fr.esgi.al.tps.tp2.event;

import java.util.function.Consumer;

public interface Subscriber<E extends Event> extends Consumer<E> {
}
