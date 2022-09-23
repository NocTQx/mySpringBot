package SpringBotNocTQx.mySpringBot.Config;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonConfig {

    public ReplyKeyboardMarkup Buttons() {

        ReplyKeyboardMarkup rKM = new ReplyKeyboardMarkup();

        rKM.setSelective(true);
        rKM.setResizeKeyboard(true);
        rKM.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow kbrdFirstRow = new KeyboardRow();
        KeyboardRow kbrdSecondRow = new KeyboardRow();
        KeyboardRow kbrdThirdRow = new KeyboardRow();

            kbrdFirstRow.add(new KeyboardButton("Фильм"));
            kbrdFirstRow.add(new KeyboardButton("Интересный факт"));
            kbrdSecondRow.add(new KeyboardButton("Расписание на неделю"));
            kbrdThirdRow.add(new KeyboardButton("Погода"));
            kbrdThirdRow.add(new KeyboardButton("Помощь"));

            keyboard.add(kbrdFirstRow);
            keyboard.add(kbrdSecondRow);
            keyboard.add(kbrdThirdRow);

            rKM.setKeyboard(keyboard);
            return rKM;
    }
}
