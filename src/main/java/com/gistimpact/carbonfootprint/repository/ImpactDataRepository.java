package com.gistimpact.carbonfootprint.repository;

import com.gistimpact.carbonfootprint.models.Company;
import com.gistimpact.carbonfootprint.models.ImpactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImpactDataRepository extends JpaRepository<ImpactData, UUID> {
    //List<ImpactData> findAllByCompanyId(UUID guid);

    //List<ImpactData> findAllByCompany(Company company);

    //List<ImpactData> findAllByCompanyId(int id);

     List<ImpactData> findAllByCompany(Company company);

//    @Query(value = "select info from ref_info info where info.company_id=:guid and info.reporting_year=:i",nativeQuery = true)
//    ImpactData findByCompanyByIdAndReportingYear(String guid, int i);

    ImpactData findByCompanyAndReportingYear(Company company, int i);


    //List<ImpactData> findAllByCompanyCompanyName(Company company);

    //List<ImpactData> findAllByCompanyId(int id);

    //List<ImpactData> findByCompany(Company company);
}
