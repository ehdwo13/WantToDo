package user;

public class User {
	
	private String id;
	private String nickName;
	private String password;
	
	
	public User() {}
	
	public User(String id, String nickName, String password) {
		this.id = id;
		this.nickName = nickName;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", nickName=" + nickName + ", password=" + password + "]";
	}
}
