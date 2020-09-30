import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends Activity {

    EditText editName, editMail;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName=(EditText)findViewById(R.id.editName);
        editMail=(EditText)findViewById(R.id.editMail);
        btnSend=(Button)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String name = editName.getText().toString();
                String email = editMail.getText().toString();

                Intent nextScreen = new Intent(getApplicationContext(), SecondActivity.class);

                nextScreen.putExtra("name", name);
                nextScreen.putExtra("email", email);

                startActivity(nextScreen);

                //Toast.makeText(getApplicationContext(), "Đúng rồi", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}