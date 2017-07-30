package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuestionThree extends Activity {


    public static final String SEAN3 = "sean3";
    public static final String TOM3 = "tom3";
    public static final String RONI3 = "roni3";
    public int currSean3, currTom3, currRoni3, currOverAll;
    public static final String OVER_ALL3 = "overall3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currSean3 = Questionairre.graphPrefs.getInt(SEAN3, 0);
        currTom3 = Questionairre.graphPrefs.getInt(TOM3, 0);
        currRoni3 = Questionairre.graphPrefs.getInt(RONI3, 0);
        currOverAll = Questionairre.graphPrefs.getInt(OVER_ALL3, 0);
    }

    public void chooseCharacter(View v)
    {
        int id = v.getId();

        if(id == R.id.sean3 || id == R.id.seanName3)
        {
            Questionairre.updateSharedPref(SEAN3, currSean3+2, OVER_ALL3, ++currOverAll);
            System.out.println("sean increment");
        }
        else
        if(id == R.id.tom3 || id == R.id.tomName3)
        {
            Questionairre.updateSharedPref(TOM3, currTom3+2,  OVER_ALL3, ++currOverAll);
            System.out.println("tom increment");
        }
        else
        {
            Questionairre.updateSharedPref(RONI3, currRoni3+2,  OVER_ALL3, ++currOverAll);
            System.out.println("roni increment");
        }


        Intent intent = new Intent(this, GraphThree.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed() {
        //Log.d("TKT", "back press in questionThree");


        //Intent myIntent = new Intent(this, QuestionTwo.class);
        //startActivity(myIntent);
        //finish();

    }

}
