@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("Incoming request: " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        
        chain.doFilter(request, response);
        
        System.out.println("Response status: " + ((HttpServletResponse) response).getStatus());
    }
}
