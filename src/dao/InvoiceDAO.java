package dao;

import tables.Invoiceeee;

import javax.persistence.EntityManager;
import java.util.List;

public class InvoiceDAO {
    private EntityManager em;

    public InvoiceDAO(EntityManager em) {
        this.em = em;
    }

    public List<Invoiceeee> findAll() {
        return em.createQuery("select c from Client c", Invoiceeee.class)
                .getResultList();
    }

    public void add(Invoiceeee invoiceeee) {
        em.getTransaction().begin();
        em.persist(invoiceeee);
        em.getTransaction().commit();
    }
}
