package hr.vsite.sensor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class Chart2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart2);

        ArrayList<String> temperatures = getIntent().getStringArrayListExtra("temperatures");
        ArrayList<String> humidities = getIntent().getStringArrayListExtra("humidities");

        LineChartView lineChartView = findViewById(R.id.chart);

        List tempYAxisValues = new ArrayList();
        List tempAxisValues = new ArrayList();

        List humYAxisValues = new ArrayList();
        List humAxisValues = new ArrayList();

        Line lineTemperature = new Line(tempYAxisValues).setColor(Color.parseColor("#9C27B0"));;
        Line lineHumidity = new Line(humYAxisValues).setColor(Color.parseColor("#1A27BF"));;

        int n = Math.max(temperatures.size(),humidities.size() );

        for(int i = 0; i < n; i++){
            tempAxisValues.add(i, new AxisValue(i).setLabel(String.valueOf(i)));
        }

        for(int i = 0; i < temperatures.size(); i++){
            tempYAxisValues.add(new PointValue(i,Float.valueOf(temperatures.get(i))));
        }

        for(int i = 0; i < humidities.size(); i++){
            humYAxisValues.add(new PointValue(i,Float.valueOf(humidities.get(i))));
        }

        List lines = new ArrayList();
        lines.add(lineTemperature);
        lines.add(lineHumidity);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

        Axis axis = new Axis();
        axis.setValues(tempAxisValues);
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);
    }
}
