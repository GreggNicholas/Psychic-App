package com.Psychic_App_HW_NICHOLAS_GREGG.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.Psychic_App_HW_NICHOLAS_GREGG.Model.Choice;

import java.util.ArrayList;
import java.util.List;

public class ChoicedatabaseHelper extends SQLiteOpenHelper {
    private static final String CORRECTCHOICE = "correctchoice";
    private static final String WRONGCHOICE = "wrongchoice";
    private static final String TOTAL = "total";

    private static final String DATABASE = "ChoicedatabaseHelper";
    private static final String TABLE_Name = "Choices";
    private static final int SCHEMA = 1;
    private static ChoicedatabaseHelper choicedatabase;

    private List<Integer> choicesList;

    public ChoicedatabaseHelper(Context context) {
        super(context, DATABASE, null, SCHEMA);
    }


    public static synchronized ChoicedatabaseHelper getInstance(Context context) {
        if (choicedatabase == null) {
            choicedatabase = new ChoicedatabaseHelper(context.getApplicationContext());
        }
        return choicedatabase;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_Name
                        + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "user_name TEXT, choices INTEGER, correct_choices INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addChoice(int choice) {
        getWritableDatabase()
                .execSQL(
                        "INSERT INTO " + TABLE_Name +
                                "(choices) VALUES('" +
                                choice + "');");
    }

    public List<Integer> getChoicesList() {
        List<Integer> guessList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_Name +
                        ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int chooseImage =
                            cursor.getInt(cursor.getColumnIndex("choices"));

                    guessList.add(chooseImage);
                } while (cursor.moveToNext());
            }
        }
        choicesList = guessList;
        return choicesList;
    }

    public Choice correctChoice() {
        getChoicesList();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT ALL * FROM " + TABLE_Name + " Where choice = 1;", null);

        Choice choice = new Choice(cursor.getCount(), choicesList.size() - cursor.getCount(), choicesList.size());
        cursor.close();
        return choice;

    }


}
