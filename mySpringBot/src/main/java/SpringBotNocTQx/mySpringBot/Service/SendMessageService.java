package SpringBotNocTQx.mySpringBot.Service;

import SpringBotNocTQx.mySpringBot.Config.ButtonConfig;
import SpringBotNocTQx.mySpringBot.LocalConstant.LocalStrings;
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
    public enum States {
        FAREWELL, FILM_GENRE, GREETING, HELP, PLANNING_EDV,
        SEARCH_ANIME, SEARCH_FILMS, UNKNOWN, WEATHER
    }

    public final ArrayList<ArrayList<String>> allPhrases = CreatingArray.CreateArray();
    public static final Random random = new Random();
    private final  ButtonConfig buttonConfig;
    private final ParseHTML parseHTML;
    private final LocalStrings localStringsEnums;

    @Autowired
    public SendMessageService(ButtonConfig buttonConfig, ParseHTML parseHTML, LocalStrings localStringsEnums) {
        this.buttonConfig = buttonConfig;
        this.parseHTML = parseHTML;
        this.localStringsEnums = localStringsEnums;
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

        if (message.equals(localStringsEnums.START)) return States.GREETING;
        if (message.equals(localStringsEnums.END)) return States.FAREWELL;
        if (message.equals(localStringsEnums.FILM)) return States.SEARCH_FILMS;
        if (message.equals(localStringsEnums.ANIME)) return States.SEARCH_ANIME;
        if (message.equals(localStringsEnums.PLAN)) return States.PLANNING_EDV;
        if (message.equals(localStringsEnums.HELP_MENU)) return States.HELP;
        if (message.equals(localStringsEnums.BEST)) return States.FILM_GENRE;
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
    public synchronized SendMessage createAnimeChoice(Update up){
        //sMsg.setReplyMarkup(buttonConfig.Buttons());
        return sendMsg(allPhrases.get(3).get(0), up);
    }
    public synchronized SendMessage createPlans(Update up){
        //sMsg.setReplyMarkup(buttonConfig.Buttons());
        return sendMsg(allPhrases.get(5).get(0), up);
    }
    public synchronized SendMessage returnFilmName(Update up) throws IOException {
        SendMessage sMsg = sendMsg(allPhrases.get(2).get(1) + parseHTML.parseWiki(), up);
        sMsg.setReplyMarkup(buttonConfig.FilmButtons());
        return sMsg;
    }
    public synchronized SendMessage createUnknownMessage(Update up){
        return sendMsg(localStringsEnums.UNKNOWN_PH, up);
    }
}
