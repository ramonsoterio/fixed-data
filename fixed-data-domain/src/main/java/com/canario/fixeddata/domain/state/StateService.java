package com.canario.fixeddata.domain.state;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StateService {

  private final StateRepository stateRepository;

  public Mono<State> findById(UUID stateId) {
    return stateRepository.findById(stateId);
  }

  public Flux<State> findAll() {
    return stateRepository.findAll();
  }

  public Mono<State> findByInitials(String initials) {
    return stateRepository.findByInitials(initials);
  }
}