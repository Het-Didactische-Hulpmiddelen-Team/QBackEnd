package be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection(targetClass=String.class)
    private List<String> queue;

    private String lector;
    private String vak;
    private String lokaal;

    public Room(){

    }

    public Room(String lector, String vak, String lokaal) {
        setQueue(new ArrayList<>());
        setLector(lector);
        setLokaal(lokaal);
        setVak(vak);
    }

    public Room(ArrayList<String> queue,String lector, String vak, String lokaal) {
        setQueue(queue);
        setLector(lector);
        setLokaal(lokaal);
        setVak(vak);
    }

    @JsonIgnore
    public List<String> getQueue() {
        return queue;
    }

    public void setQueue(List<String> queue) {
        this.queue = queue;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    public String getLokaal() {
        return lokaal;
    }

    public void setLokaal(String lokaal) {
        this.lokaal = lokaal;
    }

    public void addToQueue(String name){
        queue.add(name);
    }

    public void deleteFromQueue(String name){
        queue.remove(name);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Room.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("queue=" + queue.size())
                .add("lector='" + lector + "'")
                .add("vak='" + vak + "'")
                .add("lokaal='" + lokaal + "'")
                .toString();
    }
}
