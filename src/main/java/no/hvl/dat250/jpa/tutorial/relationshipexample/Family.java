package no.hvl.dat250.jpa.tutorial.relationshipexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany
    private final List<Person> members = new ArrayList<>();

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getMembers() {
        return members;
    }

}