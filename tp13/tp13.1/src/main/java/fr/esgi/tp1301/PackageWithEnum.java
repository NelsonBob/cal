package fr.esgi.tp1301;

import java.time.LocalDateTime;

final class PackageWithEnum {

    private final PackageId packageId;
    private final LocalDateTime creationDate;
    private PackageState state;

    public PackageWithEnum(PackageId packageId, LocalDateTime creationDate) {
        this.packageId = packageId;
        this.creationDate = creationDate;
    }

    public void changeState(PackageState state) {
        this.state = state;
    }
}
