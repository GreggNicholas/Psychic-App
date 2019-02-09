package com.Psychic_App_HW_NICHOLAS_GREGG.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChoicedatabaseHelper extends SQLiteOpenHelper {
    private static final String USERNAME = "username";
    private static final String CORRECTCHOICE = "correctchoice";
    private static final String WRONGCHOICE = "wrongchoice";
    private static final String TOTAL = "total";

    private static final String DATABASE = "ChoicedatabaseHelper";
    private static final String TABLE_Name = "Choices";
    private static final int SCHEMA = 1;

    public ChoicedatabaseHelper(Context context) {
        super(context, DATABASE, null, SCHEMA);
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

    public void addDataEntry(int choice) {
        getWritableDatabase()
                .execSQL(
                "INSERT INTO " + TABLE_Name +
                        "(choices) VALUES('" +
                        choice + "');");
    }


}
