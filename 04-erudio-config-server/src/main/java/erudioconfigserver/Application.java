package erudioconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/*
O Spring Cloud Configuration Server é um aplicativo centralizado que gerencia todas as propriedades de
configuração relacionadas ao aplicativo.
 */
@SpringBootApplication
@EnableConfigServer // faz com que seu aplicativo Spring Boot atue como um servidor de configuração.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
