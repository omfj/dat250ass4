package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private Set<CreditCard> creditCards = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CreditCard> getOwnedCards() {
        return creditCards;
    }

    public void addOwnedCard(CreditCard card) {
        creditCards.add(card);
        card.setOwningBank(this);
    }

}
