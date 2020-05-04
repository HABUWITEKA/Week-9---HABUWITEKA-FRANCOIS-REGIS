package com.example.amamenyesha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String Channel_id="Personal Notification";
    private final int Notification_id = 1717;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void viewnotification(View view){
        createNotificationchannel();
        Intent landingintent = new Intent(this,Landing.class);
        landingintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent landingpt = PendingIntent.getActivity(this,0,landingintent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Channel_id);
        builder.setSmallIcon(R.drawable.notificationimg);
        builder.setContentTitle("Amamenyesha");
        builder.setContentText("Uramenyeshwa ko ifatabuguzi ryawe ryarangiye");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);


        builder.setContentIntent(landingpt);
        builder.setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(Notification_id,builder.build());
    }
    private  void createNotificationchannel(){
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
            CharSequence name = "Amamenyesha y'umuntu";
            String description = "Garagaza amamenyesha yose";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel NC = new NotificationChannel(Channel_id, name, importance);
            NC.setDescription(description);

            NotificationManager NM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            NM.createNotificationChannel(NC);

        }
    }

}
