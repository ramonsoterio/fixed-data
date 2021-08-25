package com.canario.fixeddata.domain.city;

import com.canario.fixeddata.domain.state.State;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
@Table("city")
public class City {

  @Id
  @Column("city_id")
  private UUID id;

  private String name;

  @Column("lower_case_name")
  private String lowerCaseName;

  @Column("state_id")
  private UUID stateId;

  @Transient
  private State state;
}
