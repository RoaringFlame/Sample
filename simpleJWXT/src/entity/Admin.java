package entity;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields


	private static final long serialVersionUID = 1L;
	
	private Integer aid;
	private Integer ano;
	private String password;
	private String name;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer aid, Integer ano, String password) {
		this.aid = aid;
		this.ano = ano;
		this.password = password;
	}

	/** full constructor */
	public Admin(Integer aid, Integer ano, String password, String name) {
		this.aid = aid;
		this.ano = ano;
		this.password = password;
		this.name = name;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}