package anil.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import anil.it.entity.City;

import java.util.List;

public interface CityRepo extends JpaRepository<City, Integer>{

    public List<City> findBySid(Integer stateId);

}
