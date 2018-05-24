package com.killer.stoyan.labirinth;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Labyrinth maze;
    View view;

    int currentX;
    int currentY;
    Room[][] map;

    final static float MIN_DISTANCE = 150.0f;
    float x1;
    float y1;
    float x2;
    float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentRoom f1 = new FragmentRoom();
        maze = new Labyrinth();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        textView = view.findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        ft.replace(R.id.maze, f1);//wtf?
        new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
    }

    /*public void prova(View view){
        switch(view.getId()){
            case R.id.left:
                if(map[currentY][currentX].hasRight()) {
                    currentX=currentX+1;
                    FragmentRoom f1 = new FragmentRoom();
                    new Thread(() -> runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                }
                break;
            case R.id.right:
                if(map[currentY][currentX].hasLeft()) {
                    currentX=currentX-1;
                    FragmentRoom f1 = new FragmentRoom();
                    new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                }
                break;
            case R.id.down:
                if(map[currentY][currentX].hasBottom()) {
                    currentY=currentY+1;
                    FragmentRoom f1 = new FragmentRoom();
                    new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                }
                break;
            case R.id.up:
                if(map[currentY][currentX].hasTop()) {
                    currentY=currentY-1;
                    FragmentRoom f1 = new FragmentRoom();
                    new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                }
                break;
        }
        if(map[currentY][currentX].isExit()) textView.setVisibility(View.VISIBLE);
    }*/

    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                float deltaX = x2 - x1;
                float deltaY = y2 - y1;
                if (Math.abs(deltaX) > MIN_DISTANCE && Math.abs(deltaX) > Math.abs(deltaY)) {
                    if (x2 > x1) {
                        Toast.makeText(this, "LEFT", Toast.LENGTH_SHORT).show ();
                        if(map[currentY][currentX].hasLeft()) {
                            currentX=currentX-1;
                            FragmentRoom f1 = new FragmentRoom();
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.maze, f1);
                            ft.commit();
                            new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                        }
                    }else{
                        Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show ();
                        if(map[currentY][currentX].hasRight()) {
                            currentX=currentX+1;
                            FragmentRoom f1 = new FragmentRoom();
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.maze, f1);
                            ft.commit();
                            new Thread(() -> runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                        }
                    }
                } else if(Math.abs(deltaY) > MIN_DISTANCE && Math.abs(deltaY) > MIN_DISTANCE){
                    if (y2 > y1) {
                        Toast.makeText(this, "UP", Toast.LENGTH_SHORT).show ();
                        if(map[currentY][currentX].hasTop()) {
                            currentY=currentY-1;
                            FragmentRoom f1 = new FragmentRoom();
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.maze, f1);
                            ft.commit();
                            new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                        }
                    }else{
                        Toast.makeText(this, "DOWN", Toast.LENGTH_SHORT).show ();
                        if(map[currentY][currentX].hasBottom()) {
                            currentY=currentY+1;
                            FragmentRoom f1 = new FragmentRoom();
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.maze, f1);
                            ft.commit();
                            new Thread(()->runOnUiThread(() -> f1.showRoom(map[currentY][currentX]))).start();
                        }
                    }
                }else{
                    Toast.makeText(this, "TAP", Toast.LENGTH_SHORT).show ();
                }
                break;
        }
        return super.onTouchEvent(event);
    }


    public static class Labyrinth {

        int currentX;
        int currentY;
        Room[][] map;

        public Labyrinth(){
            createDefault();
        }
        public void createDefault(){
            /*map MISSING TBL class not used
                    E,E,E,E,E,IB,E,E,E,E,E,E;
                    RB,RBL,RL,L,RB,TRBL,RBL,RL,RL,RBL,BL,E;
                    TB,TB,RB,RL,BL,TB,TB,Right,BL,TB,TB,E;
                    T,TRL,TL,RB,RL,TRL,TRL,BL,TR,TL,TB,E;
                    RB,TRL,TRBL,TRL,RL,RBL,BL,TR,RL,RL,TLE;
                    TB,B,TB,RB,L,TB,TR,RL,BL,RB,L,E;
                    T,TRL,TRBL,TRBL,RL,TL,B,Right,TL,TB,RB,FL;
                    RB,TL,TB,TB,RB,BL,TR,RBL,RL,TL,TB,E;
                    TRB,RL,TRL,TRBL,TRL,TL,B,TR,RL,RBL,TL,E;
                    TB,RB,RL,TRBL,RL,BL,TRB,TRL,RL,TBL,B,E;
                    TB,T,E,TB,E,TRB,TRL,TL,B,T,TB,E;
                    TR,RL,RL,TRL,L,TR,RL,RL,TRL,RL,TL,E;
             */
            //create map
            Room[][] map=new Room[12][12];
            //first row...
            map[1][1]= new E();
            map[1][2]= new E();
            map[1][3]= new E();
            map[1][4]= new E();
            map[1][5]= new IB();
            map[1][6]= new E();
            map[1][7]= new E();
            map[1][8]= new E();
            map[1][9]= new E();
            map[1][10]= new E();
            map[1][11]= new E();
            map[1][12]= new E();

            map[2][1]= new RB();
            map[2][2]= new RBL();
            map[2][3]= new RL();
            map[2][4]= new L();
            map[2][5]= new RB();
            map[2][6]= new TRBL();
            map[2][7]= new RBL();
            map[2][8]= new RL();
            map[2][9]= new RL();
            map[2][10]= new RBL();
            map[2][11]= new BL();
            map[2][12]= new E();

            map[2][1]= new TB();
            map[2][2]= new TB();
            map[2][3]= new RB();
            map[2][4]= new RL();
            map[2][5]= new BL();
            map[2][6]= new TB();
            map[2][7]= new TB();
            map[2][8]= new Right();
            map[2][9]= new BL();
            map[2][10]= new TB();
            map[2][11]= new TB();
            map[2][12]= new E();

            map[2][1]= new T();
            map[2][2]= new TRL();
            map[2][3]= new TL();
            map[2][4]= new RB();
            map[2][5]= new RL();
            map[2][6]= new TRL();
            map[2][7]= new TRL();
            map[2][8]= new BL();
            map[2][9]= new TR();
            map[2][10]= new TL();
            map[2][11]= new TB();
            map[2][12]= new E();

            map[2][1]= new RB();
            map[2][2]= new TRL();
            map[2][3]= new TRBL();
            map[2][4]= new TRL();
            map[2][5]= new RL();
            map[2][6]= new RBL();
            map[2][7]= new BL();
            map[2][8]= new TR();
            map[2][9]= new RL();
            map[2][10]= new RL();
            map[2][11]= new TL();
            map[2][12]= new E();

            map[2][1]= new TB();
            map[2][2]= new B();
            map[2][3]= new TB();
            map[2][4]= new RB();
            map[2][5]= new L();
            map[2][6]= new TB();
            map[2][7]= new TR();
            map[2][8]= new RL();
            map[2][9]= new BL();
            map[2][10]= new RB();
            map[2][11]= new L();
            map[2][12]= new E();

            map[2][1]= new T();
            map[2][2]= new TRL();
            map[2][3]= new TRBL();
            map[2][4]= new TRBL();
            map[2][5]= new RL();
            map[2][6]= new TL();
            map[2][7]= new B();
            map[2][8]= new Right();
            map[2][9]= new TL();
            map[2][10]= new TB();
            map[2][11]= new RB();
            map[2][12]= new FL();


            currentX=5;
            currentY=1;
        }

    }
}
