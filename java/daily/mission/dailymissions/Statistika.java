package daily.mission.dailymissions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Statistika extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    ImageButton statistika_back_button;
    LinearLayout item_list;
    ImageButton clear_sts;

    AlertDialog.Builder builder;

    int yes = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_statistika, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        frameLayout = view2.findViewById(R.id.frame_layout);
        clear_sts = view.findViewById(R.id.clear_sts);
        builder = new AlertDialog.Builder(getContext());
        clear_sts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Diqqat")
                        .setCancelable(true)
                        .setMessage("Barcha statistika ma'lumotlari tozalansinmi?")
                        .setPositiveButton("Ha", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GetDate getDate = new GetDate();
                                String new_stats = "&<"+getDate.get()+"><0%>";
                                write_file(new_stats,MainActivity.statistika);
                                getActivity().onBackPressed();
                            }
                        })
                        .setNegativeButton("Yo'q", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();
            }
        });
        item_list = view.findViewById(R.id.item_list);


        Data_Reder dataReder = new Data_Reder(read_file(MainActivity.kun_tartib));
        String[][] mass = dataReder.getData().clone();

        for(int i = 0;i < dataReder.getSize();i ++){
            if(mass[i][0].hashCode() == "true".hashCode()){
                yes ++;
            }
        }

        GetDate getDate = new GetDate();

        Small_Data_Reder smallDataReder = new Small_Data_Reder(read_file(MainActivity.statistika));

        float prs;
        if(dataReder.getSize() == 0){
            prs = (Float.valueOf(0)/Float.valueOf(1)*100);
        }
        else {
            prs = (Float.valueOf(yes)/Float.valueOf(dataReder.getSize())*100);
        }

        DecimalFormat df = new DecimalFormat("0.0");

        String old_data = "&<"+smallDataReder.getData()[smallDataReder.getSize()-1][0]+"><"+smallDataReder.getData()[smallDataReder.getSize()-1][1]+">";

        String data = "&<"+getDate.get()+"><"+ df.format(prs)+"%>";

        String new_data = read_file(MainActivity.statistika).replace(old_data,data);

        write_file(new_data,MainActivity.statistika);

        String d = read_file(MainActivity.statistika);

        Small_Data_Reder smallDataReder1 = new Small_Data_Reder(d);

        for(int i = 0;i < smallDataReder.getSize();i ++){
            Statistika_item statistikaItem = new Statistika_item(smallDataReder1.getData()[i][0],smallDataReder1.getData()[i][1]);
            statistikaItem.create(getContext(),item_list);
        }

        statistika_back_button = view.findViewById(R.id.statistika_back_button);
        statistika_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return view;
    }

    private void write_file(String data,String file_name){
        FileOutputStream fos = null;

        try {
            fos = MainActivity.application.openFileOutput(file_name, Context.MODE_PRIVATE);
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
            fis = MainActivity.application.openFileInput(file_name);
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