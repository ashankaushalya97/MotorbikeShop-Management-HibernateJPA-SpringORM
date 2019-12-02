package lk.ijse.dep.rcrmoto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = {"lk.ijse.dep.rcrmoto"})
public class AppConfig {

}
