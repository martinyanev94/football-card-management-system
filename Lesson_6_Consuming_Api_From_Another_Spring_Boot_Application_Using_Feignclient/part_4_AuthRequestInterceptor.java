import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + getAccessToken());
    }

    private String getAccessToken() {
        // Logic to retrieve the access token
        return "your_access_token_here";
    }
}
