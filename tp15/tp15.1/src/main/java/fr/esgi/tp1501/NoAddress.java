package fr.esgi.tp1501;

final class NoAddress implements Address {
    @Override
    public String city() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String country() {
        throw new UnsupportedOperationException();
    }
}
