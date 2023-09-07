package com.jspiders.design_pattern.main;

import com.jspiders.design_pattern.structural.Adapter;

public class AdapterMain {

	public static void main(String[] args) {

		Adapter adapter = new Adapter();
		adapter.womensDay(adapter);
		adapter.mensDay(adapter);

	}

}