package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class QuestionTwo extends Activity {

    public static final String OTHER2 = "other2";
    public static final String FRIENDS2 = "friends2";
    public static final String PARENTS2 = "parents2";
    public static final String TEACHER2 = "teacher2";

    public int currOther2, currFriends2, currParents2, currTeacher2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currOther2 = Questionairre.graphPrefs.getInt(OTHER2, 0);
        currFriends2 = Questionairre.graphPrefs.getInt(FRIENDS2, 0);
        currParents2 = Questionairre.graphPrefs.getInt(PARENTS2, 0);
        currTeacher2 = Questionairre.graphPrefs.getInt(TEACHER2, 0);


    }

    public void chooseCharacter(View v)
    {
        int id = v.getId();

        if(id == R.id.other || id == R.id.otherName)
        {
            Log.d("TKT" ," IN TEACHER");
            Questionairre.updateSharedPref(OTHER2, currOther2+2);
        }
        else
        if(id == R.id.friends || id == R.id.friendsName)
        {
            Log.d("TKT" ," IN TEACHER");
            Questionairre.updateSharedPref(FRIENDS2, currFriends2+2);
        }
        else
            if(id == R.id.parents || id == R.id.parentsName) {
                Log.d("TKT" ," IN TEACHER");
                Questionairre.updateSharedPref(PARENTS2, currParents2+2);
            }
            else
            {
                Log.d("TKT" ," IN TEACHER");
                Questionairre.updateSharedPref(TEACHER2, currTeacher2+2);
            }


        //TODO: open graph
        Intent intent = new Intent(this, GraphTwo.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed() {
        Log.d("TKT", "back press in questionTwo");
        //super.onBackPressed();
        //NavUtils.navigateUpFromSameTask(this);
        //Intent myIntent = new Intent(this, QuestionOne.class);
        //startActivity(myIntent);
        //finish();

    }

}
