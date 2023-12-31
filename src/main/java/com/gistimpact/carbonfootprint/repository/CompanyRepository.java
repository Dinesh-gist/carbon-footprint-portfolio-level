package com.gistimpact.carbonfootprint.repository;

import com.gistimpact.carbonfootprint.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Company findByCompanyName(String companyName);
}
