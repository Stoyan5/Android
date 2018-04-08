package com.killer.stoyan.tris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn;
    private Button resetButton;
    private int player;
    //1=X -1=O
    private int[] griglia= new int[9];
    /*
     *   0   1   2
     *   3   4   5
     *   6   7   8
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        resetButton=findViewById(R.id.resetButton);
        reset();
    }

    private int checkWin(){
        if(     griglia[0]==1&&griglia[1]==1&&griglia[2]==1||griglia[3]==1&&griglia[4]==1&&griglia[5]==1||griglia[6]==1&&griglia[7]==1&&griglia[8]==1||
                griglia[0]==1&&griglia[3]==1&&griglia[6]==1||griglia[1]==1&&griglia[4]==1&&griglia[7]==1||griglia[2]==1&&griglia[5]==1&&griglia[8]==1||
                griglia[0]==1&&griglia[4]==1&&griglia[8]==1||griglia[2]==1&&griglia[4]==1&&griglia[6]==1
                )return 1;
        else if(    griglia[0]==-1&&griglia[1]==-1&&griglia[2]==-1||griglia[3]==-1&&griglia[4]==-1&&griglia[5]==-1||griglia[6]==-1&&griglia[7]==-1&&griglia[8]==-1||
                    griglia[0]==-1&&griglia[3]==-1&&griglia[6]==-1||griglia[1]==-1&&griglia[4]==-1&&griglia[7]==-1||griglia[2]==-1&&griglia[5]==-1&&griglia[8]==-1||
                    griglia[0]==-1&&griglia[4]==-1&&griglia[8]==-1||griglia[2]==-1&&griglia[4]==-1&&griglia[6]==-1
                )return -1;
        else return 0;
    }

    public void onClickR(View view){
        reset();
    }

    private void reset(){
        for(int i=0;i<9;i++){
            griglia[i]=0;
        }
        TableLayout tableLayout=findViewById(R.id.tableLayout);
        for(int i=0;i<3;i++){
            TableRow tR = (TableRow) tableLayout.getChildAt(i);

            for(int j=0;j<3;j++){
                Button b=(Button) tR.getChildAt(j);
                b.setText("");
                b.setOnClickListener(new onClickSchisa());
            }
        }
        textView.setText("");
        player=1;
    }

    class onClickSchisa implements View.OnClickListener {
        public void onClick(View view) {
            btn = (Button) view;
            btn.setOnClickListener(null);//blocco bottone dopo schiacciato
            if (player == 1) {
                btn.setText("X");
                switch (view.getId()) {
                    case R.id.button:
                        griglia[0] = player;
                        break;
                    case R.id.button2:
                        griglia[1] = player;
                        break;
                    case R.id.button3:
                        griglia[2] = player;
                        break;
                    case R.id.button4:
                        griglia[3] = player;
                        break;
                    case R.id.button5:
                        griglia[4] = player;
                        break;
                    case R.id.button6:
                        griglia[5] = player;
                        break;
                    case R.id.button7:
                        griglia[6] = player;
                        break;
                    case R.id.button8:
                        griglia[7] = player;
                        break;
                    case R.id.button9:
                        griglia[8] = player;
                        break;
                    default:
                        break;
                }
                player = -1;
            }else {
                btn.setText("O");
                switch (view.getId()) {
                    case R.id.button:
                        griglia[0] = player;
                        break;
                    case R.id.button2:
                        griglia[1] = player;
                        break;
                    case R.id.button3:
                        griglia[2] = player;
                        break;
                    case R.id.button4:
                        griglia[3] = player;
                        break;
                    case R.id.button5:
                        griglia[4] = player;
                        break;
                    case R.id.button6:
                        griglia[5] = player;
                        break;
                    case R.id.button7:
                        griglia[6] = player;
                        break;
                    case R.id.button8:
                        griglia[7] = player;
                        break;
                    case R.id.button9:
                        griglia[8] = player;
                        break;
                    default:
                        break;
                }
                player = 1;
            }
            if(checkWin()==1)textView.setText("X won!");
            else if(checkWin()==-1)textView.setText("O won!");
        }
    }
}