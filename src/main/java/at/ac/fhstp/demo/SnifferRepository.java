package at.ac.fhstp.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//Verwaltung aller Sniffer
//Singelton
public interface SnifferRepository extends JpaRepository<SnifferEntity, Integer> {

}
