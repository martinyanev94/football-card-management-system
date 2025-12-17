@SpringBootApplication
@EnableAsync
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
@Service
public class NotificationService {
    
    @Async
    public void sendWelcomeEmail(String email) {
        // Simulate email sending delay
        try {
            Thread.sleep(5000); // Simulate a delay of 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Welcome email sent to: " + email);
    }
}
