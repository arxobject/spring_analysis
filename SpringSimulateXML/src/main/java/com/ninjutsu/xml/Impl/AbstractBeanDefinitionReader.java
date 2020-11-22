package com.ninjutsu.xml.Impl;

import com.ninjutsu.xml.Interface.BeanDefinitionReader;
import com.sun.istack.internal.Nullable;

public class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    @Nullable
    private ClassLoader beanClassLoader;

    @Override
    public int loadBeanDefinitions(String location) {
        return 0;
    }

    @Override
    public int loadBeanDefinitions(String... locations) {
        return 0;
    }
}
