package ernestosalazar.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ernestosalazar.interactivestory.R;

public class MainActivity extends AppCompatActivity {
    private EditText nameField;
    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText)findViewById(R.id.nameEditText);
        startButton = (Button)findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                //Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                startStory(name);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {
        // los intent son utilizados para cuando queremos crear acciones como abrir una nueva activity o abrir la camara por ejemplo
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources(); // podemos utilizar resources desde cualquier lugar que tenga acceso al current context
        String key = resources.getString(R.string.key_name);
        // pasamos a la activity deseada informacion mediante putExtra() que funciona como key: value
        intent.putExtra(key,name);
        startActivity(intent);
    }
}
