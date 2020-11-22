package com.ninjutsu.xml.parser;

import com.ninjutsu.xml.context.ParserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class MBeanServerBeanDefinitionParser extends AbstractPropertyLoadingBeanDefinitionParser {
    private static final String MBEAN_SERVER_BEAN_NAME = "mbeanServer";

    private static final String AGENT_ID_ATTRIBUTE = "agent-id";

    public Logger logger = LoggerFactory.getLogger(MBeanServerBeanDefinitionParser.class);
    @Override
    public void parse(Element element, ParserContext parserContext) {
        super.doParse(element);

        if (element.hasAttribute(MBEAN_SERVER_BEAN_NAME)) {
            logger.info(MBEAN_SERVER_BEAN_NAME +" : "+element.getAttribute(MBEAN_SERVER_BEAN_NAME));
        }

        if (element.hasAttribute(AGENT_ID_ATTRIBUTE)) {
            logger.info(AGENT_ID_ATTRIBUTE+" : "+element.getAttribute(AGENT_ID_ATTRIBUTE));
        }
    }
}
