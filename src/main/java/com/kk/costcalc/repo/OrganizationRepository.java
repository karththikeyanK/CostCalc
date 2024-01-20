package com.kk.costcalc.repo;

import com.kk.costcalc.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    boolean existsByName(String name);

    boolean existsByRegNo(String regNo);
}
