package com.wei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  private JmsTemplate jmsTemplate;

  private final String QUEUE = "changeHelperQueue";

  public void sendMessage(String message) {
    jmsTemplate.convertAndSend(QUEUE, message);
  }

  @GetMapping("/")
  public String inputForm() {
    return "main";
  }

  @PostMapping("/submit")
  public String submitMessage(@RequestParam String message) {
    System.out.println("submitMessage message = " + message);
    this.sendMessage(message);
    System.out.println("submitMessage return.");
    return "main";
  }

}
