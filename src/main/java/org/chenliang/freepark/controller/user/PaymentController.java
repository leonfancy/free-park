package org.chenliang.freepark.controller.user;

import org.chenliang.freepark.model.PaymentResponse;
import org.chenliang.freepark.model.entity.Tenant;
import org.chenliang.freepark.service.PaymentServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
  @Autowired
  private PaymentServiceV2 paymentService;

  @PostMapping("/payments")
  public PaymentResponse pay(@AuthenticationPrincipal Tenant tenant) {
    return paymentService.pay(tenant.getId());
  }

  @GetMapping("/payments/today")
  public List<PaymentResponse> getPaymentsOfToday(@AuthenticationPrincipal Tenant tenant) {
    return paymentService.getTodayPayments(tenant);
  }
}
