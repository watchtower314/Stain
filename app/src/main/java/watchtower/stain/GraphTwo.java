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


    public int currTeacher2, currParents2, currFriends2, currOther2;

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


        teachersBar = (ImageView)findViewById(R.id.teacherBar1);
        parentsBar = (ImageView)findViewById(R.id.parentBar1);
        friendsBar = (ImageView)findViewById(R.id.friendsBar1);
        otherBar = (ImageView)findViewById(R.id.otherBar1);
        updateBarEntries();

    }



    public void updateBarEntries()
    {


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
