
package at.ac.fhstp.demo;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//Verwaltet alle Pupdates
//Singelton
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
    List<CommentEntity> findCommentsToPupdate(int pupdateID);

}