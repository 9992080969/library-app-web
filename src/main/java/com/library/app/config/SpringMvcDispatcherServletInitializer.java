package com.library.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Настройка и инициализация диспетчера сервлета в веб-приложении
 *
 * @author Alexey Voronov on 01.07.2023
 */
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Для определения классов конфигурации, загружаемые в корневой контекст Spring приложения.
     * @return Массив классов конфигурации для корневого контекста Spring.
     * <br> <span style="font-weight: bold; font-style: italic; color: yellow;">null</span>,
     * если вы не хотите использовать корневой контекст,
     * и все классы конфигурации должны быть загружены в контекст диспетчера сервлета.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * Для определения классов конфигурации, которые будут загружены в контекст диспетчера сервлета
     * @return Массив классов конфигурации, которые содержит классы конфигурации, связанные с контекстом
     * диспетчера сервлета
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * Для определения URL-шаблонов, по которым сервлет будет обрабатывать запросы
     * @return Массив строк, в котором указываются URL-шаблоны для маппинга сервлета.
     * Обычно эти шаблоны представляют пути или расширения URL.
     */
    @Override
    public String[] getServletMappings() {
        return new String[]{"/"};
    }
}