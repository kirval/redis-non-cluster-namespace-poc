package co.altir.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

    @Value("${app.redis-db-index}")
    private int redisDBIndex;

    @Bean
    public RedisConnectionFactoryBeanPostProcessor redisConnectionFactoryBeanPostProcessor() {
        return new RedisConnectionFactoryBeanPostProcessor();
    }

    private class RedisConnectionFactoryBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof LettuceConnectionFactory) {
                ((LettuceConnectionFactory) bean).setDatabase(redisDBIndex);
            }
            return bean;
        }
    }

}