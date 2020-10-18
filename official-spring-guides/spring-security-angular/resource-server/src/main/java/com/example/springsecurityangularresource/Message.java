package com.example.springsecurityangularresource;

import java.util.UUID;

public class Message {


  private String content;
  private UUID id;

  public Message() {}

  public Message(String content){
    this.content = content;
    this.id = UUID.randomUUID();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

}
