package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GraphOne extends Activity {


    public int currSean1, currTom1, currRoni1, currOverAll;
    ImageView seanBar, tomBar, roniBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_one);


        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currSean1 = Questionairre.graphPrefs.getInt(QuestionOne.SEAN1, 0);
        currTom1 = Questionairre.graphPrefs.getInt(QuestionOne.TOM1, 0);
        currRoni1 = Questionairre.graphPrefs.getInt(QuestionOne.RONI1, 0);
        currOverAll = Questionairre.graphPrefs.getInt(QuestionOne.OVER_ALL1, 0);

        seanBar = (ImageView)findViewById(R.id.seanBar1);
        tomBar = (ImageView)findViewById(R.id.tomBar1);
        roniBar = (ImageView)findViewById(R.id.roniBar1);
        updateBarEntries();

    }

    public void updateBarEntries()
    {
        double temp;
        Log.d("overall: ", ""+currOverAll);
        Log.d("tomBar: ", ""+currTom1);
        Log.d("roniBar: ", ""+currRoni1);

        if(currSean1!=0) {
            temp = (currSean1 * 100) / currOverAll;
            seanBar.getLayoutParams().height = (int) temp + 300;//((currSean1%currOverAll)*10)%100;
            Log.d("seanBar: ", "" + temp);
        }
        else
            seanBar.getLayoutParams().height = 0;

        if(currTom1!=0) {
            temp = (currTom1 * 100) / currOverAll;
            tomBar.getLayoutParams().height = (int) temp + 300;//((currTom1%currOverAll)*100)%100;
            Log.d("tomBar: ", "" + temp);
        }
        else
            tomBar.getLayoutParams().height = 0;

        if(currRoni1!=0) {
            temp = (currRoni1 * 100) / currOverAll;
            roniBar.getLayoutParams().height = (int) temp + 300;//((currRoni1%currOverAll)*100)%100;
            Log.d("roniBar: ", "" + temp);
        }
        else
            roniBar.getLayoutParams().height = 0;

        /*
        Log.d("UpdateBarEmtries","sean: "+currSean1 );
        if(currSean1 <= Questionairre.maxHeight)
            seanBar.getLayoutParams().height = currSean1;
        else
            seanBar.getLayoutParams().height = Questionairre.maxHeight;
        seanBar.requestLayout();

        if(currTom1 <= Questionairre.maxHeight)
            tomBar.getLayoutParams().height = currTom1;
        else
            tomBar.getLayoutParams().height = Questionairre.maxHeight;
        tomBar.requestLayout();

        if(currRoni1 <= Questionairre.maxHeight)
            roniBar.getLayoutParams().height = currRoni1;
        else
            tomBar.getLayoutParams().height = Questionairre.maxHeight;
        roniBar.requestLayout();

        */

    }


    public void nextQuestion(View v)
    {
        Intent intent = new Intent(this, QuestionTwo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void backQuestion(View v)
    {
        Intent intent = new Intent(this, QuestionOne.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Log.d("TKT", "back press in graphOne");

    }
}
