package projectXmlDom;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class parseUsingDomXmlAdditional extends parseUsingDomXml {
	
	static Document doc;
	
	public static void main(String[] args) {
		
		doc = parseUsingDomXml.parserXml();
		addXmlData(doc);
		parseUsingDomXml.printResult(doc);
	
	}
	
	public static void addXmlData(Document doc) {
		 String firstName = "firstname";
		 String lastName = "lastname";
		 String dateBirth = "born";
		 String dateDeath = "deceased";
		
		Node test = doc.getDocumentElement().getChildNodes().item(0); 
		NodeList nodeList = doc.getElementsByTagName("person");
	
		Text newBirthText = doc.createTextNode("1978");
		Attr newAttributeBirth = doc.createAttribute(dateBirth);
		newAttributeBirth.appendChild(newBirthText);
		lastNode.appendChild(newAttributeBirth);
		
		Text newDeathText = doc.createTextNode("2012");
		Attr newAttributeDeath = doc.createAttribute(dateDeath);
		newAttributeDeath.appendChild(newDeathText);
		lastNode.appendChild(newAttributeDeath);
		
		Text newFirstNameText = doc.createTextNode("Ali");
		Element newFirstNameElement = doc.createElement(firstName);
		newFirstNameElement.appendChild(newFirstNameText);
		lastNode.appendChild(newFirstNameElement);
		
		Text newLastNameText = doc.createTextNode("Baba");
		Element newLastNameElement = doc.createElement(lastName);
		newLastNameElement.appendChild(newLastNameText);
		lastNode.appendChild(newLastNameElement);
		
	}
	
}
