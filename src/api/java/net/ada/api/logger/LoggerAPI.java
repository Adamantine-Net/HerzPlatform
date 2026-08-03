package net.ada.api.logger;

public interface LoggerAPI {
    void info(String message);
    void warn(String message);
    void error(String message, Throwable throwable);
    void fatal(String message);
    void fatal(Throwable throwable);
}