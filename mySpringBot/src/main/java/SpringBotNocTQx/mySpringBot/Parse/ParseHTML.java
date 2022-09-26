package SpringBotNocTQx.mySpringBot.Parse;

import SpringBotNocTQx.mySpringBot.LocalConstant.FilmGenreEnum;
import SpringBotNocTQx.mySpringBot.LocalConstant.LocalStrings;
import SpringBotNocTQx.mySpringBot.Service.SendMessageService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParseHTML {
	 private Map<FilmGenreEnum, Object[]> GenerateCollection(){

		 Map<FilmGenreEnum, Object[]> linksCollection = new HashMap<>();
			 linksCollection.put(FilmGenreEnum.BEST, new Object[]{LocalStrings.linkBEST, 250});
			 linksCollection.put(FilmGenreEnum.COMEDY, new Object[]{LocalStrings.linkCOMEDY, 250});
			 linksCollection.put(FilmGenreEnum.FANTASY, new Object[]{LocalStrings.linkFANTASY, 250});
			 linksCollection.put(FilmGenreEnum.LAWYERS, new Object[]{LocalStrings.linkLAWYERS, 250});
			 linksCollection.put(FilmGenreEnum.DETECTIVES, new Object[]{LocalStrings.linkDETECTIVES, 250});
			 linksCollection.put(FilmGenreEnum.LOVE, new Object[]{LocalStrings.linkLOVE, 250});
			 linksCollection.put(FilmGenreEnum.HORRORS, new Object[]{LocalStrings.linkHORRORS, 250});
			 linksCollection.put(FilmGenreEnum.DRAMAS, new Object[]{LocalStrings.linkDRAMAS, 250});

		 return linksCollection;
	 }

	public String parseWikiBest(String urlLink, int filmNum) throws IOException {

		int N = SendMessageService.random.nextInt(filmNum);
		Document list = Jsoup.connect(urlLink).get();
		Elements rows = list.select("tr");
		Element row = rows.get(N);
		Elements columns = row.select("td");
		return columns.get(1).text() + ", " + columns.get(2).text() + ", \n" + columns.get(4).text();
	}

	public String parseCategoryFilm(String urlLink, int filmNum) throws IOException{

		int N = SendMessageService.random.nextInt(filmNum);
		Document list = Jsoup.connect(urlLink).get();
		Elements rows = list.select("div.film_list");
		Element row = rows.get(N);
		Elements columns = row.select("span");
		Elements col = row.select("strong");
		return col.text() + ", " + columns.get(2).text() + "\n" + columns.get(3).text() ;
	}
}

