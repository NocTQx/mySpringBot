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
            kbrdFirstRow.add(new KeyboardButton("Аниме"));
            kbrdSecondRow.add(new KeyboardButton("Расписание на неделю"));
            kbrdThirdRow.add(new KeyboardButton("Погода"));
            kbrdThirdRow.add(new KeyboardButton("Помощь"));

            keyboard.add(kbrdFirstRow);
            keyboard.add(kbrdSecondRow);
            keyboard.add(kbrdThirdRow);

            rKM.setKeyboard(keyboard);
            return rKM;
    }

    public ReplyKeyboardMarkup FilmButtons(){

        ReplyKeyboardMarkup rKM = new ReplyKeyboardMarkup();

        rKM.setSelective(true);
        rKM.setResizeKeyboard(true);
        rKM.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow kbrdFirstRow = new KeyboardRow();
        KeyboardRow kbrdSecondRow = new KeyboardRow();
        KeyboardRow kbrdThirdRow = new KeyboardRow();
        KeyboardRow kbrdForthRow = new KeyboardRow();

            kbrdFirstRow.add(new KeyboardButton("Лучшие"));
            kbrdFirstRow.add(new KeyboardButton("Комедия")); //https://www.film.ru/compilation/luchshie-chernye-komedii
            kbrdFirstRow.add(new KeyboardButton("Фэнтези")); //https://www.film.ru/compilation/ne-tolko-igra-prestolov-vydayushchiesya-fentezi-serialy
            kbrdSecondRow.add(new KeyboardButton("Про юристов")); //https://www.film.ru/compilation/luchshie-filmy-i-serialy-pro-advokatov-i-sudy
            kbrdSecondRow.add(new KeyboardButton("Детектив")); //https://www.film.ru/compilation/luchshie-detektivy-na-netflix
            kbrdSecondRow.add(new KeyboardButton("Про любовь")); //https://www.film.ru/compilation/100-luchshih-filmov-so-slovom-lyubov-v-nazvanii
            kbrdThirdRow.add(new KeyboardButton("Ужасы")); //https://www.film.ru/compilation/100-luchshih-filmov-uzhasov-po-versii-time-out
            kbrdThirdRow.add(new KeyboardButton("Драма")); //https://www.film.ru/compilation/kostyumnye-dramy-v-kotoryh-net-kiry-naytli
            kbrdForthRow.add(new KeyboardButton("Вернемся к началу."));

            keyboard.add(kbrdFirstRow);
            keyboard.add(kbrdSecondRow);
            keyboard.add(kbrdThirdRow);
            keyboard.add(kbrdForthRow);

            rKM.setKeyboard(keyboard);
            return rKM;
}
}
