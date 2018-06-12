package cmpmchad.ljmu.ac.uk.holidayhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Websites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b = (Button) findViewById(R.id.btnHome);

        //Ensures the text views within the activity link to websites outside of the application
        TextView link1 = (TextView)findViewById(R.id.txtLink1);
        link1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView link2 = (TextView)findViewById(R.id.txtLink2);
        link2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView link3 = (TextView)findViewById(R.id.txtLink3);
        link3.setMovementMethod(LinkMovementMethod.getInstance());

        //Returns user to main activity
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Websites.this, MainActivity.class));
            }
        });
    }

}
