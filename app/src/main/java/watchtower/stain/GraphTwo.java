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
public class GraphTwo extends Activity {


    public int currTeacher2, currParents2, currFriends2, currOther2, currOverAll2;

    ImageView teachersBar, parentsBar, friendsBar, otherBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_two);

        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currTeacher2 = Questionairre.graphPrefs.getInt(QuestionTwo.TEACHER2, 0);
        currParents2 = Questionairre.graphPrefs.getInt(QuestionTwo.PARENTS2, 0);
        currFriends2 = Questionairre.graphPrefs.getInt(QuestionTwo.FRIENDS2, 0);
        currOther2 = Questionairre.graphPrefs.getInt(QuestionTwo.OTHER2, 0);
        currOverAll2 = Questionairre.graphPrefs.getInt(QuestionTwo.OVER_ALL2, 0);


        teachersBar = (ImageView)findViewById(R.id.teacherBar1);
        parentsBar = (ImageView)findViewById(R.id.parentBar1);
        friendsBar = (ImageView)findViewById(R.id.friendsBar1);
        otherBar = (ImageView)findViewById(R.id.otherBar1);
        updateBarEntries();

    }



    public void updateBarEntries()
    {
        double temp;
        Log.d("overall2: ", ""+currOverAll2);

        if(currTeacher2!=0) {
            temp = (currTeacher2 * 100) / currOverAll2;
            teachersBar.getLayoutParams().height = (int) temp + 2000;//((currSean1%currOverAll)*10)%100;
            Log.d("seanBar: ", "" + temp);
        }
        else
            teachersBar.getLayoutParams().height = 0;


        if(currParents2!=0) {
            temp = (currParents2 * 100) / currOverAll2;
            parentsBar.getLayoutParams().height = (int) temp + 200;//((currTom1%currOverAll)*100)%100;
            Log.d("tomBar: ", "" + temp);
        }
        else
            parentsBar.getLayoutParams().height = 0;


        if(currFriends2!=0) {
            temp = (currFriends2 * 100) / currOverAll2;
            friendsBar.getLayoutParams().height = (int) temp + 200;//((currRoni1%currOverAll)*100)%100;
            Log.d("roniBar: ", "" + temp);
        }
        else
            friendsBar.getLayoutParams().height = 0;

        if(currOther2!=0) {
            temp = (currOther2 * 100) / currOverAll2;
            otherBar.getLayoutParams().height = (int) temp + 200;//((currRoni1%currOverAll)*100)%100;
            Log.d("roniBar: ", "" + temp);
        }
        else
            otherBar.getLayoutParams().height = 0;

        /*
        if(currTeacher2 <= Questionairre.maxHeight)
            teachersBar.getLayoutParams().height = currTeacher2;
        else
            teachersBar.getLayoutParams().height = Questionairre.maxHeight;
        teachersBar.requestLayout();

        //------------------------------

        if(currParents2 <= Questionairre.maxHeight)
            parentsBar.getLayoutParams().height = currParents2;
        else
            parentsBar.getLayoutParams().height = Questionairre.maxHeight;
        parentsBar.requestLayout();

        //-------------------------------

        if(currFriends2 <= Questionairre.maxHeight)
            friendsBar.getLayoutParams().height = currFriends2;
        else
            friendsBar.getLayoutParams().height = Questionairre.maxHeight;
        friendsBar.requestLayout();

        if(currOther2 <= Questionairre.maxHeight)
            otherBar.getLayoutParams().height = currOther2;
        else
            otherBar.getLayoutParams().height = Questionairre.maxHeight;
        otherBar.requestLayout();
        */

    }


    public void nextQuestion(View v)
    {
        Intent intent = new Intent(this, QuestionThree.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void backQuestion(View v)
    {
        Intent intent = new Intent(this, QuestionTwo.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Log.d("TKT", "back press in graphTwo");

    }

}
