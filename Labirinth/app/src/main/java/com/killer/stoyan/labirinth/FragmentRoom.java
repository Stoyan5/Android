package com.killer.stoyan.labirinth;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentRoom extends Fragment{

    private ImageView T;
    private ImageView B;
    private ImageView L;
    private ImageView Right;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.room, container, false);
        return view;
    }

    public void showRoom(Room room){
        if(room.hasRight()){
            openRight();
        }else closeRight();
        if(room.hasLeft()){
            openLeft();
        }else closeLeft();
        if(room.hasBottom()){
            openBot();
        }else closeBot();
        if(room.hasTop()){
            openTop();
        }else closeTop();
    }

    public void openTop(){
        T = view.findViewById(R.id.T);
        T.setVisibility(View.INVISIBLE);
    }
    public void openBot(){
        B = view.findViewById(R.id.B);
        B.setVisibility(View.INVISIBLE);
    }
    public void openRight(){
        Right = view.findViewById(R.id.Right);
        Right.setVisibility(View.INVISIBLE);
    }
    public void openLeft(){
        L = view.findViewById(R.id.L);
        L.setVisibility(View.INVISIBLE);
    }

    public void closeTop(){
        T = view.findViewById(R.id.T);
        T.setVisibility(View.VISIBLE);
    }
    public void closeBot(){
        B = view.findViewById(R.id.B);
        B.setVisibility(View.VISIBLE);
    }
    public void closeRight(){
        Right = view.findViewById(R.id.Right);
        Right.setVisibility(View.VISIBLE);
    }
    public void closeLeft(){
        L = view.findViewById(R.id.L);
        L.setVisibility(View.VISIBLE);
    }
}
