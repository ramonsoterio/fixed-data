package com.canario.fixeddata.domain.city;

import com.canario.fixeddata.domain.state.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CityService {

  private final CityRepository cityRepository;
  private final StateService stateService;

  public Flux<City> findAll() {
    return stateService
      .findAll()
      .flatMap(
        state -> cityRepository
          .findByStateId(state.getId())
          .map(city -> city.withState(state))); //COLLECT LIST PRA JOGAR NA LISTA COM IDS. USAR AS IDS PRA PESQUISAR AS CIDADES USANDO IN()
  }

  public Flux<City> findByNameLike(String name) {
    return
      cityRepository
        .findByNameContaining(name)
        .flatMap(currentCity -> stateService
          .findById(currentCity.getStateId())
          .map(currentCity::withState));
  }

  public Flux<City> findByStateInitials(String initials) {
    return cityRepository
      .findByStateInitials(initials)
      .flatMap(city -> stateService.findById(city.getStateId())
        .map(city::withState));
  }
}