package com.wei.schedule;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class PatrolCarService {

  private final String QUEUE = "changeHelperQueue";

  @JmsListener(destination = QUEUE)
  public void receiveMessage(String messageContent) {
    System.out.println("receiveMessage = " + messageContent);
    // TODO: 處理接收到的消息，例如將其寫入 Excel
    processMessage(messageContent);
  }

  public void processMessage(String messageContent) {
    // TODO: 將訊息內容寫入 Excel
    System.out.println("processMessage = " + messageContent);
  }
}
