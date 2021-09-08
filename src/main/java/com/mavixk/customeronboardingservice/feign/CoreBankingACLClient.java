package com.mavixk.customeronboardingservice.feign;

import com.mavixk.customeronboardingservice.model.CoreBankingResponseVO;
import com.mavixk.customeronboardingservice.model.CustomerBankInfo;
import com.mavixk.customeronboardingservice.model.CustomerOnboardRequestVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "corebanking-client", url = "${core-banking-url}")
public interface CoreBankingACLClient {

  @GetMapping("/customer/validate")
  public CoreBankingResponseVO validateCustomer(
      @RequestBody CustomerOnboardRequestVO customerOnboardRequestVO);
}
