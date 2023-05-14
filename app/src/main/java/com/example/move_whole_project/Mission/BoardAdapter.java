package com.example.move_whole_project.Mission;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.move_whole_project.R;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private List<Board> contentList;

    public BoardAdapter(List<Board> contentList) {
        this.contentList = contentList;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mission_list, parent, false);
        return new BoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        Board data = contentList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        // 미션 내용, 체크 박스, 통합 프로그레스 바
        private TextView contents;
        private CheckBox checkBox;
        private ProgressBar progressBar;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            // 미션 내용, 체크 박스
            contents = itemView.findViewById(R.id.mission_content);
            checkBox = itemView.findViewById(R.id.mission_checkbox);

            // 체크 박스 리스너(체크박스 누를시에 체크표시와 취소선 그어지는거)
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Board data = contentList.get(position);
                        data.setChecked(isChecked);
                        contents.setPaintFlags(isChecked ? contents.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG :
                                contents.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    }
                }
            });
        }
        
        // 바인드 메소드를 통해 뷰 홀더에 바인드(체크박스와 취소선의 동작 여부)
        public void bind(Board data) {
            contents.setText(data.getContents());
            checkBox.setChecked(data.isChecked());
            contents.setPaintFlags(data.isChecked() ? contents.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG :
                    contents.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));

            // 프로그레스바 업데이트
//            int totalMissions = contentList.size(); // 전체 미션 개수
//            int completedMissions = 0; // 완료된 미션 개수
//
//            for (Board board : contentList) {
//                if (board.isChecked()) {
//                    completedMissions++;
//                }
//            }
//
//            progressBar.setMax(totalMissions);
//            progressBar.setProgress(completedMissions);
        }
    }
}