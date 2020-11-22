import com.ninjutsu.xml.Impl.DefaultBeanDefinitionDocumentReader;
import com.ninjutsu.xml.Impl.XmlBeanDefinitionReader;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlTest1 {
    @Test
    public void test1() throws ParserConfigurationException, IOException, SAXException {
        InputSource resource = new InputSource(getClass().getResourceAsStream("bean2.xml"));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        // 创建一个DocumentBuilder实例
        DocumentBuilder builder = factory.newDocumentBuilder();

        // 创建一个解析XML的Document实例
        Document doc = builder.parse(resource);

        DefaultBeanDefinitionDocumentReader reader = new DefaultBeanDefinitionDocumentReader();
        reader.registerBeanDefinitions(doc,null);

    }
}
