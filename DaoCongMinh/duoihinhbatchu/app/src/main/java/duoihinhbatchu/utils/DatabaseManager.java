package nhom6.com.duoihinhbatchu.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import nhom6.com.duoihinhbatchu.model.Question;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String DATABASE_PATH = Environment.getDataDirectory().getAbsolutePath() + "/data/com.nhom6.duoihinhbatchu/";
    private static final String DATABSE_NAME = "database.db";
    private static final String TABLE_NAME_QUESTION = "cauhoi";
    private static final String SQL_GET_QUESTION = "SELECT * FROM " + TABLE_NAME_QUESTION;
    private static final String DAP_AN = "dapan";
    private static final String GOI_Y = "goiy";
    private static final String KET_QUA = "ketqua";
    private static final String FILE_NAME = "filename";
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public DatabaseManager(Context context) {

        this.context = context;
        copyDatabases();

    }

    private void copyDatabases() {
        new File(DATABASE_PATH).mkdir();
        try {
            File file = new File(DATABASE_PATH + DATABSE_NAME);
            if (file.exists()) return;
            InputStream input = context.getAssets().open(DATABSE_NAME);

            file.createNewFile();
            FileOutputStream output = new FileOutputStream(file);
            int len;
            byte buff[] = new byte[1024];
            while ((len = input.read(buff)) > 0) {
                output.write(buff, 0, len);
            }
            output.close();
            input.close();

            Log.i("a", "Copy Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openDB() {
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            sqLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_PATH + DATABSE_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        }
    }

    private void closeDB() {
        if (sqLiteDatabase != null || sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }

    public Question getOneQuestion() {
        openDB();
        //Uu tien lay theo dk sau

        Cursor c = sqLiteDatabase.rawQuery(SQL_GET_QUESTION + " ORDER BY Random() LIMIT 1", null);

        if (c == null) {
            return null;
        }
        Question question1 = null;
        //Lay thu tu cot dua vao ten cot
        //Lay du lieu dua vao thu tu cot
        int indexDapAn = c.getColumnIndex(DAP_AN);
        int indexGoiY = c.getColumnIndex(GOI_Y);
        int indexKetQua = c.getColumnIndex(KET_QUA);
        int indexFileName = c.getColumnIndex(FILE_NAME);

        String dapAn, goiY, ketQua, fileName;

        c.moveToFirst();
        //Khi con tro chua tro toi hang cuoi cung
        while (c.isAfterLast() == false) {
            //Lay du lieu dua vao thu tu cot

            dapAn = c.getString(indexDapAn);
            goiY = c.getString(indexGoiY);
            ketQua = c.getString(indexKetQua);
            fileName = c.getString(indexFileName);
            question1 = new Question(dapAn, goiY, ketQua, fileName);
            //Dua con tro den vi tri tiep theo
            c.moveToNext();
        }
        //Dong con tro lai
        c.close();
        //Dong csdl
        closeDB();
        return question1;
    }
}

