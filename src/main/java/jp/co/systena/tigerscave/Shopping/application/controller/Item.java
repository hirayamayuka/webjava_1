package jp.co.systena.tigerscave.Shopping.application.controller;

public class Item
{
	// 名前
	private String name;
	private int price;


	//コンストラクタ
	public Item(String name, int price)
	{
		this.name = name;
		this.price = price;
	}

	/* setter
	 * public void setName(String name)
	 *  {
	 *  	this.name = name;
	 *  }
	 *  public void setPrice(int price)
	 *  {
	 *  	this.price = price;
	 *  }
	 *  */

  public String getName()
  {
	  return this.name;
  }
  public int getPrice()
  {
	  return this.price;
  }
}
