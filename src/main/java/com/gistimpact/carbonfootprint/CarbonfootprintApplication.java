package com.gistimpact.carbonfootprint;

import com.gistimpact.carbonfootprint.models.Company;
import com.gistimpact.carbonfootprint.models.ImpactData;
import com.gistimpact.carbonfootprint.models.SectorInfo;
import com.gistimpact.carbonfootprint.repository.CompanyRepository;
import com.gistimpact.carbonfootprint.repository.ImpactDataRepository;
import com.gistimpact.carbonfootprint.repository.SectorRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CarbonfootprintApplication{

	public static void main(String[] args) {

		SpringApplication.run(CarbonfootprintApplication.class, args);

	}
}
