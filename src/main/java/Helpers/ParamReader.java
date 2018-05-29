package Helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

//Класс для чтения параметров
public class ParamReader {

    private final String folder = "";

    private final static String parametersFile = ".//Parameters//parameters.xml";
    public final static String users = ".//Parameters//users.xml";
    public final static String general = ".//Parameters//general.xml";

    //private static XPathExpression expr = NULL;
    private static XPath xpath = null;
    private static Document doc = null;

    private static void initParamReader(String file) {
        //String value;// = NULL;

        try {
            final File xmlFile = new File(file);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(xmlFile);

            doc.getDocumentElement();

            XPathFactory pathFactory = XPathFactory.newInstance();
            xpath = pathFactory.newXPath();

        }   catch (ParserConfigurationException | SAXException |  IOException ex) {
                Logger.getLogger(ParamReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static HashMap<String, String> getMapByXpath(String parameterFile, String path){
        initParamReader(parameterFile);
        HashMap<String, String> map = new HashMap<String, String>();

        try {
            XPathExpression expr = xpath.compile(path);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i=0; i<nodeList.getLength(); i++){
                //.add(nodeList.item(i).getTextContent());
                map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getParameterByXpath(String parameterFile, String path){
        initParamReader(parameterFile);

        String value = null;

        try {
            XPathExpression expr = xpath.compile(path);
            Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
            value = node.getNodeValue();

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static ArrayList<String> getParameterListByXpath(String file, String x){
        ArrayList<String> list = new ArrayList<String>(){};
        initParamReader(file);
        try {
            XPathExpression expr = xpath.compile(x);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i=0; i<nodeList.getLength(); i++){
                list.add(nodeList.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> getListWithTableColumnNames(String tableName) {
        ArrayList<String> list = new ArrayList<String>();

        initParamReader(parametersFile);
        String x = "//DataTable[@name='" + tableName + "']/Parameter[@name='ColumnName']";

        try {
            XPathExpression expr = xpath.compile(x);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i=0; i<nodeList.getLength(); i++){
                list.add(nodeList.item(i).getTextContent());
            }
                //System.out.println("Parameter #" + i + ": " + nodeList.item(i).getTextContent());


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return list;
    }


}
