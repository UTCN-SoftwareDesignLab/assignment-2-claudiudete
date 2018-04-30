package bookStore.repository;

import bookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

     public List<User> findByUsernameAndPassword(String username,String password);

    @Modifying
    @Transactional
    @Query("update User u set u.password = ?1, u.role= ?2 where u.username = ?3")
    void updateUser(String password,String role,String username);

    @Transactional
    void deleteByUsername(String username);


}
