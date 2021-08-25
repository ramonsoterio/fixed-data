package com.canario.fixeddata.api.v1.city;

import com.canario.fixeddata.domain.state.State;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CityResponse {

  private UUID id;

  private String name;

  private String lowerCaseName;

  private State state;
}
