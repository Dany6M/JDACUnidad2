package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Acto;

public class ActoDOM {
	private String pathFile="C:\\Users\\Daniel Aguilar\\Documents\\workSpace2017\\DACUnidad2\\src\\data\\actos.xml";
	public void add(Acto data) {
		try {
			Document document =
					DOMHelper.getDocument(
							pathFile);
			
			Element actos = document.getDocumentElement();
			//Crear acto tag
			Element acto = document.createElement("acto");
			
			// Create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			acto.appendChild(id);
			
			//Create fecha tag
			Element fecha= document.createElement("fecha");
			fecha.appendChild(document.createTextNode(data.getFecha()));
			acto.appendChild(fecha);
			
			//Create codigo tag
			Element codigo = document.createElement("codigo");
			codigo.appendChild(document.createTextNode(String.valueOf(data.getCodigo())));
			acto.appendChild(codigo);
			
			//Create lugar tag
			Element lugar = document.createElement("lugar");
			lugar.appendChild(document.createTextNode(data.getLugar()));
			acto.appendChild(lugar);
			
			//Create descripcion tag
			Element descripcion = document.createElement("descripcion");
			descripcion.appendChild(document.createTextNode(data.getDescripcion()));
			acto.appendChild(descripcion);
			
			actos.appendChild(acto);
			
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("acto");
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Element acto = (Element)nodeList.item(i);
				if(acto.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					acto.getParentNode().removeChild(acto);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Acto data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("acto");
			for(int i=0; i<nodeList.getLength(); i++) {
				Element acto =(Element)nodeList.item(i);
				if(acto.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					acto.getElementsByTagName("fecha").item(0).setTextContent(data.getFecha());
					acto.getElementsByTagName("codigo").item(0).setTextContent(String.valueOf(data.getCodigo()));
					acto.getElementsByTagName("lugar").item(0).setTextContent(data.getLugar());
					acto.getElementsByTagName("descripcion").item(0).setTextContent(data.getDescripcion());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Acto findById(String id){
		Acto acto = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("acto");
			for(int i=0; i<nodeList.getLength(); i++) {
				Element a=(Element)nodeList.item(i);
				if(a.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					acto= new Acto();
					acto.setId(id);
					acto.setFecha(a.getElementsByTagName("fecha").item(0).getTextContent());
					acto.setCodigo(Integer.parseInt(a.getElementsByTagName("codigo").item(0).getTextContent()));
					acto.setLugar(a.getElementsByTagName("lugar").item(0).getTextContent());
					acto.setDescripcion(a.getElementsByTagName("descripcion").item(0).getTextContent());
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return acto;
	}
	
	public List<Acto> getActos(){
		List<Acto> actos= new ArrayList<Acto>();
		
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("acto");
		
		for(int i=0; i<nodeList.getLength(); i++) {
			Element a= (Element)nodeList.item(i);
			Acto acto = new Acto();
			
			acto.setId(a.getElementsByTagName("id").item(0).getTextContent());
			acto.setFecha(a.getElementsByTagName("fecha").item(0).getTextContent());
			acto.setCodigo(Integer.parseInt(a.getElementsByTagName("codigo").item(0).getTextContent()));
			acto.setLugar(a.getElementsByTagName("lugar").item(0).getTextContent());
			acto.setDescripcion(a.getElementsByTagName("descripcion").item(0).getTextContent());
			actos.add(acto);
		}
		return actos;
	}
	

}
