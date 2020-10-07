package dao;

import tables.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDAO {
    private EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    public List<Client> findAll() {
        return em.createQuery("select c from Client c", Client.class)
                .getResultList();
    }

    public void add(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public void delete(Client client) {
        em.getTransaction().begin();
        Client forDelete = em.find(Client.class, client.getId());
        em.remove(forDelete);
        em.getTransaction().commit();
    }

    public void editRecord(Client client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }
}
