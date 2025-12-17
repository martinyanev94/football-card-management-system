@Service
public class EmailService {
    @Async
    public void sendWelcomeEmail(String userEmail) {
        // Logic to send email
        System.out.println("Sending welcome email to " + userEmail);
    }
}
@Configuration
@EnableAsync
public class AsyncConfig {
}
