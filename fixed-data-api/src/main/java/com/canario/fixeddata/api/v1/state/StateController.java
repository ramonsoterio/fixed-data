package com.canario.fixeddata.api.v1.state;


import com.canario.fixeddata.domain.state.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/states")
@RequiredArgsConstructor
public class StateController {
  private final StateService stateService;
}
