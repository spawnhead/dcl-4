package src_modern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "net.sam.dcl")
public class DclModernApplication {
    public static void main(String[] args) {
        SpringApplication.run(DclModernApplication.class, args);
    }
}
