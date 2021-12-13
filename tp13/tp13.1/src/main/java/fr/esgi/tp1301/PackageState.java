package fr.esgi.tp1301;

/**
 * State package with enum
 */
@SuppressWarnings("all")
enum PackageState {
    IN_TRANSIT(1),
    CREATED(0),
    DELIVERED(2);

    private final int id;

    PackageState(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
