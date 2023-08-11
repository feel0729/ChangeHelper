package com.wei.schedule;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class PatrolCarService {

  private final String QUEUE = "changeHelperQueue";

  @JmsListener(destination = QUEUE)
  public void receiveMessage(String messageContent) {
    System.out.println("receiveMessage = " + messageContent);
    // TODO: �B�z�����쪺�����A�Ҧp�N��g�J Excel
    processMessage(messageContent);
  }

  public void processMessage(String messageContent) {
    // TODO: �N�T�����e�g�J Excel
    System.out.println("processMessage = " + messageContent);
  }
}
