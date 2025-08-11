package org.yeoff.common.config;

import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class JpaConfig implements AuditorAware<Long> {

  @Override
  public Optional<Long> getCurrentAuditor() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal.equals("anonymousUser")) {
      return Optional.empty();
    }

    return Optional.ofNullable((long) (int) principal);
  }
}
