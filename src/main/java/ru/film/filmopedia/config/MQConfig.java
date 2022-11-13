package ru.film.filmopedia.config;

import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.film.filmopedia.handler.MQReceiver;
import ru.film.filmopedia.service.FilmopediaService;

@Configuration
@EnableRabbit
public class MQConfig {

    @Value("${mq.address}")
    private String address;

    @Value("${mq.port}")
    private String port;

    @Bean
    public Queue films(){
        return new Queue("films");
    }

    @Bean
    public MQReceiver receiver(FilmopediaService filmopediaService){
        return new MQReceiver(filmopediaService);
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    @SneakyThrows
    ConnectionFactory connectionFactory() {
        com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
        connectionFactory.setHost(address);
        connectionFactory.setPort(Integer.parseInt(port));
//        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
//        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        KeyStore keyStore = KeyStore.getInstance("pkcs12");
//        keyStore.load(new FileInputStream("keystore.p12"), "passwordhihi".toCharArray());
//        kmf.init(keyStore, "passwordhihi".toCharArray());
//        sslContext.init(kmf.getKeyManagers(), null, null);
//        connectionFactory.useSslProtocol();
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(
                connectionFactory);
        return cachingConnectionFactory;
    }

}
