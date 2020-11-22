package com.ninjutsu.xml.Interface;

public interface BeanDefinitionReader {
    int loadBeanDefinitions(String location);
    int loadBeanDefinitions(String... locations);
}
