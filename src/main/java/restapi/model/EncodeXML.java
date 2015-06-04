package restapi.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

import restapi.dao.User;
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class EncodeXML {
	
	private int UserID;
	private String FirstName;
	private String LastName;
	private String Email;
	
	
	private EncodeXML(){}
	public EncodeXML(User user){
		this.Email =user.getEmail();
		this.FirstName = user.getFirstName();
		this.LastName = user.getLastName();
		this.UserID =user.getUserID();
		
	}
	public int getUserID(){
		return UserID;
	}
	public String getFirstName(){
		return FirstName;
	}
	public String getLastName(){
		return LastName;
	}
	public String getEmail(){
		return Email;
	}
	
	
	@XmlElement
	public void setUserID(int UserID){
		this.UserID = UserID;
	}
	
	@XmlElement
	public void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}
	
	@XmlElement
	public void setLastName(String LastName){
		this.LastName = LastName;
	}
	
	@XmlElement
	public void setEmail(String Email){
		this.Email = Email;
	}
}
