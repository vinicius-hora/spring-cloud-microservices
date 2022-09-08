package br.com.erudio.greetingservice.controllers;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.greetingservice.configuration.GreetingConfiguration;
import br.com.erudio.greetingservice.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingConfiguration greetingConfiguration;

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value="name",
                    defaultValue = "") String name) {
        if(name.isEmpty()){
            name = greetingConfiguration.getDefaultValue();
        }
        return new Greeting(
                counter.incrementAndGet(),
                String.format(template, greetingConfiguration.getGreeting(), name)
        );
    }
}