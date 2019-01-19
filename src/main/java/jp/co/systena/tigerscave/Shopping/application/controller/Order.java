package jp.co.systena.tigerscave.Shopping.application.controller;

public class Order {

	// Itemクラスと似てる
	// 名前
	private Item item;
	private int num;

	// setter
	public void setItem(Item item)
	{
		this.item = item;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public Item getItem()
	{
		return this.item;
	}

	public int getNum()
	{
		return this.num;
	}
}
