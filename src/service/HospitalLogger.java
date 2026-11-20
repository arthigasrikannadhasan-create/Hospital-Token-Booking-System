package service;
import java.util.logging.*;

public class HospitalLogger {

    private static final Logger logger =
            Logger.getLogger(HospitalLogger.class.getName());

    static {
        try {
            FileHandler fileHandler =
                    new FileHandler("hospital.log", true);

            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);

        } catch (Exception e) {
            System.out.println("Logging setup failed.");
        }
    }

    public static void log(String message) {
        logger.info(message);
    }
}
