package com.canario.fixeddata.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class FlywayConfig {

  private final Environment env;

  public FlywayConfig(final Environment env) {
    this.env = env;
  }

  @Bean(initMethod = "migrate")
  public Flyway flyway() {
    return new Flyway(Flyway.configure()
      .baselineOnMigrate(true)
      .dataSource(
        env.getRequiredProperty("flyway.url"),
        env.getRequiredProperty("flyway.user"),
        env.getRequiredProperty("flyway.password"))
      .schemas(env.getRequiredProperty("flyway.schemas"))
      .defaultSchema(env.getRequiredProperty("flyway.schemas"))
      .locations(env.getRequiredProperty("flyway.locations"))
    );
  }
}