package jp.co.systena.tigerscave.Shopping.application.controller;

import java.util.ArrayList;
import java.util.List;

public class ListService
{
	private List<Item> itemlist = new ArrayList<Item>();

	public void setitemList(Item item)
	{
		this.itemlist.add(item);
	}

	public List<Item> getItemList()
	{
		return itemlist;
	}
}
