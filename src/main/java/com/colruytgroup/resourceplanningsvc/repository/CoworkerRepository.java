package com.colruytgroup.resourceplanningsvc.repository;

import com.colruytgroup.resourceplanningsvc.entity.Coworker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoworkerRepository extends JpaRepository<Coworker,Long> {

}
