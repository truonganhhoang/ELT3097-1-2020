package com.example.my_note.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.my_note.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper
{
    private  static  final int Version = 2;
    private  static  final String Database_Name = "Notess";
    private  static  final String TABLE_NAME = "notelist";

    private  static  final String  Key_ID = "id";
    private  static  final String  Key_Title = "title";
    private  static  final String  Key_Content = "content";
    private  static  final String  Key_Date = "date";
    private  static  final String  Key_Time = "time";

    public Database(Context context){
        super(context ,Database_Name , null , Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLcommand = "CREATE TABLE " + TABLE_NAME + " ( " +
                Key_ID + " INTEGER PRIMARY KEY , " +
                Key_Title + " TEXT , " +
                Key_Content + " TEXT , " +
                Key_Date + " TEXT , " +
                Key_Time + " TEXT ) ";
        db.execSQL(SQLcommand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(Key_Title , note.getTitle());
        c.put(Key_Content , note.getContent());
        c.put(Key_Date , note.getDate());
        c.put(Key_Time , note.getTime());

        long ID = db.insert(TABLE_NAME,null , c);
        Log.d("inserted" , "ID -> " + ID);
        return ID;
    }

    public Note getNote(long id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME , new String[]{Key_ID , Key_Title , Key_Content , Key_Date , Key_Time} , Key_ID+"=?" ,
                new String[]{String.valueOf(id)} , null , null , null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        Note note = new Note(cursor.getLong(0) , cursor.getString(1) , cursor.getString(2), cursor.getString(3) ,cursor.getString(4));
        return  note;
    }

    public List<Note> getNotes(){
        SQLiteDatabase database = this.getReadableDatabase();
        List<Note> Notes =  new ArrayList<>();
        String sqlcommand = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + Key_ID + " DESC" ;
        Cursor cursor = database.rawQuery(sqlcommand , null);
        if(cursor.moveToFirst()){
            do{
                Note note = new Note();
                note.setID(cursor.getLong(0));
                note.setTitle(cursor.getString(1));
                note.setContent(cursor.getString(2));
                note.setDate(cursor.getString(3));
                note.setTime(cursor.getString(4));

                Notes.add(note);

            }while (cursor.moveToNext());
        }
        return Notes;
    }

    public void xoaNote(long id){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(TABLE_NAME,Key_ID+"=?" , new String[]{String.valueOf(id)});
        database.close();
    }

    public int editNote(Note note){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues c = new ContentValues();
        Log.d("Edit", "Editted Title : -> "+ note.getTitle() + "\n ID : -> "+ note.getID());
        c.put(Key_Title , note.getTitle());
        c.put(Key_Content , note.getContent());
        c.put(Key_Date , note.getDate());
        c.put(Key_Time , note.getTime());

        return database.update(TABLE_NAME,c,Key_ID+"=?",new String[]{String.valueOf(note.getID())});

    }
}
