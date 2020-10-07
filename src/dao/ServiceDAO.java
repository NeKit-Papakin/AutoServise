package dao;

import tables.Services;

import javax.persistence.EntityManager;
import java.util.List;

public class ServiceDAO {
    private EntityManager em;

    public ServiceDAO(EntityManager em) {
        this.em = em;
    }

    public List<Services> findAll() {
        return em.createQuery("select s from Services s", Services.class)
                .getResultList();
    }

    public void add(Services services) {
        em.getTransaction().begin();
        em.persist(services);
        em.getTransaction().commit();
    }

    public void delete(Services services) {
        em.getTransaction().begin();
        Services forDelete = em.find(Services.class, services.getId());
        em.remove(forDelete);
        em.getTransaction().commit();
    }

    public void editRecord(Services service) {
        em.getTransaction().begin();
        em.merge(service);
        em.getTransaction().commit();
    }
}
