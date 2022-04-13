package br.com.erudio.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // é uma anotação que permite ao Spring detectar automaticamente nossos beans personalizados.
@ConfigurationProperties("greeting-service")
/* Para que o Spring consiga interpretar essa classe que faz o bind com uma arquivo
 de configuração (yml ou properties) com uma classe java.
 */

// Classe de configuração
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue; // consegue fazer o bind com qual nome que colocar aqui.


    public GreetingConfiguration() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
