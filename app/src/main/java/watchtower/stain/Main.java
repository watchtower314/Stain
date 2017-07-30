package watchtower.stain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for the sake of commit


    }


    public void goToQuestionOne(View v)
    {

        /* only works with android level 16+
        Intent intent = new Intent(this, QuestionOne.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(QuestionThree.class);
        stackBuilder.addNextIntent(intent); //see if necessary
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(pendingIntent);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,builder.build());

        */
        ///PendingIntent pendingIntent =
            //    TaskStackBuilder.create(this).addNextIntentWithParentStack();
        Intent intent = new Intent(this, QuestionOne.class);
        startActivity(intent);
        //finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
