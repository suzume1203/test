package tw.suzume.javabean;

import java.io.Serializable;
import java.util.LinkedList;

public class TestShoppongCartBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private LinkedList<String> list = new LinkedList<String>();
	private String submit = null;
	private String item = null;
	
	private void addItem(String pname) {
		list.add(pname);
	}
	
	private void removeItem(String pname) {
		list.remove(pname);
	}
	
	public void setItem(String pname) {
		item = pname;
	}
	
	public void setSubmit(String s) {
		submit = s;
	}
	
	public LinkedList<String> getItems() {
		return list;
	}
	
	public void processReq() {
		if (submit==null||submit.equals("add")) {
			addItem(item);
		}else if (submit.equals("delete")) {
			removeItem(item);
		}
		submit = null;
		item = null;
	}

}
