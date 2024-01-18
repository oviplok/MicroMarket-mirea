package config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PortConfiguration implements EnvironmentAware {

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Value("${server.port}")
    private int serverPort;

    // Метод для получения значения переменной окружения "PORT"
    public String getPortFromEnv() {
        return env.getProperty("PORT");
    }

    // Доступ к переменным окружения через аннотацию @Value
    public int getServerPort() {
        return serverPort;
    }
}