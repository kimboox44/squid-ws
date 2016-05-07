package com.bkhaled.squidws.client.modal;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private int age;
	private String password;
	private String creationDate;
	private String ipAddress;
        private String type;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

        
        
	public String getIpAdress() {
		return ipAddress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAddress = ipAdress;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String string) {
		this.creationDate = string;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
