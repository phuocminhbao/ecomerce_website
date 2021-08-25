package EcomerceWebsite.Entity;

public class Users {
	private long id;
	private String user;
	private String password;
	private String displayName;
	private String address;
	
	
	
	public Users() {
		
	}
	
	
	// Constructor for unit test
	public Users(long id, String user, String password, String displayName, String address) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.displayName = displayName;
		this.address = address;
	}



	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
