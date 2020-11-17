package thinking.in.spring.boot.firstappbygui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thinking.in.spring.boot.config.WebConfiguration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Configuration
//@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = "thinking.in.spring.boot.config")
public class FirstAppByGuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppByGuiApplication.class, args);
	}

	//    /**
//     * {@link ApplicationRunner#run(ApplicationArguments)} 方法在
//     * Spring Boot 应用启动后回调
//     *
//     * @param context WebServerApplicationContext
//     * @return ApplicationRunner Bean
//     */
//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context) {
//        return args -> {
//            System.out.println("当前 WebServer 实现类为："
//                    + context.getWebServer().getClass().getName());
//        };
//    }

	/**
	 * ServletWebServerInitializedEvent 和 ReactiveWebServerInitializedEvent
	 * 是 WebServerInitializedEvent的实现类。
	 * 监控父类可以覆盖更广的场景，可以监控非Web，比上面的方法更健壮。
	 * @param event
	 */
	@EventListener(WebServerInitializedEvent.class)
	public void onWebServerReady(WebServerInitializedEvent event) {
		System.out.println("当前 WebServer 实现类为："
                    + event.getWebServer().getClass().getName());
	}
}
