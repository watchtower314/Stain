package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class GraphThree extends Activity {

    public int currSean3, currTom3, currRoni3, currOverAll3;
    ImageView seanBar3, tomBar3, roniBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_three);

        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currSean3 = Questionairre.graphPrefs.getInt(QuestionThree.SEAN3, 0);
        currTom3 = Questionairre.graphPrefs.getInt(QuestionThree.TOM3, 0);
        currRoni3 = Questionairre.graphPrefs.getInt(QuestionThree.RONI3, 0);
        currOverAll3 = Questionairre.graphPrefs.getInt(QuestionThree.OVER_ALL3, 0);

        seanBar3 = (ImageView)findViewById(R.id.seanBar3);
        tomBar3 = (ImageView)findViewById(R.id.tomBar3);
        roniBar3 = (ImageView)findViewById(R.id.roniBar3);
        updateBarEntries();
    }

    public void updateBarEntries()
    {

        double temp;
        Log.d("overall: ", ""+currOverAll3);

        Log.d("tomBar: ", ""+currTom3);
        Log.d("roniBar: ", ""+currRoni3);

        if(currSean3!=0) {
            temp = (currSean3 * 100) / currOverAll3;
            seanBar3.getLayoutParams().height = (int) temp + 300;//((currSean1%currOverAll)*10)%100;
            Log.d("seanBar: ", "" + temp);
        }
        else
            seanBar3.getLayoutParams().height = 0;

        if(currTom3!=0) {
            temp = (currTom3 * 100) / currOverAll3;
            tomBar3.getLayoutParams().height = (int) temp + 300;//((currTom1%currOverAll)*100)%100;
            Log.d("tomBar: ", "" + temp);
        }
        else
            tomBar3.getLayoutParams().height = 0;

        if(currRoni3!=0) {
            temp = (currRoni3 * 100) / currOverAll3;
            roniBar3.getLayoutParams().height = (int) temp + 300;//((currRoni1%currOverAll)*100)%100;
            Log.d("roniBar: ", "" + temp);
        }
        else
            roniBar3.getLayoutParams().height = 0;

        /*
        if(currSean3<= Questionairre.maxHeight)
            seanBar3.getLayoutParams().height = currSean3;
        else
            seanBar3.getLayoutParams().height = Questionairre.maxHeight;
        seanBar3.requestLayout();

        if(currTom3 <= Questionairre.maxHeight)
            tomBar3.getLayoutParams().height = currTom3;
        else
            tomBar3.getLayoutParams().height = Questionairre.maxHeight;
        tomBar3.requestLayout();

        if(currRoni3 <= Questionairre.maxHeight)
            roniBar3.getLayoutParams().height = currRoni3;
        else
            tomBar3.getLayoutParams().height = Questionairre.maxHeight;
        roniBar3.requestLayout();
        */

    }

    public void nextQuestion(View v)
    {
        Intent intent = new Intent(this, QuestionOne.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void backQuestion3(View v)
    {
        Log.d("TKT", "went back");
        Intent intent = new Intent(this, QuestionThree.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Log.d("TKT", "back press in graphThree");

    }


}
