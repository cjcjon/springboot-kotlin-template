package com.spring.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    // TODO: 임시로 전체 허용. 이후 수정.
    http
      .csrf().disable()
      .headers().frameOptions().sameOrigin() // H2 web console
      .and()
      .authorizeRequests().anyRequest().permitAll()

    return http.build()
  }
}
