package com.rruimor.calculator.leastevenlydividable;

import com.rruimor.calculator.leastevenlydividable.models.UpperRange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class LeastEvenlyDividableConfiguration {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION,
		   proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UpperRange upperRange() {
		return new UpperRange(1);
	}
}
