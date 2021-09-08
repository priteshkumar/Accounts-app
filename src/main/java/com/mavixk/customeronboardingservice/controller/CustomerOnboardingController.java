package com.mavixk.customeronboardingservice.controller;

import com.mavixk.customeronboardingservice.model.CustomerOnboardRequestVO;
import com.mavixk.customeronboardingservice.model.CustomerOnboardResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
Step 5: Create POST method onboardCustomer in the CustomerOnboardingController class;
the method will take CustomerOnboardRequestVO as input.
 */
@RestController
public class CustomerOnboardingController {

  @PostMapping("/customer/onboard")
  public ResponseEntity<CustomerOnboardResponseVO> onboardCustomer(@RequestBody
      CustomerOnboardRequestVO customerOnboardRequestVO) {

    ResponseEntity<CustomerOnboardResponseVO> customerOnboardResponseVOResponseEntity =
        new ResponseEntity<CustomerOnboardResponseVO>(
            new CustomerOnboardResponseVO("acdefgc-acde", "created"),
            HttpStatus.CREATED);

    return customerOnboardResponseVOResponseEntity;
    // return (ResponseEntity<CustomerOnboardResponseVO>) ResponseEntity
    //   .ok(new CustomerOnboardResponseVO("acdefgc-acde", "created"));
  }

}
