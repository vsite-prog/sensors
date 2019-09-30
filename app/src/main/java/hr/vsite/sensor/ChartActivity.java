package hr.vsite.sensor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_chart);
        ArrayList<String> temperatures = getIntent().getStringArrayListExtra("temperatures");
        ArrayList<String> humidities = getIntent().getStringArrayListExtra("humidities");

        StringBuilder sb = new StringBuilder();
        sb.append("Temps (C)\n ");
        for(int i=0; i < temperatures.size(); i++){
            sb.append(temperatures.get(i));
            sb.append("\n");
        }
        sb.append("Humidities (%)\n ");
        for(int i=0; i < humidities.size(); i++){
            sb.append(humidities.get(i));
            sb.append("\n");
        }

        TextView tv_lista = findViewById(R.id.tv_lista);
        tv_lista.setText(sb.toString());
    }

}
