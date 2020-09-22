
package sessionbeans.singleton;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class TheLogger {
    private String status;
    private static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    @PostConstruct
    void init() {
        status = "Ready";
        System.out.println(status);
        /*
        LogManager.getLogManager().reset();
        LOG.setLevel(Level.ALL);
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        LOG.addHandler(ch);
        
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        LOG.addHandler(ch);
        LOG.setLevel(Level.INFO);
        LOG.setUseParentHandlers(false);
        */
        LOG.log(Level.INFO,"Logger ready too!");
    }
    
    public static Logger getLog() {
        return LOG;
    }
    
}
