package com.diplome.viktory.translater.logic.learn.database;

import android.content.Context;
import android.util.Log;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.learn.interfaces.AnimalsInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.ClothesInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.FruitsInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.HobbyInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.QuestionInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.SportInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.VegetablesInitialize;

import io.realm.Realm;

public class DataBaseWorker implements SportInitialize, HobbyInitialize,
        FruitsInitialize, VegetablesInitialize,
        AnimalsInitialize, ClothesInitialize, QuestionInitialize {

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
            Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : doInBackGroung " + "realm isn't empty");

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
        SimpleRealmObject animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("leopard");
        animalObject.setKyrg_name("леопард");
        animalObject.setRus_name("леопард");
        animalObject.setImage(R.drawable.leopard);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("snake");
        animalObject.setKyrg_name("жылан");
        animalObject.setRus_name("змея");
        animalObject.setImage(R.drawable.snake);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("rabbit");
        animalObject.setKyrg_name("коен");
        animalObject.setRus_name("кролик");
        animalObject.setImage(R.drawable.rabbit);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("goat");
        animalObject.setKyrg_name("теке");
        animalObject.setRus_name("козёл");
        animalObject.setImage(R.drawable.goat);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("cow");
        animalObject.setKyrg_name("уй");
        animalObject.setRus_name("корова");
        animalObject.setImage(R.drawable.cow);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("crocodile");
        animalObject.setKyrg_name("крокодил");
        animalObject.setRus_name("крокодил");
        animalObject.setImage(R.drawable.crocodile);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("cat");
        animalObject.setKyrg_name("мышык");
        animalObject.setRus_name("кошка");
        animalObject.setImage(R.drawable.cat);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("horse");
        animalObject.setKyrg_name("ат");
        animalObject.setRus_name("лошадь");
        animalObject.setImage(R.drawable.horse);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("mouse");
        animalObject.setKyrg_name("чычкан");
        animalObject.setRus_name("мышь");
        animalObject.setImage(R.drawable.mouse);
        realm.commitTransaction();


        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("donkey");
        animalObject.setKyrg_name("эшек");
        animalObject.setRus_name("осёл");
        animalObject.setImage(R.drawable.donkey);
        realm.commitTransaction();


        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("fish");
        animalObject.setKyrg_name("балык");
        animalObject.setRus_name("рыба");
        animalObject.setImage(R.drawable.fish);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("pig");
        animalObject.setKyrg_name("чочко");
        animalObject.setRus_name("свинья");
        animalObject.setImage(R.drawable.pig);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("dog");
        animalObject.setKyrg_name("ит");
        animalObject.setRus_name("собака");
        animalObject.setImage(R.drawable.dog);
        realm.commitTransaction();


        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("tiger");
        animalObject.setKyrg_name("жолборс");
        animalObject.setRus_name("тигр");
        animalObject.setImage(R.drawable.tiger);
        realm.commitTransaction();

        realm.beginTransaction();
        animalObject = realm.createObject(SimpleRealmObject.class);
        animalObject.setEng_name("duck");
        animalObject.setKyrg_name("өрдөк");
        animalObject.setRus_name("утка");
        animalObject.setImage(R.drawable.duck);
        realm.commitTransaction();
    }

    @Override
    public void ClosesInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        SimpleRealmObject closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("socks");
        closeInit.setKyrg_name("байпак");
        closeInit.setRus_name("носки");
        closeInit.setImage(R.drawable.leopard);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("jacket");
        closeInit.setKyrg_name("кемсел");
        closeInit.setRus_name("куртка");
        closeInit.setImage(R.drawable.jacket);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("pants");
        closeInit.setKyrg_name("дамбал");
        closeInit.setRus_name("штаны");
        closeInit.setImage(R.drawable.rabbit);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("footwear");
        closeInit.setKyrg_name("бут кийим");
        closeInit.setRus_name("обувь");
        closeInit.setImage(R.drawable.goat);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("shirt");
        closeInit.setKyrg_name("көйнөк");
        closeInit.setRus_name("рубашка");
        closeInit.setImage(R.drawable.shirt);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("T-shirt");
        closeInit.setKyrg_name("T-рубашка");
        closeInit.setRus_name("футболка");
        closeInit.setImage(R.drawable.t_shirt);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("cap");
        closeInit.setKyrg_name("капкак");
        closeInit.setRus_name("кепка");
        closeInit.setImage(R.drawable.cap);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("sweater");
        closeInit.setKyrg_name("свитер");
        closeInit.setRus_name("свитер");
        closeInit.setImage(R.drawable.sweater);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("jeans");
        closeInit.setKyrg_name("джинсы");
        closeInit.setRus_name("джинсы");
        closeInit.setImage(R.drawable.jeans);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("pants");
        closeInit.setKyrg_name("шым");
        closeInit.setRus_name("брюки");
        closeInit.setImage(R.drawable.pants);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("slippers");
        closeInit.setKyrg_name("тапки");
        closeInit.setRus_name("тапки");
        closeInit.setImage(R.drawable.slippers);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("suit");
        closeInit.setKyrg_name("туура келүү");
        closeInit.setRus_name("костюм");
        closeInit.setImage(R.drawable.suit);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("coat");
        closeInit.setKyrg_name("жүн");
        closeInit.setRus_name("пальто");
        closeInit.setImage(R.drawable.coat);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("pajamas");
        closeInit.setKyrg_name("пижама");
        closeInit.setRus_name("пижама");
        closeInit.setImage(R.drawable.pajamas);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("bathrobe");
        closeInit.setKyrg_name("халат");
        closeInit.setRus_name("халат");
        closeInit.setImage(R.drawable.bathrobe);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("hat");
        closeInit.setKyrg_name("калпак");
        closeInit.setRus_name("шляпа");
        closeInit.setImage(R.drawable.hat);
        realm.commitTransaction();

        realm.beginTransaction();
        closeInit = realm.createObject(SimpleRealmObject.class);
        closeInit.setEng_name("bag");
        closeInit.setKyrg_name("сумка");
        closeInit.setRus_name("сумка");
        closeInit.setImage(R.drawable.bag);
        realm.commitTransaction();

    }

    @Override
    public void QuestionInit(Context context, Realm realm) {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

        realm.beginTransaction();
        ExtendedRealmObject questionInitialize = realm.createObject(ExtendedRealmObject.class);
        questionInitialize.setEng_answer("Everest");
        questionInitialize.setKyrg_answer("Эверест");
        questionInitialize.setRus_answer("Эверест");
        questionInitialize.setEng_question("The highest mountain");
        questionInitialize.setKyrg_question("Бийик тоо");
        questionInitialize.setRus_question("Самая высокая гора");
        questionInitialize.setImageId(R.drawable.mountain);
        realm.commitTransaction();

        realm.beginTransaction();
        questionInitialize = realm.createObject(ExtendedRealmObject.class);
        questionInitialize.setEng_answer("Amazon");
        questionInitialize.setKyrg_answer("Амазонка");
        questionInitialize.setRus_answer("Амазонка");
        questionInitialize.setEng_question("The longest river");
        questionInitialize.setKyrg_question("Узун дарыя");
        questionInitialize.setRus_question("Самая длинная река");
        questionInitialize.setImageId(R.drawable.river);
        realm.commitTransaction();

        realm.beginTransaction();
        questionInitialize = realm.createObject(ExtendedRealmObject.class);
        questionInitialize.setEng_answer("Eurasia");
        questionInitialize.setKyrg_answer("евразия");
        questionInitialize.setRus_answer("евразия");
        questionInitialize.setEng_question("The largest continent");
        questionInitialize.setKyrg_question("Ири континент");
        questionInitialize.setRus_question("Самая крупный материк");
        questionInitialize.setImageId(R.drawable.continent);
        realm.commitTransaction();

        realm.beginTransaction();
        questionInitialize = realm.createObject(ExtendedRealmObject.class);
        questionInitialize.setEng_answer("Australia");
        questionInitialize.setKyrg_answer("Австралия");
        questionInitialize.setRus_answer("Австралия");
        questionInitialize.setEng_question("The smallest continent");
        questionInitialize.setKyrg_question("Эн кичинекей материк");
        questionInitialize.setRus_question("Самая маленький материк");
        realm.commitTransaction();

    }
}
