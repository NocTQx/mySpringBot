package SpringBotNocTQx.mySpringBot.Core;

import SpringBotNocTQx.mySpringBot.LocalConstant.States;
import SpringBotNocTQx.mySpringBot.Service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


@ConfigurationProperties(prefix = "bot")
@Component
public class MyNocTQxBot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botName;

    @Value("${bot.key}")
    private String key;

    private final SendMessageService sMsg;

    @Autowired
    public MyNocTQxBot(SendMessageService sendMessage){
        this.sMsg = sendMessage;
    }

    @Override
    public void onUpdateReceived(Update up){
        if (up.hasMessage() && up.getMessage().hasText()){
            try {
                Enum state = sMsg.checkState(up.getMessage().getText().toLowerCase());
                if (States.GREETING.equals(state)) {
                    execute(sMsg.createGreetingMsg(up));
                } else if (States.FAREWELL.equals(state)) {
                    execute(sMsg.createFarewellMsg(up));
                } else if (States.SEARCH_FILMS.equals(state)) {
                    execute(sMsg.createFilmChoice(up));
                } else if (States.SEARCH_ANIME.equals(state)) {
                    execute(sMsg.createAnimeChoice(up));
                } else if (States.PLANNING_EDV.equals(state)) {
                    execute(sMsg.createPlans(up));
                } else if (States.FILM_GENRE.equals(state)) {
                    execute(sMsg.returnFilmName(up));
                } else {
                    execute(sMsg.createUnknownMessage(up));
                }
            } catch (TelegramApiException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return key;
    }

}
