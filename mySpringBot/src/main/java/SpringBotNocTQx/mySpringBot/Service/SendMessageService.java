package SpringBotNocTQx.mySpringBot.Service;

import SpringBotNocTQx.mySpringBot.Config.ButtonConfig;
import SpringBotNocTQx.mySpringBot.LocalConstant.FilmGenreEnum;
import SpringBotNocTQx.mySpringBot.LocalConstant.LocalStrings;
import SpringBotNocTQx.mySpringBot.LocalConstant.States;
import SpringBotNocTQx.mySpringBot.Parse.ParseHTML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
@Service
public class SendMessageService {

    public final ArrayList<ArrayList<String>> allPhrases = CreatingArray.CreateArray();
    public static final Random random = new Random();
    private final  ButtonConfig buttonConfig;
    private final ParseHTML parseHTML;

    @Autowired
    public SendMessageService(ButtonConfig buttonConfig, ParseHTML parseHTML) {
        this.buttonConfig = buttonConfig;
        this.parseHTML = parseHTML;
    }

    public synchronized SendMessage sendMsg(String message, Update up){

        long chatId = up.getMessage().getChatId();
        SendMessage sMsg = new SendMessage();
        sMsg.setText(message);
        sMsg.setChatId(String.valueOf(chatId));
        sMsg.enableMarkdown(true);
        return sMsg;
    }

    public synchronized Enum checkState(String message){

        if (message.equals(LocalStrings.START) || message.equals(LocalStrings.BEGIN)) return States.GREETING;
        if (message.equals(LocalStrings.END)) return States.FAREWELL;
        if (message.equals(LocalStrings.FILM)) return States.SEARCH_FILMS;
        if (message.equals(LocalStrings.ANIME)) return States.SEARCH_ANIME;
        if (message.equals(LocalStrings.PLAN)) return States.PLANNING_EDV;
        if (message.equals(LocalStrings.HELP_MENU)) return States.HELP;
        if (message.equals(LocalStrings.BEST)) return FilmGenreEnum.BEST;
        if (message.equals(LocalStrings.COMEDY)) return FilmGenreEnum.COMEDY;
        if (message.equals(LocalStrings.FANTASY)) return FilmGenreEnum.FANTASY;
        if (message.equals(LocalStrings.ABOUT_LOVE)) return FilmGenreEnum.LOVE;
        if (message.equals(LocalStrings.LAWYER)) return FilmGenreEnum.LAWYERS;
        if (message.equals(LocalStrings.DETECTIVE)) return FilmGenreEnum.DETECTIVES;
        if (message.equals(LocalStrings.HORROR)) return FilmGenreEnum.HORRORS;
        if (message.equals(LocalStrings.DRAMA)) return FilmGenreEnum.DRAMAS;
        return States.UNKNOWN;
    }
    public synchronized SendMessage createGreetingMsg(Update up){

        SendMessage sMsg = sendMsg(allPhrases.get(0).get(random.nextInt(11)), up);
        sMsg.setReplyMarkup(buttonConfig.Buttons());
        return sMsg;
    }
    public synchronized SendMessage createFarewellMsg(Update up){

        return sendMsg(allPhrases.get(1).get(random.nextInt(11)), up);
    }
    public synchronized SendMessage createFilmChoice(Update up){

        SendMessage sMsg = sendMsg(allPhrases.get(2).get(0), up);
        sMsg.setReplyMarkup(buttonConfig.FilmButtons());
        return sMsg;
    }
    public synchronized SendMessage createAnimeChoice(Update up) throws IOException {
        String link = ParseHTML.getLinksCollection().get(FilmGenreEnum.ANIME_)[0].toString();
        int num = (int) ParseHTML.getLinksCollection().get(FilmGenreEnum.ANIME_)[1];

        SendMessage sMsg = sendMsg(allPhrases.get(3).get(0) + parseHTML.parseCategoryFilm_Anime(link, num), up);
        return sMsg;
    }
    public synchronized SendMessage createPlans(Update up){
        //sMsg.setReplyMarkup(buttonConfig.Buttons());
        return sendMsg(allPhrases.get(5).get(0), up);
    }
    public synchronized SendMessage returnFilmName(Update up, FilmGenreEnum genre) throws IOException {

        String link = ParseHTML.getLinksCollection().get(genre)[0].toString();
        int num = (int) ParseHTML.getLinksCollection().get(genre)[1];
        SendMessage sMsg;
        if (genre.equals(FilmGenreEnum.BEST)){
            sMsg = sendMsg(parseHTML.parseWikiBest(link, num),up);
        } else {
            sMsg = sendMsg(parseHTML.parseCategoryFilm_Anime(link, num), up);
        }
        sMsg.setReplyMarkup(buttonConfig.FilmButtons());

        return sMsg;
    }
    public synchronized SendMessage createUnknownMessage(Update up){
        return sendMsg(LocalStrings.UNKNOWN_PH, up);
    }
}
