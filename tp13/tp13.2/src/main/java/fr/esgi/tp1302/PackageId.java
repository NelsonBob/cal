package fr.esgi.tp1302;

final class PackageId {
    private final int id;

    private PackageId(int id) {
        this.id = id;
    }

    public static PackageId of(int id) {
        return new PackageId(id);
    }

    public int value() {
        return id;
    }
}
