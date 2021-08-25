package com.canario.fixeddata.api.v1.city;

import com.canario.fixeddata.domain.city.City;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CityMapper {

  public static City toEntity (final CityRequest request) {
    return toEntity(new City(),  request);
  }

  static City toEntity(final City city, final CityRequest request) {
    var entity = new City();
    BeanUtils.copyProperties(request, entity);

    return entity;
  }

  static CityResponse toResponse(City entity) {
    var response = new CityResponse();

    BeanUtils.copyProperties(entity, response);

    return response;
  }
}
