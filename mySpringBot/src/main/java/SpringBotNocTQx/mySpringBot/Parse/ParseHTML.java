package SpringBotNocTQx.mySpringBot.Parse;

import SpringBotNocTQx.mySpringBot.Service.SendMessageService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParseHTML {
   public String parseWiki() throws IOException {

		int N = SendMessageService.random.nextInt(250);
		Document list = Jsoup.connect("https://ru.wikipedia.org/wiki/250_%D0%BB%D1%83%D1%87%D1%88%D0%B8%D1%85_%D1%84%D0%B8%D0%BB%D1%8C%D0%BC%D0%BE%D0%B2_%D0%BF%D0%BE_%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D0%B8_IMDb").get();
		Elements rows = list.select("tr");
		Element row = rows.get(N);
		Elements columns = row.select("td");
		return columns.get(1).text() + ", " + columns.get(2).text() + ", " + columns.get(3).text() + ", " + columns.get(4).text();
	}
}

