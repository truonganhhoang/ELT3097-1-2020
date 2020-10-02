package com.example.my_note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.my_note.Database.Database;
import com.example.my_note.Model.Note;

import java.util.Calendar;

public class Edit extends AppCompatActivity {
    Database database;
    Note note;

    Toolbar toolbar;
    EditText noteTitle,noteDetail;

    Calendar c;
    String todaysDate;
    String currenttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();
        Long id = i.getLongExtra("ID", 0);
        database = new Database(this);
        note = database.getNote(id);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        toolbar = findViewById(R.id.Toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(note.getTitle());


        noteTitle = findViewById(R.id.ntitle);
        noteDetail = findViewById(R.id.noteDetail);
        noteTitle.setText(note.getTitle());
        noteDetail.setText(note.getContent());

        noteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0){
                    getSupportActionBar().setTitle(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        c = Calendar.getInstance();
        todaysDate = c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH + 1) + "/" + c.get(Calendar.DAY_OF_MONTH);
        currenttime = pad(c.get(Calendar.HOUR)) + ":" + pad(c.get(Calendar.MINUTE));

        Log.d("calendar", "Date and time : " + todaysDate + " and " + currenttime);
    }

    private String pad(int i) {
        if(i<10){
            return  "0"+i;
        }
        return String.valueOf(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.delete){
            Toast.makeText(this, "Hủy chỉnh sửa ghi chú." , Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else { if (item.getItemId()== R.id.save) {
            if (noteTitle.getText().length() != 0) {
                note.setTitle(noteTitle.getText().toString());
                note.setContent(noteDetail.getText().toString());

                int id = database.editNote(note);
                if(id==note.getID()){
                    Toast.makeText(this, "Ghi chú thành chông" , Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Ghi chú thất bại" , Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(getApplicationContext(),Details.class);
                i.putExtra("ID",note.getID());
                startActivity(i);

            }
            else {
                noteTitle.setError("Tiêu đề không thể bỏ trống");
            }
        }
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToMain() {
        Intent i = new Intent(this , MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
