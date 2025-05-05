package si.um.feri.repository;

import si.um.feri.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Ranljiva metoda – ročno sestavljena poizvedba
    public List<User> findByUsernameUnsafe(String input) {
        String sql = "SELECT * FROM users WHERE username = '" + input + "'";
        return entityManager.createNativeQuery(sql, User.class).getResultList();
    }

    // Varna metoda – parametrizirano
    public List<User> findByUsername(String input) {
        String sql = "SELECT * FROM users WHERE username = :username";
        return entityManager.createNativeQuery(sql, User.class)
                .setParameter("username", input)
                .getResultList();
    }
}
