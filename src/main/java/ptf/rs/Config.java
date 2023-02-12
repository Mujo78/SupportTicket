package ptf.rs;

import ptf.rs.models.Agent;
import ptf.rs.models.SupportTicket;
import ptf.rs.repository.CRUDRepository;
import ptf.rs.repository.JPARepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Config {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("my-persistence-unit");
    private static final EntityManager em = emf.createEntityManager();

    public static final CRUDRepository<SupportTicket> ticket = new JPARepository<>(em, SupportTicket.class);

    public static final CRUDRepository<Agent> agents = new JPARepository<>(em, Agent.class);

    public static boolean DEBUG_MODE = false;
}
