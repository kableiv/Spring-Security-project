package com.rfboernehave.demo.repositories;

import com.rfboernehave.demo.domains.MinBruger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrugerRepository extends CrudRepository<MinBruger, String> {

}
