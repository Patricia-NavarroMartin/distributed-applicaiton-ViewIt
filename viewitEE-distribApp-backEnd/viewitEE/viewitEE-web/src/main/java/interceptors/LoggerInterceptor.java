package interceptors;

import java.util.Arrays;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import sessionbeans.singleton.TheLogger;


@Interceptor
public class LoggerInterceptor {
    
    @EJB
    TheLogger log;

    public LoggerInterceptor() {
    }
    
    @AroundInvoke
    public Object logMethodEntry(InvocationContext ic) {
        Object obj = null;
        try {
            log.getLog().log(Level.INFO, "Entering: {0}", ic.getMethod().getName());
            
            if(ic.getParameters() != null){
                log.getLog().log(Level.INFO, "[Id: {0}]", Arrays.stream(ic.getParameters()).findFirst().orElse(null));
            }
            obj = ic.proceed();
        } catch (Exception ex) {
            //TODO
        } finally {
            log.getLog().log(Level.INFO, "Exiting: {0}", ic.getMethod().getName());
        }
        return obj;
    }
    
}
