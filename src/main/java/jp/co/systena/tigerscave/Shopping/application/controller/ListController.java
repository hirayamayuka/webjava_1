package jp.co.systena.tigerscave.Shopping.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // Viewあり。Viewを返却するアノテーション
public class ListController
{
	// Sessionの定義
	@Autowired
	HttpSession session; // セッション管理


	//@RequestMapping("/Shopping") // URLとのマッピング
	@RequestMapping(value="/Shopping", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView show(ModelAndView mav)
	{
		// 商品一覧の作成
		ListService listservice = new ListService();

		// 商品の作成
		Item fish01 = new Item("しめさば",120);
		Item fish02 = new Item("サーモン",300);
		Item fish03 = new Item("マグロ",230);
		Item fish04 = new Item("あじ",100);

		// 商品一覧にセット
		listservice.setitemList(fish01);
		listservice.setitemList(fish02);
		listservice.setitemList(fish03);
		listservice.setitemList(fish04);

		// 商品一覧の取得
		List<Item> fishlist = listservice.getItemList();

		// mavに商品一覧情報を設定する
		mav.addObject("fishlist",fishlist);

		// htmlでの入力を受け取るクラスをインスタンス化
		ListForm listform = new ListForm();
		mav.addObject("ListForm",listform);

		// sessionからカートを取得する
		Cart carts = (Cart)session.getAttribute("cart");

		// カートの中がnullではなかったら、カートの中をmavに追加
		if(carts != null)
		{
			mav.addObject("cartlist",carts.getOrderList());
		}

		// mavにテンプレート名「ListVieｗ」を設定する
		mav.setViewName("ListView");
		return mav;
	}
	// sessionに入れる
	@RequestMapping(value="/Shopping", method = RequestMethod.POST)  // URLとのマッピング
	public ModelAndView order(ModelAndView mav, @Valid ListForm listform, BindingResult bindingResult, HttpServletRequest request)
	{
		// Sessionからカートを取得する
		// List<Order> orders = (List<Order>)session.getAttribute("orderlist");
		 Cart carts = (Cart)session.getAttribute("cart");

		// 取得できなかった場合、新規のカートを作成する
		 if( carts == null)
		 {
			 Cart cart = new Cart();
			 session.setAttribute("cart", cart);

			 // cartsに代入
			 carts = cart;
		 }

		 // 入力から注文内容を取得する
		 String name = listform.getName();
		 int price = listform.getPrice();
		 int num = listform.getNum();

		 // 合計金額
		 int select_price = price * num;

		 if (session.getAttribute("total") == null)
		 {
			Object total = new Integer(select_price);
			session.setAttribute("total" , total);
		 }

		 else
		 {
			Object total01 = session.getAttribute("total");
			String totalStr = total01.toString();
			int total_price = new Integer(totalStr);
			total_price = total_price + select_price;
			Object total02 = new Integer(total_price);
		 	session.setAttribute("total" , total02);
		 }

		 Item item = new Item(name,price);

		 Order order = new Order();
		 order.setItem(item);
		 order.setNum(num);

		 // 注文内容をカートに追加する
		 carts.setOrderList(order);

		 // セッションにカート情報をセットする
		 session.setAttribute("cart", carts);

		 // 一覧表示へリダイレクト
		 return new ModelAndView("redirect:/Shopping");
	}

}
