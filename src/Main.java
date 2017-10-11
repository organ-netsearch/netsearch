import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//问问
		/*String pageurl = "http://wenda.so.com/c/16?filt=1000&pn=1";
		try {
			Document doc = Jsoup.connect(pageurl)
			.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
			.timeout(10000)
			.get();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//百度知道
		String pageurl = "https://zhidao.baidu.com/list?cid=110104&rn=30&pn=0&ie=utf8&_pjax=#j-question-list-pjax-container";
		try {
			Document doc = Jsoup.connect(pageurl)
			.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
			.header("Host", "zhidao.baidu.com")
//			.header("X-PJAX", "true")
			.header("X-PJAX-Container", "#j-question-list-pjax-container")
			.header("Referer", "https://zhidao.baidu.com/list?cid=110104&rn=30&pn=120&ie=utf8&_pjax=%23j-question-list-pjax-container")
			.header("cookie", "BAIDUID=E72426E71C0AA4837D20AF977996565F:FG=1; BIDUPSID=E72426E71C0AA4837D20AF977996565F; PSTM=1507643792; H_PS_PSSID=1442_21095_17001_20927;BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; PSINO=3; Hm_lvt_6859ce5aaf00fb00387e6434e4fcc925=1507644612;Hm_lpvt_6859ce5aaf00fb00387e6434e4fcc925=1507644651; IK_E72426E71C0AA4837D20AF977996565F=1; IK_CID_74=1")
			.timeout(10000)
			.get();
			Elements list= doc.getElementsByClass("question-list-item");
//			System.out.println(list.size());
			for(Element el : list)
			{
//				System.out.println(el);
//				System.out.println("==========");
				Element infoDiv = el.getElementsByClass("question-info").get(0);
				//获得回答数量
				String numStr =infoDiv.getElementsByClass("answer-num").get(0).text().split(" ")[0];
//				System.out.println(numStr);
				int ansuerNum = Integer.parseInt(numStr);
				if(ansuerNum >0)
				{
					//发送查看详情请求
					Element titleDiv =el.getElementsByClass("question-title").get(0);
					Element titleA = titleDiv.getElementsByTag("a").get(0);
					String detailurl = titleA.attr("href");
					System.out.println("详细url："+detailurl);
					Document detailDoc = Jsoup.connect(detailurl)
							.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
							.header("Host", "zhidao.baidu.com")
//        					.header("X-PJAX", "true")
//							.header("X-PJAX-Container", "#j-question-list-pjax-container")
							.header("Referer", "https://zhidao.baidu.com/list?cid=110104&rn=30&pn=0&ie=utf8&_pjax=")
							.header("cookie", "BAIDUID=E72426E71C0AA4837D20AF977996565F:FG=1; BIDUPSID=E72426E71C0AA4837D20AF977996565F; PSTM=1507643792; H_PS_PSSID=1442_21095_17001_20927;BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; PSINO=3; Hm_lvt_6859ce5aaf00fb00387e6434e4fcc925=1507644612;Hm_lpvt_6859ce5aaf00fb00387e6434e4fcc925=1507644651; IK_E72426E71C0AA4837D20AF977996565F=1; IK_CID_74=1")
							.timeout(10000)
							.get();
					System.out.println(detailDoc);
					break;
//					String title =titleDiv.getElementsByTag("a").get(0).text();
//					System.out.println(title);

				}
				

//				System.out.println(titleDiv);
//				System.out.println("==========");

//				break;
			}
//			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		//新浪问问
		pageurl = "http://iask.sina.com.cn/c/88-all-1-new.html";
		try {
			Document doc = Jsoup.connect(pageurl)
			.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
			.header("Referer", "http://iask.sina.com.cn")
			.header("Host", "iask.sina.com.cn")
			.timeout(10000)
			.get();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
