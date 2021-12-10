package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
	
	public StringProperty website,name=null,pass=null;
	public Data(String name,String pass,String website){
		this.name=new SimpleStringProperty(name);
		this.pass=new SimpleStringProperty(pass);
		this.website=new SimpleStringProperty(website);		
	}
	
	public String getName(){return name.get();}

	public String getPass(){return pass.get();} 

	public void setName(String value) {name.set(value);}
	
	public String getWebsite(){return website.get();} 

	public void setWebsite(String value) {website.set(value);}
	
	public void setPass(String value){pass.set(value);}

	public StringProperty nameProperty() {return name;}
	public StringProperty websiteProperty() {return website;}
	public StringProperty passProperty() {return pass;}
}
