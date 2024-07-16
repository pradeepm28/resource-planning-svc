package com.colruytgroup.resourceplanningsvc.repository.coworker;

import com.colruytgroup.resourceplanningsvc.entity.coworker.Coworker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoworkerRepository extends JpaRepository<Coworker, Long> {
    public Coworker findCoworkerByEmployeeID(String employeeCode);
    public Coworker findByEmployeeID(String employeeCode);

}
