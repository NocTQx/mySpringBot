package SpringBotNocTQx.mySpringBot.Service;

import SpringBotNocTQx.mySpringBot.Config.ButtonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class SendMessageService {

    private final  ButtonConfig buttonConfig;

    @Autowired
    public SendMessageService(ButtonConfig buttonConfig) {
        this.buttonConfig = buttonConfig;
    }
    public synchronized SendMessage sendMsg(long chatId, String MsgFromUsr){
        SendMessage sMsg = new SendMessage();
        sMsg.setText("hi");
        sMsg.setChatId(String.valueOf(chatId));
        sMsg.enableMarkdown(true);
        sMsg.setReplyMarkup(buttonConfig.Buttons());
        return sMsg;
    }
}
