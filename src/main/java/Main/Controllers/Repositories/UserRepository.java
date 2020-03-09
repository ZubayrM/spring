package Main.Controllers.Repositories;

import Main.Controllers.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String username);

}
