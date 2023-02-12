package ptf.rs.repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JPARepository<T> implements CRUDRepository<T> {
    private final EntityManager em;

    private final Class<T> klass;

    public JPARepository(EntityManager em, Class<T> klass) {
        this.em = em;
        this.klass = klass;
    }

    @Override
    public void save(T value) {
        em.getTransaction().begin();
        em.persist(value);
        em.getTransaction().commit();
    }

    @Override
    public void update(T value) {
        em.getTransaction().begin();
        em.merge(value);
        em.getTransaction().commit();
    }

    @Override
    public List<T> readAll() {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(klass);
        cq.select(cq.from(klass));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void delete(Long id) {
        T value = em.find(klass, id);
        if (value != null) {
            em.getTransaction().begin();
            em.remove(value);
            em.getTransaction().commit();
        }
    }
}
