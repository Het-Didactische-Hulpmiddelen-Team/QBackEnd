package be;

import be.db.RoomRepository;
import be.model.Room;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(RoomRepository roomRepository) {
        return args -> {
            roomRepository.save(new Room("Vogels", "PVM", "C001"));
            roomRepository.save(new Room("Geens", "Systeembeheer", "C002"));
            roomRepository.save(new Room("Swennen", "Netwerken 1", "C003"));
        };
    }
}
