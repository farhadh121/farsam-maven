package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class RoleEntity implements Serializable {
	
	private Long roleID;
	private Timestamp version;
	private String name;
	private Set<UserEntity> users = new HashSet<UserEntity>();
	
	public Long getRoleID() {
		return roleID;
	}
	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
	public Timestamp getVersion() {
		return version;
	}
	public void setVersion(Timestamp version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
	public RoleEntity() {
	}
	
	
	
	

}
