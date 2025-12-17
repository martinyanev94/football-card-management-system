import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    public String getPosts() {
        return restTemplate.getForObject(API_URL, String.class);
    }
}
