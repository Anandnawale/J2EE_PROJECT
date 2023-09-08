package com.jspiders.springcore.bean;

import java.util.List;

import lombok.Data;

@Data
public class TeamBean {

	int id;
	String name;
	List<PlayerBean> player;
}
