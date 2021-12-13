package fr.esgi.tp1406.application;

import fr.esgi.tp1406.kernel.EventListener;

public class PlayerMovedListener2 implements EventListener<PlayerMoved> {
    @Override
    public void listenTo(PlayerMoved event) {
        System.out.println("OTHER TASK ATTACHED to " + event.getClass().getName());
    }
}
