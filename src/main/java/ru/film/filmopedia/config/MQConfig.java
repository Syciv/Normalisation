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

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

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

        KeyStore clientStore = KeyStore.getInstance("PKCS12");
        clientStore.load(new FileInputStream("client.p12"), "passwordhihi".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(clientStore, "passwordhihi".toCharArray());
        KeyManager[] kms = kmf.getKeyManagers();

        InputStream is = new FileInputStream("ca_certificate.pem");

        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate caCert = (X509Certificate)cf.generateCertificate(is);

        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(null);
        ks.setCertificateEntry("caCert", caCert);

        tmf.init(ks);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kms, tmf.getTrustManagers(), new SecureRandom());

        connectionFactory.useSslProtocol(sslContext);
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(
                connectionFactory);
        return cachingConnectionFactory;
    }

}
