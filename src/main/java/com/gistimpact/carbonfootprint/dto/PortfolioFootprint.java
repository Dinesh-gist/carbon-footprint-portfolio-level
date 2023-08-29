package com.gistimpact.carbonfootprint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioFootprint {
    private double carbonFootprintPerMInvest;
    private double totalCarbonFootprint;
}
