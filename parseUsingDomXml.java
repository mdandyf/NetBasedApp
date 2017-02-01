package projectXmlDom;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class parseUsingDomXml {
	
	 static Element childNode;
	 static Document docFile = null;
	 	
	 public static void main(String[] args) {
		 
		 // Build XML Parser
		 docFile = parserXml();
		 
		 // Show the Result
		 printResult(docFile);
		
	 }
	 
	 public static Document parserXml() {
		 // Input FileName
		 File file = new File("scientists.xml");
		 
		 // Build XML Parser Factory
		 DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		 parserFactory.setNamespaceAware(false);
		 parserFactory.setValidating(false);
		 parserFactory.setIgnoringElementContentWhitespace(true);
		 
		 
		 try {
			 DocumentBuilder parser = parserFactory.newDocumentBuilder();
			 Document doc = parser.parse(file);
			 doc.getDocumentElement().normalize();
			 docFile = doc;
			 
		} 
		 catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			printing("Error in Parser Configuration");
			e.printStackTrace();
		}
		 
		 return docFile;
	 }
	 
	 public static void printResult(Document doc) {
		 
		 // String of the XML Tags Name
		 String firstName = "firstname";
		 String lastName = "lastname";
		 String dateBirth = "born";
		 String dateDeath = "deceased";
		 String jobs = "job";
		 
		 printing("Root Node: " + doc.getDocumentElement().getNodeName());
		 
		 NodeList nodeList = doc.getElementsByTagName("person");
		 
		 // Loop on each child node
		 for(int i = 0; i < nodeList.getLength(); i++) {
			 Node personNode = nodeList.item(i);
			 if(personNode.getNodeType() == Node.ELEMENT_NODE) {
				 childNode = (Element) personNode;
				 System.out.println("\nFirst Name: " + childNode.getElementsByTagName(firstName).item(0).getTextContent().trim());
				 System.out.println("Last Name: " + childNode.getElementsByTagName(lastName).item(0).getTextContent().trim());
				 System.out.println("Birth: " + childNode.getAttribute(dateBirth));
				 System.out.println("Death: " + childNode.getAttribute(dateDeath));
				 System.out.println("Jobs: " + childNode.getElementsByTagName(jobs).item(0).getTextContent().trim());
			 }
		 }
	 }
	 
	 public static void printing(String input) {
		 System.out.println(input);
	 }

}
