package be;

import be.db.RoomRepository;
import be.db.UserRepository;
import be.model.Room;
import be.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(RoomRepository roomRepository, UserRepository userRepository) {
        return args -> {
            String[] users = new String[]{"Arne","Arthur","Stijn","Ruben","Niels","Gleb","Simon","Sander","Sam","Michiel","Thomas","Ewald","Ben","Brent","Levi","Dieter","Spenge","Stef","Milan","Joppe"};
            String[] lectoren = new String[]{"Vogels","Geens","Swennen","Jongen","Steegmans","Van Hee"};
            String[] vakken = new String[]{"PVM","Systeembeheer","BS2","Web2","Web4","POD"};
            String[] lokalen = new String[]{"C001","C002","D140","D126","B009"};
            Random random = new Random();

            for (int i = 0; i < users.length; i++) {
                userRepository.save(new User(users[i]));
            }

            for (int i = 0; i < lectoren.length; i++) {
                roomRepository.save(new Room(createQueue(userRepository),lectoren[i], vakken[i], lokalen[random.nextInt(lokalen.length)]));
            }
        };
    }

    public ArrayList<Long> createQueue(UserRepository userRepository){
        Random random = new Random();
        ArrayList<Long> queue = new ArrayList<>();
        for (int i = 0; i < userRepository.findAll().size(); i++) {
            long temp = userRepository.findAll().get(random.nextInt(userRepository.findAll().size())).getId();
            if(!queue.contains(temp)){
                queue.add(temp );
            }
        }
        return queue;
    }
}
