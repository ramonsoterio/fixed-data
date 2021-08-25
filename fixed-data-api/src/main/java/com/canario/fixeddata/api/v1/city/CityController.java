package com.canario.fixeddata.api.v1.city;

import com.canario.fixeddata.domain.city.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/cities")
@RequiredArgsConstructor
public class CityController {

  final private CityService cityService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<CityResponse> findAll(
    @RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "state", required = false) String state
  ) {
    if (name != null) {
      return cityService.findByNameLike(name).map(CityMapper::toResponse);
    }

    if (state != null) {
      return cityService.findByStateInitials(state).map(CityMapper::toResponse);
    }

    return cityService.findAll().map(CityMapper::toResponse);
  }
}
