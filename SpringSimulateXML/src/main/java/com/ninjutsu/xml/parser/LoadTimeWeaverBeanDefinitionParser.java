package com.ninjutsu.xml.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class LoadTimeWeaverBeanDefinitionParser extends AbstractPropertyLoadingBeanDefinitionParser {

    private static final String WEAVER_CLASS_ATTRIBUTE = "weaver-class";

    private static final String ASPECTJ_WEAVING_ATTRIBUTE = "aspectj-weaving";

    public Logger logger = LoggerFactory.getLogger(PropertyOverrideBeanDefinitionParser.class);
    @Override
    protected void doParse(Element element) {
        super.doParse(element);

        if (element.hasAttribute(WEAVER_CLASS_ATTRIBUTE)) {
            logger.info("weaver-class"+element.getAttribute(WEAVER_CLASS_ATTRIBUTE));
        }

        if (element.hasAttribute(ASPECTJ_WEAVING_ATTRIBUTE)) {
            logger.info(element.getAttribute(ASPECTJ_WEAVING_ATTRIBUTE));
        }
    }
}
