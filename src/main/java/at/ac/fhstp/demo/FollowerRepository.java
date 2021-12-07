package at.ac.fhstp.demo;

import org.springframework.data.repository.CrudRepository;

//Verwaltet alle Pupdates
//Singelton
public interface FollowerRepository extends CrudRepository<FollowerEntity, Integer> {

}