package com.mavixk.customeronboardingservice.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOnboardRequestVO {

  private String customerId;

  private String customerBankId;

  private String mobileNo;

  private LocalDate dob;

}
