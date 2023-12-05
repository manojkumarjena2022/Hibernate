package com.mj.entity;

import javax.persistence.Column;

public class Product {
private Integer pid;
//@Column(name = "PNAME",length = 15,unique = true,nullable = false)
private String pname;
private float price;
private float qty;
private String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Integer getPid() {
	return pid;
}
//setters and getters (Alt+shift+s,r)
public void setPid(Integer pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public float getQty() {
	return qty;
}
public void setQty(float qty) {
	this.qty = qty;
}
//toString() (Alt+shift+s,s)
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
}

}
