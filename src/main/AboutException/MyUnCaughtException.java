package AboutException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyUnCaughtException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger anonymousLogger = Logger.getAnonymousLogger();
        anonymousLogger.log(Level.WARNING,t.getName() +":报错了",e);
    }
}
