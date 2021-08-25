package com.canario.fixeddata.domain.state;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface StateRepository extends ReactiveCrudRepository<State, UUID> {

  Mono<State> findByInitials(String initials);
}
