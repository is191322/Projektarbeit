
package at.ac.fhstp.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

//Verwaltet alle Pupdates
//Singelton
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findCommentsToPupdate(int pupdateID);

}