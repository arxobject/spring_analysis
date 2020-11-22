package com.ninjutsu.xml.parser;

import com.ninjutsu.xml.Interface.BeanDefinitionParser;
import com.ninjutsu.xml.context.ParserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class ComponentScanBeanDefinitionParser implements BeanDefinitionParser {

    private static final String BASE_PACKAGE_ATTRIBUTE = "base-package";

    private static final String RESOURCE_PATTERN_ATTRIBUTE = "resource-pattern";

    private static final String USE_DEFAULT_FILTERS_ATTRIBUTE = "use-default-filters";

    private static final String ANNOTATION_CONFIG_ATTRIBUTE = "annotation-config";

    private static final String NAME_GENERATOR_ATTRIBUTE = "name-generator";

    private static final String SCOPE_RESOLVER_ATTRIBUTE = "scope-resolver";

    private static final String SCOPED_PROXY_ATTRIBUTE = "scoped-proxy";

    private static final String EXCLUDE_FILTER_ELEMENT = "exclude-filter";

    private static final String INCLUDE_FILTER_ELEMENT = "include-filter";

    private static final String FILTER_TYPE_ATTRIBUTE = "type";

    private static final String FILTER_EXPRESSION_ATTRIBUTE = "expression";

    public Logger logger = LoggerFactory.getLogger(ComponentScanBeanDefinitionParser.class);

    @Override
    public void parse(Element element, ParserContext parserContext) {
        String basePackage = element.getAttribute(BASE_PACKAGE_ATTRIBUTE);
        logger.info("basePackage : "+basePackage);

        if (element.hasAttribute(RESOURCE_PATTERN_ATTRIBUTE)) {
            logger.info(element.getAttribute(RESOURCE_PATTERN_ATTRIBUTE));
        }
    }
}
