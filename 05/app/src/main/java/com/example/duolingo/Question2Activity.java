package com.example.duolingo;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class Question2Activity extends AppCompatActivity {
    Button button_kt;
    private Object view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_2);
        button_kt = findViewById(R.id.button_kt);
        button_kt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(Question2Activity.this,
                        "Bạn có muốn kiểm tra ?",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}