package stoyan.tris;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PVPGame extends AppCompatActivity {

    private Boolean gameEnd = false;
    private Integer xScore = 0;
    private Integer oScore = 0;
    private final String EMPTY = "";
    private final String X = "X";
    private final String O = "O";
    private final int X_WINS = 1;
    private final int O_WINS = -1;
    private int turn;//X=1, O=-1;
    private int moves = 0;
    private final int FREE_SPACE = 0;
    private final String VICTORY="ha vinto!";

    private String turnoDi;

    private int[] griglia = {
            FREE_SPACE,FREE_SPACE,FREE_SPACE,
            FREE_SPACE,FREE_SPACE,FREE_SPACE,
            FREE_SPACE,FREE_SPACE,FREE_SPACE
    };

    /*
     * Determina vittoria
     *
     *   0 | 1 | 2
     *  ---+---+---
     *   3 | 4 | 5
     *  ---+---+---
     *   6 | 7 | 8
     *
     */
    private final int[][][] lineeVincitrici = {
            {{1,2},{4,8},{3,6}},
            {{0,2},{4,7}},
            {{0,1},{4,6},{5,8}},
            {{4,5},{0,6}},
            {{3,5},{0,8},{2,6},{1,7}},
            {{3,4},{2,8}},
            {{7,8},{2,4},{0,3}},
            {{6,8},{1,4}},
            {{6,7},{0,4},{2,5}}
    };

    private void haVinto(int lastMove) {
        if(turn==1)turn=-1;else turn=1;
        griglia[lastMove] = turn;
        int[] linee;
        for (int i = 0; i < lineeVincitrici[lastMove].length; i++) {
            linee = lineeVincitrici[lastMove][i];
            if(turn == griglia[linee[0]] && turn == griglia[linee[1]]) {
                vinto();
                return ;
            }
        }
        // is it a draw?
        if(++moves==9) {
            turnoView.setText("DRAW");
        }
    }

    private void vinto() {
        gameEnd = true;
        if(turn==-1) {
            oScore++;
            p2Score.setText(oScore.toString());
            turnoView.setText(xPlayer.getText().toString().toUpperCase()+VICTORY);
        }else{
            xScore++;
            p1Score.setText(xScore.toString());
            turnoView.setText(oPlayer.getText().toString().toUpperCase()+VICTORY);
        }
    }

    private TextView turnoView,p1Score,p2Score,oPlayer,xPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pvpgame);
        turnoView = (TextView) findViewById(R.id.resultView);
        //p1Score = (TextView) findViewById(R.id.player1Score);
        //p2Score = (TextView) findViewById(R.id.player2Score);

        Intent i = getIntent();

        if((int)(Math.random()*2) == X_WINS) {
            turn = X_WINS;
            turnoView.setText(turnoDi + "X");
        }else{
            turn = O_WINS;
            turnoView.setText(turnoDi + "O");
        }
    }


    public void execute(View v){
        Button premuto = (Button) findViewById(v.getId());

        if(premuto.getText().toString() != EMPTY || gameEnd)
            return;

        premuto.setText(turn == X_WINS ? X : O);

        haVinto(Integer.parseInt(premuto.getTag().toString()));

        if (!gameEnd) {
            turnoView.setText(turn == X_WINS ? turnoDi + " " + oPlayer.getText().toString() : turnoDi + " "+ xPlayer.getText().toString());
            turn = -turn;
        }

    }

    public void resetGame(View v){
        gameEnd = false;
        turn=1;
        moves=0;
        
        Button aa = (Button) findViewById(R.id.aa);
        Button ab =(Button) findViewById(R.id.ab);
        Button tr = (Button) findViewById(R.id.ac);
        Button cs = (Button) findViewById(R.id.ba);
        Button cc = (Button) findViewById(R.id.bb);
        Button cr = (Button) findViewById(R.id.bc);
        Button bs = (Button) findViewById(R.id.ca);
        Button bc = (Button) findViewById(R.id.cb);
        Button br = (Button) findViewById(R.id.cc);

        aa.setText(EMPTY);
        ab.setText(EMPTY);
        tr.setText(EMPTY);
        cs.setText(EMPTY);
        cc.setText(EMPTY);
        cr.setText(EMPTY);
        bs.setText(EMPTY);
        bc.setText(EMPTY);
        br.setText(EMPTY);

        for (int i=0;i<griglia.length;i++){
            griglia[i] = FREE_SPACE;
        }

    }
}
