package com.rruimor.calculator.leastevenlydivisible;

import com.rruimor.calculator.leastevenlydivisible.models.UpperRange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class LeastEvenlyDivisibleConfiguration {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION,
		   proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UpperRange upperRange() {
		return new UpperRange(1);
	}
}
