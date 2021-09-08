package com.mavixk.customeronboardingservice.controller;

import com.mavixk.customeronboardingservice.model.CoreBankingResponseVO;
import com.mavixk.customeronboardingservice.model.CustomerOnboardRequestVO;
import com.mavixk.customeronboardingservice.model.CustomerOnboardResponseVO;
import com.mavixk.customeronboardingservice.service.CustomerOnboardingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
Step 5: Create POST method onboardCustomer in the CustomerOnboardingController class;
the method will take CustomerOnboardRequestVO as input.
 */
@RestController
public class CustomerOnboardingController {

  private CustomerOnboardingService customerOnboardingService;

  public CustomerOnboardingController(CustomerOnboardingService customerOnboardingService) {
    this.customerOnboardingService = customerOnboardingService;
  }

  @PostMapping("/customer/onboard")
  public ResponseEntity<CustomerOnboardResponseVO> onboardCustomer(@RequestBody
      CustomerOnboardRequestVO customerOnboardRequestVO) {

    CoreBankingResponseVO coreBankingResponseVO =
        this.customerOnboardingService.saveCustomerDetails(customerOnboardRequestVO);

    ResponseEntity<CustomerOnboardResponseVO> customerOnboardResponseVOResponseEntity =
        new ResponseEntity<CustomerOnboardResponseVO>(
            /*new CustomerOnboardResponseVO("acdefgc-acde", "created"),*/
            CustomerOnboardResponseVO.builder().customerId(customerOnboardRequestVO.getCustomerId())
                .status("CUSTOMER_CREATED").build(),
            HttpStatus.CREATED);

    return customerOnboardResponseVOResponseEntity;
    // return (ResponseEntity<CustomerOnboardResponseVO>) ResponseEntity
    //   .ok(new CustomerOnboardResponseVO("acdefgc-acde", "created"));
  }

}
