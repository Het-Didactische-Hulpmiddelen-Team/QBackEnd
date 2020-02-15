package be;

import be.db.RoomRepository;
import be.model.Room;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories("be.db")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(RoomRepository roomRepository) {
        return args -> {
            String[] users = new String[]{"Arne","Arthur","Stijn","Ruben","Niels","Gleb","Simon","Sander","Sam","Michiel","Thomas","Ewald","Ben","Brent","Levi","Dieter","Spenge","Stef","Milan","Joppe"};
            String[] lectoren = new String[]{"Vogels","Geens","Swennen","Jongen","Steegmans","Van Hee"};
            String[] vakken = new String[]{"PVM","Systeembeheer","BS2","Web2","Web4","POD"};
            String[] lokalen = new String[]{"C001","C002","D140","D126","B009"};
            Random random = new Random();

            for (int i = 0; i < lectoren.length; i++) {
                roomRepository.save(new Room(createQueue(users),lectoren[i], vakken[i], lokalen[random.nextInt(lokalen.length)]));
            }
        };
    }

    public ArrayList<String> createQueue(String[] users){
        Random random = new Random();
        ArrayList<String> queue = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int temp = random.nextInt(users.length);
            if(!queue.contains(users[temp])){
                queue.add(users[temp]);
            }
        }
        return queue;
    }
}
