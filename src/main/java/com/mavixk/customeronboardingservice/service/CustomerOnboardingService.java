package com.mavixk.customeronboardingservice.service;

import com.mavixk.customeronboardingservice.model.CoreBankingResponseVO;
import com.mavixk.customeronboardingservice.model.CustomerOnboardRequestVO;
import org.springframework.stereotype.Service;

@Service
public class CustomerOnboardingService {

  public CoreBankingResponseVO saveCustomerDetails(
      CustomerOnboardRequestVO customerOnboardRequestVO) {

    return CoreBankingResponseVO.builder()
        .customerBankId(customerOnboardRequestVO.getCustomerBankId()).build();
  }
}
