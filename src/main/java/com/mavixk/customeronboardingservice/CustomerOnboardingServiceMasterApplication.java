package com.mavixk.customeronboardingservice;

import com.mavixk.customeronboardingservice.model.CustomerOnboardRequestVO;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
@EnableFeignClients
public class CustomerOnboardingServiceMasterApplication {

  private static Logger logger =
      LoggerFactory.getLogger(CustomerOnboardingServiceMasterApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CustomerOnboardingServiceMasterApplication.class, args);
    testCustomerOnBoarding();
  }

  public static void testCustomerOnBoarding() {
    String accountsUrl = "http://localhost:8080//customer/onboard";
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder uriComponentsBuilder =
        UriComponentsBuilder.fromHttpUrl(accountsUrl);
    CustomerOnboardRequestVO customerOnboardRequestVO =
        CustomerOnboardRequestVO.builder().customerId(UUID.randomUUID().toString())
        .customerBankId(UUID.randomUUID().toString()).mobileNo("1231231231").dob(LocalDate.now()).build();

    System.out.println(uriComponentsBuilder.toUriString());
    logger.debug("use resttemplate exchange method");
    ResponseEntity<String> responseEntity =
        restTemplate.postForEntity(uriComponentsBuilder.toUriString(),customerOnboardRequestVO,
            String.class);
    System.out.println(responseEntity.getStatusCodeValue());
    System.out.println(responseEntity.getBody());
  }
}
