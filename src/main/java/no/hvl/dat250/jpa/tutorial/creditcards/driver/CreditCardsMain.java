package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      EntityManager em = factory.createEntityManager();
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void createObjects(EntityManager em) {
    Bank bank = new Bank();
    bank.setName("Pengebank");

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);
    card1.setOwningBank(bank);
    card1.setPincode(pincode);

    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    card2.setOwningBank(bank);
    card2.setPincode(pincode);

    Customer max = new Customer();
    max.setName("Max Mustermann");
    max.addCreditCard(card1);
    max.addCreditCard(card2);

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    address.addOwner(max);

    em.persist(bank);
    em.persist(pincode);
    em.persist(card1);
    em.persist(card2);
    em.persist(max);
    em.persist(address);
  }
}
