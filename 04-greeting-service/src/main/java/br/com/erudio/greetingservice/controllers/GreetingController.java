package br.com.erudio.greetingservice.controllers;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.greetingservice.configuration.GreetingConfiguration;
import br.com.erudio.greetingservice.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "%s, %s!"; // aqui vai receber um parametro, no caso dinâmico
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingConfiguration configuration;
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value="name",
			defaultValue = "") String name) {

		if(name.isEmpty()){
			name = configuration.getDefaultValue();
		}
		return new Greeting(
					counter.incrementAndGet(),
					String.format(template, configuration.getGreeting(), name)
				);
	}
}
