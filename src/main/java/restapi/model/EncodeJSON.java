package restapi.model;

public class EncodeJSON {

	private Object key;
	private Object val;
	
	public EncodeJSON(Object key,Object val){
		this.key =key;
		this.val =val;
		
	}
	public void setStatus(Object key){
		this.key =key;
	}
	
	public void setResponse(Object val){
		this.val =val;
	}
	
	public Object getStatus(){
		return key;
	}
	
	public Object getResponse(){
		return val;
	}
}
