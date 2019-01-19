package jp.co.systena.tigerscave.Shopping.application.controller;

public class ListForm
{
	// 名前
	// 型の名前はListView.htmlの"name"と同じにする
	  private String name;
	  private int price;
	  private int num;

	  //setter
	  public void setName(String name)
	  {
	    this.name = name;
	  }

	  public void setPrice(int price)
	  {
		  this.price = price;
	  }

	  public void setNum(int num)
	  {
		  this.num = num;
	  }

	  //getter
	  public String getName()
	  {
		  return this.name;
	  }

	  public int getPrice()
	  {
		  return this.price;
	  }

	  public int getNum()
	  {
		  return this.num;
	  }
}
