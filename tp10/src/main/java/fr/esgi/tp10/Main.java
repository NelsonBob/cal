package fr.esgi.tp10;

final class Main {

    public static void main(String[] args) {
        String filePath = "/Users/gboissinot/Dev/ESGI/esgi-al-tps/tp10/output/myLog.log";
        final Logger fileLogger = LoggerFactory.createFileLogger(filePath);
        fileLogger.log("NY MESSAGE1");
        fileLogger.log("NY MESSAGE2");
    }
}
