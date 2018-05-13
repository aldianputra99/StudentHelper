package com.studenthelper.Homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HomeworkDBHandler extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "Homework.db";
        public static final String TABLE_PRODUCTS = "Homework";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "HomeworkName";
        public static final String COLUMN_CLASS = "ClassName";
        public static final String COLUMN_DEADLINE = "DeadlineDate";
        public static final String COLUMN_REMINDER = "ReminderDate";
        public static final String COLUMN_COMMENT = "Comment";

        public HomeworkDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        //Create database
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CLASS + " TEXT, " +
                    COLUMN_DEADLINE + " TEXT, " +
                    COLUMN_REMINDER + " TEXT, " +
                    COLUMN_COMMENT + " TEXT " +
                    ");";
            sqLiteDatabase.execSQL(query);
        }

        //Upgrade database
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        }

        public void addHomework(BuildHomework homework){
            ContentValues nameValues = new ContentValues();
            nameValues.put(COLUMN_NAME, homework.getName());
            ContentValues classValues = new ContentValues();
            classValues.put(COLUMN_CLASS, homework.getClassName());
            ContentValues deadlineDate = new ContentValues();
            deadlineDate.put(COLUMN_DEADLINE, homework.getDeadlineDate());
            ContentValues reminderDate = new ContentValues();
            reminderDate.put(COLUMN_REMINDER, homework.getReminderDate());
            ContentValues comment = new ContentValues();
            comment.put(COLUMN_COMMENT, homework.getCommentText());

            SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLE_PRODUCTS, null, nameValues);
            db.insert(TABLE_PRODUCTS, null, classValues);
            db.insert(TABLE_PRODUCTS, null, deadlineDate);
            db.insert(TABLE_PRODUCTS, null, reminderDate);
            db.insert(TABLE_PRODUCTS, null, comment);
            db.close();
        }

        //Delete class, pending dulu
        public void deleteHomework(BuildHomework homework){

        }

        //menampilkan hasil database
        public String HomeworkDBToString(){
            return null;
        }


}
