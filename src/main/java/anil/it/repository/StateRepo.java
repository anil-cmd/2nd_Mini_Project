package anil.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import anil.it.entity.State;

import java.util.List;

public interface StateRepo extends JpaRepository<State, Integer>{

    public List<State> findByCid(Integer countryId);

}
