package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<Address> addresses = new HashSet<>();

    @OneToMany
    private Set<CreditCard> creditCards = new HashSet<>();

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.getOwners().add(this);
    }

    public void addCreditCard(CreditCard card) {
        creditCards.add(card);
    }
}
