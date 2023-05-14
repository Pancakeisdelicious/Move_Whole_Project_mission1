package com.example.move_whole_project.Mission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.move_whole_project.Fragment.HomeFragment;
import com.example.move_whole_project.Fragment.MissionFragment;
import com.example.move_whole_project.Fragment.RecordFragment;
import com.example.move_whole_project.R;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Mission extends AppCompatActivity {

    private RecyclerView mPostRecyclerView;
    private BoardAdapter mAdapter;
    private List<Board> mDatas;

    private HomeFragment homeFragment;
    private MissionFragment missionFragment;
    private RecordFragment recordFragment;

    // 프로그레스 바

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        mPostRecyclerView = findViewById(R.id.mission_list);

        mDatas = new ArrayList<>();
        mDatas.add(new Board("1000 걸음 수 달성"));
        mDatas.add(new Board("5000 걸음 수 달성"));
        mDatas.add(new Board("10000 걸음 수 달성"));
        mDatas.add(new Board("15000 걸음 수 달성"));

        mAdapter = new BoardAdapter(mDatas);
        mPostRecyclerView.setAdapter(mAdapter);
        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // 지훈이의 Main화면에서 걸음 수 변수를 받아와서 메시지 수신
        if (getIntent() != null && getIntent().getAction() != null) {
            if (getIntent().getAction().equals("ACTION_TARGET_STEPS_REACHED")) {
                // 일정 걸음에 도달한 경우 취소선과 체크박스 동작
                // 취소선을 그리는 등의 로직을 추가하세요.
            }

            // 취소선 설정
            TextView textView = findViewById(R.id.mission_content);
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            homeFragment = new HomeFragment();
            missionFragment = new MissionFragment();
            recordFragment = new RecordFragment();


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
        }
    }
}