package com.library.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;


/**
 * Конфигурая спринга
 *
 * @author Alexey Voronov on 01.07.2023
 */
@Configuration
@ComponentScan("com.library.app") // путь до контроллеров
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 1. Создаем разрешитель шаблонов
     * <br>2. Устанавливаем контекст представления для templateResolver
     * <br>3,4. Устанавливаем префикс и суфикс пути к файлам предстовления
     * <br>5. Возвращаем объект templateResolver
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    /**
     * 1. Создаем движок для обработки шаблонов
     * <br>2. Устанавливаем связь между движком и файлом шаблона
     * <br>3. Устанавливаем флаг на компиляции во время выполнения шаблона
     * <br>4. Возвращаем движок обработки шаблонов
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /**
     * 1. Создаем разрешитель представления
     * <br>2. Передаем разрешителю движок
     * <br>3. Устанавливаем кодирувку "UTF-8"
     * <br>4. Регистрируем разрешитель в реестре предствалений
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        registry.viewResolver(resolver);
    }




}