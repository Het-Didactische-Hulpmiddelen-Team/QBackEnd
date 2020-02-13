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

    @ElementCollection(targetClass=Long.class)
    private List<Long> queue;

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

    public Room(ArrayList<Long> queue,String lector, String vak, String lokaal) {
        setQueue(queue);
        setLector(lector);
        setLokaal(lokaal);
        setVak(vak);
    }

    @JsonIgnore
    public List<Long> getQueue() {
        return queue;
    }

    public void setQueue(List<Long> queue) {
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

    public void addToQueue(Long id){
        queue.add(id);
    }

    public void deleteFromQueue(Long id){
        queue.remove(id);
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
