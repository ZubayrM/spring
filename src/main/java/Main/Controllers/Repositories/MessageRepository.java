package Main.Controllers.Repositories;

import Main.Controllers.Model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Integer> {

    List<Message> findByTag(String tag);

}
