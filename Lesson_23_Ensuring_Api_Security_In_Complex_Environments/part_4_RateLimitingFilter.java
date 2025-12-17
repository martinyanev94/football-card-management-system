@Component
public class RateLimitingFilter implements Filter {

    private final int MAX_REQUESTS_PER_MINUTE = 100;
    private Map<String, Integer> requestCounts = new ConcurrentHashMap<>();
    private Map<String, Long> timestamps = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String clientIp = request.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        if (!timestamps.containsKey(clientIp) || 
                currentTime - timestamps.get(clientIp) > 60000) {
            timestamps.put(clientIp, currentTime);
            requestCounts.put(clientIp, 1);
        } else {
            requestCounts.put(clientIp, requestCounts.get(clientIp) + 1);
        }

        if (requestCounts.get(clientIp) > MAX_REQUESTS_PER_MINUTE) {
            ((HttpServletResponse) response).setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return;
        }

        chain.doFilter(request, response);
    }
}
