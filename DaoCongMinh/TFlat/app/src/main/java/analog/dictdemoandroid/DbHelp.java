package analog.tflat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;



public class DbHelp extends SQLiteOpenHelper{

    String dbName;
    Context context;
    String dbPath;

    String tableName = "Dictionary";
    String EngCol = "English";

    public DbHelp (Context mcontext,String name, int version) {
        super(mcontext,name, null, version);

        this.context = mcontext;
        this.dbName = name;
        this.dbPath = "/data/data/" + "analog.tflat" + "/database/";

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void checkDb() {
        SQLiteDatabase checkDb = null;
        try{
            String filePath = dbPath + dbName;

            checkDb = SQLiteDatabase.openDatabase(filePath,null, 0);
        }catch (Exception e){}
        if(checkDb!=null){
            Log.d("checkDb", "Database already exsits");
            checkDb.close();
        }else {
            CopyDatabase();
        }

    }

    public void CopyDatabase() {
        this.getReadableDatabase();

        try{
            InputStream is = context.getAssets().open(dbName);
            OutputStream os = new FileOutputStream(dbPath + dbName);

            byte[] buffer  = new  byte[1024];

            int len;
            while ((len = is.read(buffer)) > 0){
                os.write(buffer, 0, len);
            }
            os.flush();
            os.close();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("CopyDb", "Database Copied");
    }
    public void OpenDatabase(){
        String filepath = dbPath + dbName;
        SQLiteDatabase.openDatabase(filepath, null, 0);
    }
    public ArrayList<String> getEngWord(String query){
        ArrayList<String> engList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                tableName,
                new String[]{EngCol},
                EngCol + "LIKE ?",
                new String[]{query + "%"},
                null, null,
                EngCol
        );

        int index = cursor.getColumnIndex(EngCol);
        while (cursor.moveToNext()){
            engList.add(cursor.getString(index));
        }

        sqLiteDatabase.close();
        cursor.close();
        return engList;

    }



}
