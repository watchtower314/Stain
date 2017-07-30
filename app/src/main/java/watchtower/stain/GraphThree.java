package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class GraphThree extends Activity {

    public int currSean3, currTom3, currRoni3;
    ImageView seanBar3, tomBar3, roniBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_three);

        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currSean3 = Questionairre.graphPrefs.getInt(QuestionThree.SEAN3, 0);
        currTom3 = Questionairre.graphPrefs.getInt(QuestionThree.TOM3, 0);
        currRoni3 = Questionairre.graphPrefs.getInt(QuestionThree.RONI3, 0);

        seanBar3 = (ImageView)findViewById(R.id.seanBar3);
        tomBar3 = (ImageView)findViewById(R.id.tomBar3);
        roniBar3 = (ImageView)findViewById(R.id.roniBar3);
        updateBarEntries();
    }

    public void updateBarEntries()
    {


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
