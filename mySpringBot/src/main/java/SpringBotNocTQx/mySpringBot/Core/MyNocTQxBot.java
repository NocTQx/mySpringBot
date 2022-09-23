package SpringBotNocTQx.mySpringBot.Core;

import SpringBotNocTQx.mySpringBot.Service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
            String message = up.getMessage().getText();
            long chatId = up.getMessage().getChatId();
            try {
                execute(sMsg.sendMsg(chatId, message));
            } catch (TelegramApiException e){
                e.printStackTrace();
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
