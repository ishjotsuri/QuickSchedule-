package group22.quikschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toWebreg(View view){
        startActivity(new Intent(MainActivity.this, WebregActivity.class));
    }

    public void toMap(View view) {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}