package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Location;

public class LocationDOM {
	private String pathFile="C:\\Users\\Daniel Aguilar\\Documents\\workSpace2017\\DACUnidad2\\src\\data\\locations.XML";
	public void add(Location data) {
		try {
			
			Document document = DOMHelper.getDocument(pathFile);
			
			Element locations = document.getDocumentElement();
			
			//Create location tag
			Element location = document.createElement("location");
			
			//Create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			location.appendChild(id);
		
			
			//Create parentId tag 
			Element parentId = document.createElement("parentId");
			parentId.appendChild(document.createTextNode(data.getParentId()));
			location.appendChild(parentId);
			
			//Create type tag
			Element type = document.createElement("type");
			type.appendChild(document.createTextNode(data.getType()));
			location.appendChild(type);
			
			//Create name tag
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			location.appendChild(name);
			
			//Create code tag
			Element code = document.createElement("code");
			code.appendChild(document.createTextNode(String.valueOf(data.getCode())));
			location.appendChild(code);
			
			locations.appendChild(location);
			
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		try{
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("location");
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Element location = (Element)nodeList.item(i);
				if(location.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					location.getParentNode().removeChild(location);
				}
			}
			
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Location data) {
		try{
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("location");
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Element location =(Element)nodeList.item(i);
				if(location.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					location.getElementsByTagName("parentId").item(0).setTextContent(data.getParentId());
					location.getElementsByTagName("type").item(0).setTextContent(data.getType());
					location.getElementsByTagName("name").item(0).setTextContent(data.getName());
					location.getElementsByTagName("code").item(0).setTextContent(String.valueOf(data.getCode()));
				}
			}
			
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Location findById(String id){
		Location location = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("location");
			
			for(int i=0; i<nodeList.getLength(); i++){
				Element l = (Element)nodeList.item(i);
				if(l.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					location = new Location();
					location.setId(id);
					location.setParentId(l.getElementsByTagName("parentId").item(0).getTextContent());
					location.setType(l.getElementsByTagName("type").item(0).getTextContent());
					location.setName(l.getElementsByTagName("name").item(0).getTextContent());
					location.setCode(Integer.parseInt(l.getElementsByTagName("code").item(0).getTextContent()));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	
	public List<Location> getLocations(){
		List<Location> locations = new ArrayList<Location>();
		
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("location");
		
		for(int i=0; i<nodeList.getLength(); i++) {
			Element l = (Element)nodeList.item(i);
			Location location = new Location();
			
			location.setId(l.getElementsByTagName("id")
					.item(0).getTextContent());
			
			location.setParentId(l.getElementsByTagName("parentId").item(0).getTextContent());
			location.setType(l.getElementsByTagName("type").item(0).getTextContent());
			location.setName(l.getElementsByTagName("name").item(0).getTextContent());
			location.setCode(Integer.parseInt(l.getElementsByTagName("code").item(0).getTextContent()));
			locations.add(location);
		}
		
		
		return locations;
	}
	
	
}
