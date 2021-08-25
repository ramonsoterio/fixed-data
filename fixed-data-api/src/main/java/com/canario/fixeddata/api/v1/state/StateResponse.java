package com.canario.fixeddata.api.v1.state;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StateResponse {

  private UUID id;

  private String name;

  private String initials;
}
