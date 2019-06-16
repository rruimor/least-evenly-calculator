package com.europeana.leastevenlycalculator;

import com.europeana.leastevenlycalculator.models.UpperRange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class LeastevenlycalculatorConfiguration {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION,
			proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UpperRange upperNumberHolder() {
		return new UpperRange(1);
	}

}
