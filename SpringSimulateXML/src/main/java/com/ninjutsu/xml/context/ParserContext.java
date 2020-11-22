package com.ninjutsu.xml.context;

import com.ninjutsu.xml.Delegate.BeanDefinitionParserDelegate;

public final class ParserContext {
    private final BeanDefinitionParserDelegate delegate;

    public ParserContext(BeanDefinitionParserDelegate dele){
        delegate = dele;
    }

    public final BeanDefinitionParserDelegate getDelegate() {
        return this.delegate;
    }
}
