package com.gistimpact.carbonfootprint.service;

import com.gistimpact.carbonfootprint.dto.ApportionedImpact;
import com.gistimpact.carbonfootprint.dto.CompanyInput;
import com.gistimpact.carbonfootprint.dto.PortfolioFootprint;
import com.gistimpact.carbonfootprint.models.Company;
import com.gistimpact.carbonfootprint.models.ImpactData;
import com.gistimpact.carbonfootprint.repository.CompanyRepository;
import com.gistimpact.carbonfootprint.repository.ImpactDataRepository;
import com.gistimpact.carbonfootprint.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootPrintService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SectorRepository sectorRepository;
    @Autowired
    private ImpactDataRepository impactDataRepository;
    public ApportionedImpact apportionedImpact(CompanyInput companyInput) {
        Company company=companyRepository.findByCompanyName(companyInput.getCompanyName());
        ImpactData impactData=impactDataRepository.findByCompanyAndReportingYear(company,2021);
        double footPrint=companyInput.getInvestmentAmount()/impactData.getMarketCapitalization()*impactData.getGhgImpactUsd();
        return new ApportionedImpact(company.getCompanyName(),company.getSectorInfo().getSectorName(),impactData.getReportingYear(),footPrint);
    }

    public ResponseEntity<PortfolioFootprint> calculatePortfolioImpact(List<CompanyInput> portfoiloList) {
        double portfolioImpact=0.0;
        for(CompanyInput companyInput:portfoiloList){
            portfolioImpact=portfolioImpact+apportionedImpact(companyInput).getCarbonFootprint();
        }
        double totalInvestment=0.0;
        for(CompanyInput companyInput:portfoiloList){
            totalInvestment+=companyInput.getInvestmentAmount();
        }
        return new ResponseEntity<>(new PortfolioFootprint(portfolioImpact/totalInvestment*1e6,portfolioImpact),HttpStatus.OK);
    }
}

