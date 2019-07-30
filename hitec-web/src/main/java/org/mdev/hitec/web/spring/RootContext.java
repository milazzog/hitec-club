package org.mdev.hitec.web.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */

@Configuration
@ComponentScan(basePackages = "org.mdev")
@PropertySource({"classpath:db.properties"})
@Import({SecurityConfig.class, PersistenceConfig.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RootContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}