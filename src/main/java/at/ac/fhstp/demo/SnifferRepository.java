package at.ac.fhstp.demo;

import org.springframework.data.repository.CrudRepository;

//Verwaltung aller Sniffer
//Singelton
public interface SnifferRepository extends CrudRepository<SnifferEntity, Integer> {

}
