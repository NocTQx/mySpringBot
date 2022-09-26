package SpringBotNocTQx.mySpringBot.Service;

import java.util.ArrayList;

public class CreatingArray {
    public static ArrayList<ArrayList<String>> CreateArray(){
        ArrayList<ArrayList<String>> wordList = new ArrayList<>();
        ArrayList<String> greetingList = new ArrayList<>();
            greetingList.add("Приветик");
            greetingList.add("Ку");
            greetingList.add("Здравствуй");
            greetingList.add("Хай");
            greetingList.add("Утречко:)");
            greetingList.add("Опять чего-то понадобилось? Ну выбирай...");
            greetingList.add("Приветствую тебя !");
            greetingList.add("Сделаю вид что мы знакомы. Как дела?");
            greetingList.add("Давненько тебя не видно было...");
            greetingList.add("А я соскучилась");
            greetingList.add("Что, фильмец глянем или аниме?");

        ArrayList<String> farewellList = new ArrayList<>();
            farewellList.add("Увидимся)");
            farewellList.add("Пока-пока");
            farewellList.add("Да-да, до скорого");
            farewellList.add("Ну конечно, с ними тебе интереснее чем со мной(");
            farewellList.add("Была рада увидеться)");
            farewellList.add("Хорошего дня");
            farewellList.add("До свидания");
            farewellList.add("Жду следующей встречи");
            farewellList.add("Возвращайся");
            farewellList.add("Живы будем - пересечемся");
            farewellList.add("Bye sweetheart");

        ArrayList<String> searchFilmList = new ArrayList<>();
            searchFilmList.add("Выберите жанр фильма:");
            searchFilmList.add("Мое предложение на сегодня:");

        ArrayList<String> searchAnimeList = new ArrayList<>();
            searchAnimeList.add("Какое аниме хотите посмотреть?");

        ArrayList<String> weatherList = new ArrayList<>();
            weatherList.add("Напишите название города, пожалуйста");
            weatherList.add("Вас интересует погода на сегодня или завтра?");

        ArrayList<String> plannerList = new ArrayList<>();
            plannerList.add("Появились планы или хочется освежить в памяти текущие?");

        wordList.add(greetingList);
        wordList.add(farewellList);
        wordList.add(searchFilmList);
        wordList.add(searchAnimeList);
        wordList.add(weatherList);
        wordList.add(plannerList);

        return wordList;
    }
}
