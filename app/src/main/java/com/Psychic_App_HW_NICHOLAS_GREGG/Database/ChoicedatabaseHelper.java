package com.Psychic_App_HW_NICHOLAS_GREGG.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.Psychic_App_HW_NICHOLAS_GREGG.Model.Choice;

import java.util.ArrayList;
import java.util.List;

public class ChoicedatabaseHelper extends SQLiteOpenHelper {
    private static final String USERNAME = "username";
    private static final String CORRECTCHOICE = "correctchoice";
    private static final String WRONGCHOICE = "wrongchoice";
    private static final String TOTAL = "total";

    private static final String DATABASE = "ChoicedatabaseHelper";
    private static final String TABLE_Name = "Choices";
    private static final int SCHEMA = 1;
    private static ChoicedatabaseHelper choicedatabase;

    private List<Choice> choicesList;

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

//    public List<Choice> getChoicesList(){
//        choicesList = new ArrayList<>();
//        Cursor cursor = getReadableDatabase().rawQuery(
//                "SELECT * FROM " + TABLE_Name +
//                        ";" , null);
//        if(cursor != null){
//            if(cursor.moveToFirst()) {
//                do {
//                    Choice choice = new Choice(
//                            cursor.getString(cursor.getColumnIndex())
//                    )
//                }
//            }
//        }
   // }


    public void addChoiceEntry(Choice choice) {
        getWritableDatabase()
                .execSQL(
                        "INSERT INTO " + TABLE_Name +
                                "(choices) VALUES('" +
                                choice + "');");
    }


}
