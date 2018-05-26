package com.diplome.viktory.translater.logic.learn.database;

import android.content.Context;
import android.util.Log;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.learn.interfaces.AnimalsInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.FruitsInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.HobbyInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.SportInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.VegetablesInitialize;

import io.realm.Realm;

public class DataBaseWorker implements SportInitialize,
        HobbyInitialize, FruitsInitialize, VegetablesInitialize, AnimalsInitialize {

    @Override
    public void SportInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        SimpleRealmObject sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("football");
        sportObject.setKyrg_name("футбол");
        sportObject.setRus_name("футбол");
        sportObject.setImage(R.drawable.football);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("chess");
        sportObject.setKyrg_name("шахмат");
        sportObject.setRus_name("шахматы");
        sportObject.setImage(R.drawable.chess);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("swimming");
        sportObject.setKyrg_name("сүзүү");
        sportObject.setRus_name("плавание");
        sportObject.setImage(R.drawable.swimming);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("pugilism");
        sportObject.setKyrg_name("бокс");
        sportObject.setRus_name("бокс");
        sportObject.setImage(R.drawable.pugilism);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("figure skating");
        sportObject.setKyrg_name("фигурное катание");
        sportObject.setRus_name("фигурное катание");
        sportObject.setImage(R.drawable.figure_skiting);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("hockey");
        sportObject.setKyrg_name("хокей");
        sportObject.setRus_name("хоккей");
        sportObject.setImage(R.drawable.hockey);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("race");
        sportObject.setKyrg_name("тукум");
        sportObject.setRus_name("гонки");
        sportObject.setImage(R.drawable.race);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("run");
        sportObject.setKyrg_name("нускасы");
        sportObject.setRus_name("бег");
        sportObject.setImage(R.drawable.run);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("skiing");
        sportObject.setKyrg_name("лыжачан минип");
        sportObject.setRus_name("езда на лыжах");
        sportObject.setImage(R.drawable.skiing);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("volleyball");
        sportObject.setKyrg_name("жүктөө");
        sportObject.setRus_name("волейбол");
        sportObject.setImage(R.drawable.voleyball);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("basketball");
        sportObject.setKyrg_name("баскетбол");
        sportObject.setRus_name("баскетбол");
        sportObject.setImage(R.drawable.basketball);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("tennis");
        sportObject.setKyrg_name("теннис");
        sportObject.setRus_name("теннис");
        sportObject.setImage(R.drawable.tennis);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("gymnastics");
        sportObject.setKyrg_name("гимнастика");
        sportObject.setRus_name("гимнастика");
        sportObject.setImage(R.drawable.gymnastics);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("billiards");
        sportObject.setKyrg_name("бильярд");
        sportObject.setRus_name("бильярд");
        sportObject.setImage(R.drawable.billiards);
        realm.commitTransaction();

        realm.beginTransaction();
        sportObject = realm.createObject(SimpleRealmObject.class);
        sportObject.setEng_name("karate");
        sportObject.setKyrg_name("каратэ");
        sportObject.setRus_name("каратэ");
        sportObject.setImage(R.drawable.karate);
        realm.commitTransaction();


        if (realm.where(SimpleRealmObject.class).findAll().size() > 0)
            Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : doInBackGroung " + "realm isn't empty");

    }

    @Override
    public void HobbyInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        SimpleRealmObject hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("chess");
        hobbyObject.setKyrg_name("шахмат");
        hobbyObject.setRus_name("шахматы");
        hobbyObject.setImage(R.drawable.chess);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("programming");
        hobbyObject.setKyrg_name("программалоо");
        hobbyObject.setRus_name("программирование");
        hobbyObject.setImage(R.drawable.programming);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("run");
        hobbyObject.setKyrg_name("нускасы");
        hobbyObject.setRus_name("бег");
        hobbyObject.setImage(R.drawable.run);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("collecting");
        hobbyObject.setKyrg_name("чогултуу");
        hobbyObject.setRus_name("коллекционирование");
        hobbyObject.setImage(R.drawable.collecting);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("fishing");
        hobbyObject.setKyrg_name("балык уулоо");
        hobbyObject.setRus_name("рыбалка");
        hobbyObject.setImage(R.drawable.fishing);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("guitar");
        hobbyObject.setKyrg_name("гитара");
        hobbyObject.setRus_name("гитара");
        hobbyObject.setImage(R.drawable.guitar);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("hunting");
        hobbyObject.setKyrg_name("мергенчилик");
        hobbyObject.setRus_name("охота");
        hobbyObject.setImage(R.drawable.hunting);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("cookery");
        hobbyObject.setKyrg_name("кулинария");
        hobbyObject.setRus_name("кулинария");
        hobbyObject.setImage(R.drawable.cookery);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("painting");
        hobbyObject.setKyrg_name("сүрөт");
        hobbyObject.setRus_name("рисование");
        hobbyObject.setImage(R.drawable.painting);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("floriculture");
        hobbyObject.setKyrg_name("цветоводство");
        hobbyObject.setRus_name("цветоводство");
        hobbyObject.setImage(R.drawable.floriculture);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("archeology");
        hobbyObject.setKyrg_name("археология");
        hobbyObject.setRus_name("археология");
        hobbyObject.setImage(R.drawable.archeology);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("singing");
        hobbyObject.setKyrg_name("ырдоо");
        hobbyObject.setRus_name("пение");
        hobbyObject.setImage(R.drawable.singing);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("dancing");
        hobbyObject.setKyrg_name("бийлөө");
        hobbyObject.setRus_name("танцы");
        hobbyObject.setImage(R.drawable.dancing);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("needlework");
        hobbyObject.setKyrg_name("Кол өнөрчүлүктүн");
        hobbyObject.setRus_name("рукоделие");
        hobbyObject.setImage(R.drawable.needlework);
        realm.commitTransaction();

        realm.beginTransaction();
        hobbyObject = realm.createObject(SimpleRealmObject.class);
        hobbyObject.setEng_name("origami");
        hobbyObject.setKyrg_name("оригами");
        hobbyObject.setRus_name("оригами");
        hobbyObject.setImage(R.drawable.origami);
        realm.commitTransaction();

    }

    public void FruitsInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        SimpleRealmObject fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("apple");
        fruitObject.setKyrg_name("алма");
        fruitObject.setRus_name("яблоко");
        fruitObject.setImage(R.drawable.apple);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("banana");
        fruitObject.setKyrg_name("банан");
        fruitObject.setRus_name("банан");
        fruitObject.setImage(R.drawable.banana);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("plum");
        fruitObject.setKyrg_name("кара өрүк");
        fruitObject.setRus_name("слива");
        fruitObject.setImage(R.drawable.plum);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("pear");
        fruitObject.setKyrg_name("алмурут");
        fruitObject.setRus_name("груша");
        fruitObject.setImage(R.drawable.pear);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("dried apricots");
        fruitObject.setKyrg_name("кургатылган өрүк");
        fruitObject.setRus_name("урюк");
        fruitObject.setImage(R.drawable.dried_apricots);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("orange");
        fruitObject.setKyrg_name("апельсин");
        fruitObject.setRus_name("апельсин");
        fruitObject.setImage(R.drawable.orange);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("lemon");
        fruitObject.setKyrg_name("лимон");
        fruitObject.setRus_name("лимон");
        fruitObject.setImage(R.drawable.lemon);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("kiwi");
        fruitObject.setKyrg_name("киви");
        fruitObject.setRus_name("киви");
        fruitObject.setImage(R.drawable.kiwi);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("coconut");
        fruitObject.setKyrg_name("кокос");
        fruitObject.setRus_name("кокос");
        fruitObject.setImage(R.drawable.coconut);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("peach");
        fruitObject.setKyrg_name("шабдалы");
        fruitObject.setRus_name("персик");
        fruitObject.setImage(R.drawable.peach);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("mandarin");
        fruitObject.setKyrg_name("мандарин");
        fruitObject.setRus_name("мандарин");
        fruitObject.setImage(R.drawable.mandarin);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("pineapple");
        fruitObject.setKyrg_name("ананас");
        fruitObject.setRus_name("ананас");
        fruitObject.setImage(R.drawable.pineapple);
        realm.commitTransaction();

        realm.beginTransaction();
        fruitObject = realm.createObject(SimpleRealmObject.class);
        fruitObject.setEng_name("garnet");
        fruitObject.setKyrg_name("анар");
        fruitObject.setRus_name("гранат");
        fruitObject.setImage(R.drawable.garnet);
        realm.commitTransaction();

    }

    @Override
    public void VegetableInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        SimpleRealmObject vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("carrot");
        vegetableObject.setKyrg_name("сабиз");
        vegetableObject.setRus_name("морковь");
        vegetableObject.setImage(R.drawable.carrot);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("tomato");
        vegetableObject.setKyrg_name("помидор");
        vegetableObject.setRus_name("помидор");
        vegetableObject.setImage(R.drawable.tomato);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("cabbage");
        vegetableObject.setKyrg_name("капуста");
        vegetableObject.setRus_name("капуста");
        vegetableObject.setImage(R.drawable.cabbage);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("beet");
        vegetableObject.setKyrg_name("кызылча");
        vegetableObject.setRus_name("свекла");
        vegetableObject.setImage(R.drawable.beet);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("onion");
        vegetableObject.setKyrg_name("лук");
        vegetableObject.setRus_name("лук");
        vegetableObject.setImage(R.drawable.onion);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("garlic");
        vegetableObject.setKyrg_name("ачуу пияз");
        vegetableObject.setRus_name("чеснок");
        vegetableObject.setImage(R.drawable.garlic);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("eggplant");
        vegetableObject.setKyrg_name("баклажан");
        vegetableObject.setRus_name("баклажан");
        vegetableObject.setImage(R.drawable.eggplant);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("zucchini");
        vegetableObject.setKyrg_name("кабачок");
        vegetableObject.setRus_name("кабачёк");
        vegetableObject.setImage(R.drawable.zucchini);
        realm.commitTransaction();



        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("pumpkin");
        vegetableObject.setKyrg_name("ашкабак");
        vegetableObject.setRus_name("тыква");
        vegetableObject.setImage(R.drawable.pumpkin);
        realm.commitTransaction();


        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("pepper");
        vegetableObject.setKyrg_name("калемпир");
        vegetableObject.setRus_name("перец");
        vegetableObject.setImage(R.drawable.pepper);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("potato");
        vegetableObject.setKyrg_name("картөшкө");
        vegetableObject.setRus_name("картошка");
        vegetableObject.setImage(R.drawable.potato);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("squash");
        vegetableObject.setKyrg_name("кабачок");
        vegetableObject.setRus_name("патисон");
        vegetableObject.setImage(R.drawable.squash);
        realm.commitTransaction();


        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("cucumber");
        vegetableObject.setKyrg_name("бадыраң");
        vegetableObject.setRus_name("огурец");
        vegetableObject.setImage(R.drawable.cucumber);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("corn");
        vegetableObject.setKyrg_name("дан");
        vegetableObject.setRus_name("кукуруза");
        vegetableObject.setImage(R.drawable.corn);
        realm.commitTransaction();


    }

    @Override
    public void AnimalsInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        SimpleRealmObject vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("leopard");
        vegetableObject.setKyrg_name("леопард");
        vegetableObject.setRus_name("леопард");
        vegetableObject.setImage(R.drawable.leopard);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("snake");
        vegetableObject.setKyrg_name("жылан");
        vegetableObject.setRus_name("змея");
        vegetableObject.setImage(R.drawable.snake);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("rabbit");
        vegetableObject.setKyrg_name("коен");
        vegetableObject.setRus_name("кролик");
        vegetableObject.setImage(R.drawable.rabbit);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("goat");
        vegetableObject.setKyrg_name("теке");
        vegetableObject.setRus_name("козёл");
        vegetableObject.setImage(R.drawable.goat);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("cow");
        vegetableObject.setKyrg_name("уй");
        vegetableObject.setRus_name("корова");
        vegetableObject.setImage(R.drawable.cow);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("crocodile");
        vegetableObject.setKyrg_name("крокодил");
        vegetableObject.setRus_name("крокодил");
        vegetableObject.setImage(R.drawable.crocodile);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("cat");
        vegetableObject.setKyrg_name("мышык");
        vegetableObject.setRus_name("кошка");
        vegetableObject.setImage(R.drawable.cat);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("horse");
        vegetableObject.setKyrg_name("ат");
        vegetableObject.setRus_name("лошадь");
        vegetableObject.setImage(R.drawable.horse);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("mouse");
        vegetableObject.setKyrg_name("чычкан");
        vegetableObject.setRus_name("мышь");
        vegetableObject.setImage(R.drawable.mouse);
        realm.commitTransaction();



        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("donkey");
        vegetableObject.setKyrg_name("эшек");
        vegetableObject.setRus_name("осёл");
        vegetableObject.setImage(R.drawable.donkey);
        realm.commitTransaction();


        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("fish");
        vegetableObject.setKyrg_name("балык");
        vegetableObject.setRus_name("рыба");
        vegetableObject.setImage(R.drawable.fish);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("pig");
        vegetableObject.setKyrg_name("чочко");
        vegetableObject.setRus_name("свинья");
        vegetableObject.setImage(R.drawable.pig);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("dog");
        vegetableObject.setKyrg_name("ит");
        vegetableObject.setRus_name("собака");
        vegetableObject.setImage(R.drawable.dog);
        realm.commitTransaction();



        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("tiger");
        vegetableObject.setKyrg_name("жолборс");
        vegetableObject.setRus_name("тигр");
        vegetableObject.setImage(R.drawable.tiger);
        realm.commitTransaction();

        realm.beginTransaction();
        vegetableObject = realm.createObject(SimpleRealmObject.class);
        vegetableObject.setEng_name("duck");
        vegetableObject.setKyrg_name("өрдөк");
        vegetableObject.setRus_name("утка");
        vegetableObject.setImage(R.drawable.duck);
        realm.commitTransaction();
    }
}
