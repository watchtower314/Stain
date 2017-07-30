package watchtower.stain;

import android.content.SharedPreferences;

/**
 * Created by Moore on 7/26/2017.
 */

public class Questionairre {
    public static final String QUESTION_GRAPH = "Graphs";
    public static SharedPreferences graphPrefs;
    public static SharedPreferences.Editor graphEdit;
    public static final int maxHeight = 550;

    public static void updateSharedPref(String nameNQ, int num)
    {
        graphEdit = graphPrefs.edit();
        graphEdit.putInt(nameNQ,num);
        graphEdit.commit();
    }

}
