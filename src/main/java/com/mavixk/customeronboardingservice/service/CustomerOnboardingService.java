package com.mavixk.customeronboardingservice.service;

import com.mavixk.customeronboardingservice.feign.CoreBankingACLClient;
import com.mavixk.customeronboardingservice.model.CoreBankingResponseVO;
import com.mavixk.customeronboardingservice.model.Customer;
import com.mavixk.customeronboardingservice.model.CustomerOnboardRequestVO;
import com.mavixk.customeronboardingservice.repository.CustomerOnboardingRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerOnboardingService {

  //private CustomerOnboardingRepository customerOnboardingRepository;
  private CoreBankingACLClient coreBankingACLClient;

  public CustomerOnboardingService(/*CustomerOnboardingRepository customerOnboardingRepository,*/
      CoreBankingACLClient coreBankingACLClient) {
    //this.customerOnboardingRepository = customerOnboardingRepository;
    this.coreBankingACLClient = coreBankingACLClient;
  }

  public CoreBankingResponseVO saveCustomerDetails(
      CustomerOnboardRequestVO customerOnboardRequestVO) {

    //fix this later
    this.coreBankingACLClient.validateCustomer(customerOnboardRequestVO);

    /*this.customerOnboardingRepository.save(
        Customer.builder().customerId(customerOnboardRequestVO.getCustomerId())
            .mobileNo(customerOnboardRequestVO.getMobileNo()).dob(customerOnboardRequestVO.getDob())
            .build());*/
    return CoreBankingResponseVO.builder()
        .customerBankId(customerOnboardRequestVO.getCustomerBankId()).build();
  }
}
