package com.canario.fixeddata.domain.city;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CityRepository extends ReactiveCrudRepository<City, UUID> {

  Flux<City> findAll();

  Flux<City> findByNameContaining(@Param("name") String name);

  Flux<City> findByStateId(UUID id);

  @Query("select city.* from city inner join state on city.state_id = state.state_id where state.initials = :initials")
  Flux<City> findByStateInitials(@Param("initials") String initials);
}
