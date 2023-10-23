package com.mna.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthInsurance {


    private Integer id;


    private String employeeName;


    private Double amount;
}
