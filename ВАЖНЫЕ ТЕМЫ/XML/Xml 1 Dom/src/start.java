import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class start {
    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("my.xml"));

        Element element = document.getDocumentElement();
        printElements(element.getChildNodes(), 0);  // выводит все теги


//        System.out.println(element.getTagName());
//        NodeList nodeList = element.getChildNodes();
//        for(int i =0; i < nodeList.getLength(); i++){
//            if(nodeList.item(i) instanceof  Element){
//                System.out.println( ((Element) nodeList.item(i)).getTagName());
//            }
//        }
    }

    static void printElements(NodeList nodeList, int tabs){
        for(int i =0; i < nodeList.getLength(); i++){
            if(nodeList.item(i) instanceof Element){
                // для текстовых значений
                String value = "";
                if(!nodeList.item(i).getTextContent().trim().isEmpty() && !((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty() &&
                        !((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n")){  // провекрка на то что там именно текст
                    Text text = (Text)nodeList.item(i).getFirstChild();
                    value += " = " + text.getData().trim();
                }
                System.out.println(getTab(tabs) + nodeList.item(i).getNodeName() + value);

                System.out.println( getTab(tabs) + ((Element) nodeList.item(i)).getTagName());
                if(((Element) nodeList.item(i)).hasAttribute("name")){  // парсим атрибуты
                    System.out.println(((Element) nodeList.item(i)).getAttribute("name"));
                }
                if(nodeList.item(i).hasChildNodes()){
                    printElements(nodeList.item(i).getChildNodes(), ++tabs);
                }
            }
        }
    }

    static String getTab(int tabs){
        String str = "";
        for(int i =0; i < tabs; i++){
            str +="\t";
        }
        return str;
    }
}
