package config;

import org.springframework.boot.web.server.*;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

//@Component
//public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
//
//    @Override
//    public void customize(ConfigurableServletWebServerFactory factory) {
//        String port = System.getenv("PORT"); // Получаем порт из переменной окружения
//        if (port != null) {
//            factory.setPort(Integer.parseInt(port)); // Устанавливаем порт для фабрики сервлетов
//        }
//    }
//}