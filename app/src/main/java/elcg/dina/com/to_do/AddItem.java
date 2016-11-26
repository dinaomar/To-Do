package elcg.dina.com.to_do;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class AddItem extends AppCompatActivity {

    private EditText todoText;
    private Button addItem;
    public static String toDoString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        todoText = (EditText)findViewById(R.id.itemAdd);
        addItem = (Button)findViewById(R.id.addButton);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDoString = todoText.getText().toString();
                MainActivity.mDatabase.child("users").child(MainActivity.mUserId).child("items").push().child("title").setValue(toDoString);
                todoText.setText("");
                Intent i = new Intent(AddItem.this , MainActivity.class);
                startActivity(i);
                AddItem.this.finish();
            }
        });
    }
}
