package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuestionOne extends Activity {



    public static final String SEAN1 = "sean1";
    public static final String TOM1 = "tom1";
    public static  final String RONI1 = "roni1";
    public int currSean1, currTom1, currRoni1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        Questionairre.graphPrefs = getSharedPreferences(Questionairre.QUESTION_GRAPH,0);
        currSean1 = Questionairre.graphPrefs.getInt(SEAN1, 0);
        currTom1 = Questionairre.graphPrefs.getInt(TOM1, 0);
        currRoni1 = Questionairre.graphPrefs.getInt(RONI1, 0);


    }

    public void chooseCharacter(View v)
    {
        int id = v.getId();
        System.out.println("inChooseChar");

        if(v.getId() == R.id.sean || v.getId() == R.id.seanName)
        {
            Log.d("ChooseChar","sean: "+currSean1 );
            Questionairre.updateSharedPref(SEAN1, currSean1+2);

        }
        else
            if(id == R.id.tom || id == R.id.tomName)
            {
                Log.d("ChooseChar","tom: "+currTom1 );
                Questionairre.updateSharedPref(TOM1, currTom1+2);
                System.out.println("tom increment");
            }
            else
            {
                Log.d("ChooseChar","roni: "+currRoni1 );
                Questionairre.updateSharedPref(RONI1, ++currRoni1+2);
                System.out.println("roni increment");
            }


        Intent intent = new Intent(this, GraphOne.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed() {
        //Intent myIntent = new Intent(this, QuestionThree.class);
        //startActivity(myIntent);
        //finish();
    }

}
