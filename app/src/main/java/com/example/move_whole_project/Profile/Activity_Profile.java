package com.example.move_whole_project.Profile;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.move_whole_project.Fragment.HomeFragment;
import com.example.move_whole_project.Fragment.MissionFragment;
import com.example.move_whole_project.Fragment.RecordFragment;
import com.example.move_whole_project.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class Activity_Profile extends AppCompatActivity {


    // 선 그래프
    private LineChart lineChart;
    HomeFragment homeFragment;
    MissionFragment missionFragment;
    RecordFragment recordFragment;

    // json 수신
    private String steps;
    private String date;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ArrayList<Entry> step_chart = new ArrayList<>(); // 데이터를 담을 Arraylist

        lineChart = (LineChart) findViewById(R.id.tv_profile_graph_input);
        LineData chartData = new LineData(); // 차트에 담길 데이터

        step_chart.add(new Entry(1, 1)); //step_chart에 좌표 데이터를 담는다.
        step_chart.add(new Entry(2, 2));
        step_chart.add(new Entry(3, 3));


        LineDataSet stepDataSet = new LineDataSet(step_chart, "걸음 수");

        stepDataSet.setColor(Color.RED); // 해당 LineDataSet의 색 설정 :: 각 Line 과 관련된 세팅은 여기서 설정한다.

        chartData.addDataSet(stepDataSet); // 해당 LineDataSet 을 적용될 차트에 들어갈 DataSet 에 넣는다.

        lineChart.setData(chartData); // 차트에 위의 DataSet을 넣는다.

        lineChart.invalidate(); // 차트 업데이트
        lineChart.setTouchEnabled(false); // 차트 터치 disable


        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                        return true;
                    case R.id.mission:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, missionFragment).commit();
                        return true;
                    case R.id.record:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, recordFragment).commit();
                        return true;
                }
                return false;
            }
        });

        // json
        RequestQueue queue = Volley.newRequestQueue(this);

        // JSON 데이터 생성
        JSONObject jsonRequest = new JSONObject();
        try {
            jsonRequest.put("걸음 수", "10000");
            jsonRequest.put("날짜", "20230508");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // 요청 생성
        String url = "서버 URL";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // 응답 처리
                        // response는 서버에서 받은 JSON 응답입니다.
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 에러 처리
                    }
                });
        queue.add(request);
    }
}






