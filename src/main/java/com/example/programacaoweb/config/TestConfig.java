package com.example.programacaoweb.config;

import com.example.programacaoweb.entities.User;
import com.example.programacaoweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class TestConfig implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    private static final String[] FIRST_NAMES = {
            "Maria", "Alex", "James", "John", "Robert",
            "Michael", "William", "David", "Richard", "Joseph"
    };

    private static final String[] LAST_NAMES = {
            "Brown", "Green", "Smith", "Johnson", "Williams",
            "Jones", "Garcia", "Miller", "Davis", "Rodriguez"
    };

    private static final String[] EMAIL_DOMAINS = {
            "gmail.com", "yahoo.com", "hotmail.com", "outlook.com"
    };

    private Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            String email = String.format("%s.%s@%s", firstName.toLowerCase(), lastName.toLowerCase(), EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)]);
            String phone = String.format("9%08d", random.nextInt(100000000));
            String password = "123456";

            User user = new User(null, String.format("%s %s", firstName, lastName), email, phone, password);
            userRepository.save(user);
        }
    }
}
