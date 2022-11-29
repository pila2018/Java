import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunnerXMLParser {
    static List<SiteMap> mapList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src\\files\\xml.xml"));
        NodeList elements = doc.getDocumentElement().getElementsByTagName("url");
        for (int i = 0; i < elements.getLength(); i++) {
            List<String> tmp = new ArrayList<>();
            NodeList nodeList = elements.item(i).getChildNodes();
            for (int i1 = 0; i1 < nodeList.getLength(); i1++) {
                if (nodeList.item(i1) instanceof Element) {
                    tmp.add(nodeList.item(i1).getTextContent());
                    System.out.println(nodeList.item(i1).getNodeName() + " " + nodeList.item(i1).getTextContent());
                }
            }
            mapList.add(new SiteMap(tmp.get(0), tmp.get(1), Float.parseFloat(tmp.get(2))));
        }

        for (var s : mapList) {
            System.out.println(s.toString());
        }
    }
}
