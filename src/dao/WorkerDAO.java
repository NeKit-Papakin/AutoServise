package dao;

import tables.Worker;

import javax.persistence.EntityManager;
import java.util.List;

public class WorkerDAO {
    private EntityManager em;

    public WorkerDAO(EntityManager em) {
        this.em = em;
    }

    public List<Worker> findAll() {
        return em.createQuery("select w from Worker w", Worker.class)
                .getResultList();
    }

    public void add(Worker worker) {
        em.getTransaction().begin();
        em.persist(worker);
        em.getTransaction().commit();
    }

    public void delete(Worker worker) {
        em.getTransaction().begin();
        Worker forDelete = em.find(Worker.class, worker.getId());
        em.remove(forDelete);
        em.getTransaction().commit();
    }

    public void editRecord(Worker worker) {
        em.getTransaction().begin();
        em.merge(worker);
        em.getTransaction().commit();
    }
}
