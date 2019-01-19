package jp.co.systena.tigerscave.Shopping.application.controller;

import java.util.ArrayList;
import java.util.List;

// ListServiceと似てる
// 箱詰めする 注文した情報を格納するリストの作成
public class Cart
{
	private List<Order> orderlist = new ArrayList<Order>();

	public void setOrderList(Order order)
	{
		this.orderlist.add(order);
	}

	public List<Order> getOrderList()
	{
		return orderlist;
	}
}

//- ordarList : List<Order>
