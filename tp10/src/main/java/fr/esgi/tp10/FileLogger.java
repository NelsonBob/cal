package fr.esgi.tp10;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

final class FileLogger implements Logger {

    private final Path logFilePath;

    public FileLogger(Path logFilePath) {
        this.logFilePath = logFilePath;
    }

    @Override
    public void log(String message) {
        try (FileWriter fileWriter = new FileWriter(logFilePath.toFile(), true)) {
            fileWriter.append(message);
            fileWriter.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
