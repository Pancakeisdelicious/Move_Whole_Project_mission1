package com.example.move_whole_project.Mission;

public class Board {
    // 미션 내용
    private String contents;
    private boolean isChecked;

    public Board(String contents) {
        this.contents = contents;
        this.isChecked = false; // 초기값 실패
    }

    public String getContents() {
        return contents;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isCompleted(){
        return isChecked;
    }
}