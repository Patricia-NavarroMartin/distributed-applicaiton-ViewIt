package filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// CORS = Cross-Origin Resource Sharing. This filter is necessary because this
// backend's domain is separate from the frontend's but they must communicate.

//This filter will add the necessary headers for any kind of communication.
//For modification requests (not GET) we must first send the 'preflight' request
//(extra security check which must activate it explicitely because option is omitted by default)

@WebFilter(filterName = "CORSfilter", urlPatterns = {"/*"}, dispatcherTypes = DispatcherType.REQUEST)
public class CORSfilter implements Filter {
    
    private FilterConfig config = null;
    
    public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    public static final String METHODS_NAME = "Access-Control-Allow-Methods";
    public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    public static final String MAX_AGE_NAME = "Access-Control-Max-Age";
    
    public CORSfilter() {
    }    
    
    private void doBeforeProcessing(ServletRequest servletRequest, ServletResponse servletResponse)throws IOException, ServletException {
       
        
        if (!(servletRequest instanceof HttpServletRequest)|| !(servletResponse instanceof HttpServletResponse)) {
            String message ="CORS doesn't support non-HTTP request or response.";
            throw new ServletException(message);
        }

    }    
   
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain chain)throws IOException, ServletException {
        
        //Checks it is typecast-safe
        doBeforeProcessing(servletRequest, servletResponse);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
                
        // Authorize (allow) all domains to consume the content
        response.addHeader(ORIGIN_NAME, "http://localhost:4200");
        response.addHeader(METHODS_NAME, "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.addHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader(MAX_AGE_NAME, "3600");
        response.addHeader(CREDENTIALS_NAME, "true");
        
        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if(request.getMethod().equals("OPTIONS")) {
            //response.setStatus(HttpServletResponse.SC_ACCEPTED);
            System.out.println(request.getHeader("Access-Control-Request-Headers"));
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        config.getServletContext().log("Initializing SessionCheckerFilter");
    }

    @Override
    public void destroy() {
        config.getServletContext().log("Destroying SessionCheckerFilter");
    }

}
