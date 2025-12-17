public Post createPost(Post post) {
    return restTemplate.postForObject(API_URL, post, Post.class);
}
import org.springframework.web.bind.annotation.RequestBody;

@PostMapping("/posts")
public Post createPost(@RequestBody Post post) {
    return apiService.createPost(post);
}
