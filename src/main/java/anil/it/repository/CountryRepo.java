package anil.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import anil.it.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

}
