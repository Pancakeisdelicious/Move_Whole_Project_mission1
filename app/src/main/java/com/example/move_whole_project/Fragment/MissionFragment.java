package com.example.move_whole_project.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.move_whole_project.Mission.Board;
import com.example.move_whole_project.Mission.BoardAdapter;
import com.example.move_whole_project.Profile.Activity_Profile;
import com.example.move_whole_project.R;
import com.example.move_whole_project.Register_Login.Activity_Start;

import java.util.ArrayList;
import java.util.List;


public class MissionFragment extends Fragment {

    // 미션에 필요한 변수
    private RecyclerView mPostRecyclerView;
    private BoardAdapter mAdapter;
    private List<Board> mDatas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_mission, container, false);

        mPostRecyclerView = (RecyclerView) view.findViewById(R.id.mission_list);
        mDatas = new ArrayList<>();

        mDatas.add(new Board("1000 걸음 수 달성"));
        mDatas.add(new Board("5000 걸음 수 달성"));
        mDatas.add(new Board("10000 걸음 수 달성"));
        mDatas.add(new Board("15000 걸음 수 달성"));

        mAdapter = new BoardAdapter(mDatas);
        mPostRecyclerView.setAdapter(mAdapter);
        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }
}