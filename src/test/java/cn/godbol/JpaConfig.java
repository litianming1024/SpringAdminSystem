package cn.godbol;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Li on 2016/10/15.
 */
@Configuration
@EnableJpaRepositories("cn.godbol.domain")
public class JpaConfig {
}
