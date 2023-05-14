package com.example.move_whole_project.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.move_whole_project.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class RecordFragment extends Fragment {

    private LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);

        List<Entry> step_chart = new ArrayList<>();

        lineChart = (LineChart) view.findViewById(R.id.tv_profile_graph_input);
        LineData data = new LineData();

        step_chart.add(new Entry(1, 1)); //step_chart1에 좌표 데이터를 담는다.
        step_chart.add(new Entry(2, 2));
        step_chart.add(new Entry(3, 3));


        LineDataSet dataSet1 = new LineDataSet(step_chart, "걸음 수");

        dataSet1.setColor(Color.RED);

        data.addDataSet(dataSet1);

        lineChart.setData(data);

        lineChart.invalidate();
        lineChart.setTouchEnabled(false);

        return view;
    }
}
