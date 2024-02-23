package daily.mission.dailymissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static FrameLayout frameLayout;
    public static RelativeLayout g_layout;
    public static String job_title_t = "";
    public static String job_clock_t = "";
    public static String job_minut_t = "";
    public static Boolean is_okey;
    public static String job_month_t = "";
    public static String job_day_t = "";
    public static Boolean is_create = true;
    public static final String now_date = "now_date.txt";
    public static final String user_name = "user_name.txt";
    public static final String statistika = "statistika.txt";
    public static int vaziyat = 0;
    public static final String avatar = "avatar.txt";
    public static final String background = "background.txt";
    public static final String password = "pin.txt";
    public static Application application;
    public static final String kun_tartib = "kun_tartib.txt";
    public static final String rejalar = "rejalar.txt";
    public static String[][] Kun_Tartib,Rejalar,Rejalar_Bajarilgan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotifiChannel();

        g_layout = findViewById(R.id.g_layout);
        frameLayout =  findViewById(R.id.frame_layout);
        application = getApplication();
        GetDate getDate = new GetDate();
        try{
            if(read_file(now_date).hashCode() != getDate.get().hashCode()){

                write_file(getDate.get(),now_date,MODE_PRIVATE);
                String new_day = read_file(kun_tartib).replace("true","false");
                write_file(new_day,kun_tartib,MODE_PRIVATE);
                String new_stats = "&<"+getDate.get()+"><0%>";
                write_file(new_stats,statistika,MODE_APPEND);
            }

        }catch (Exception exception){
            write_file("&<"+getDate.get()+"><0%>",statistika,MODE_PRIVATE);
            write_file(getDate.get(),now_date,MODE_PRIVATE);
        }
        try{
            read_file(statistika);
        }catch (Exception e){
            write_file("",statistika,MODE_PRIVATE);
        }
        try{
            Data_Reder dataReder = new Data_Reder(read_file(kun_tartib));
            Kun_Tartib = dataReder.getData().clone();
        }catch (Exception e){
            write_file("",kun_tartib,MODE_PRIVATE);
        }

        try{
            Big_Data_Reder bigDataReder = new Big_Data_Reder(read_file(rejalar));
            Rejalar = bigDataReder.getData().clone();
        }catch (Exception e){
            write_file("",rejalar,MODE_PRIVATE);
        }

        try{
            read_file(user_name);
        }catch (Exception exception){
            write_file("User name",user_name,MODE_PRIVATE);
        }

        try{
            read_file(avatar);
        }catch (Exception exception){
            write_file("1",avatar,MODE_PRIVATE);
        }

        try{
            String back = read_file(background);
            switch (back){
                case "1":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_0);
                    break;
                case "2":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_1);
                    break;
                case "3":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_2);
                    break;
                case "4":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_3);
                    break;
                case "5":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_4);
                    break;
                case "6":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_5);
                    break;
                case "7":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_6);
                    break;
                case "8":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_7);
                    break;
                case "9":
                    MainActivity.g_layout.setBackgroundResource(R.drawable.back_8);
                    break;
            }
        }catch (Exception exception){
            write_file("1",background,MODE_PRIVATE);
        }

        try{
            if(read_file(password).hashCode() == "****".hashCode()){
                vaziyat = 0;
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                try {
                    fragmentTransaction.replace(frameLayout.getId(), Home_fragment.class.newInstance());
                    fragmentTransaction.commit();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                FragmentManager fragmentManager = getSupportFragmentManager();
                vaziyat = 1;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                try {
                    fragmentTransaction.replace(frameLayout.getId(), Parol.class.newInstance());
                    fragmentTransaction.commit();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch (Exception exception){
            write_file("****",password,MODE_PRIVATE);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            try {
                fragmentTransaction.replace(frameLayout.getId(), Home_fragment.class.newInstance());
                fragmentTransaction.commit();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createNotifiChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence charSequence = "foxandroidReminderChanel";
            String description = "Channel for Alarm manager";
            int Importanse = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel("notf_channel",charSequence,Importanse);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);


        }
    }

    private void write_file(@NonNull String data, String file_name,int Types){
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(file_name,Types);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private String read_file(String file_name){
        FileInputStream fis = null;
        String data = "";

        try {
            fis = openFileInput(file_name);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb  = new StringBuilder();

            String text = "";

            while((text = br.readLine()) != null){
                sb.append(text);
            }
            data = sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return data;
    }
}