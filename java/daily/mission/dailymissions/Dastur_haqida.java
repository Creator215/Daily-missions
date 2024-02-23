package daily.mission.dailymissions;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class Dastur_haqida extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    ImageButton dastur_haqida_back_button;
    AppCompatButton dastur_haqida_ok_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dastur_haqida, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);

        frameLayout = view2.findViewById(R.id.frame_layout);

        dastur_haqida_back_button = view.findViewById(R.id.dastur_haqida_back_button);
        dastur_haqida_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        dastur_haqida_ok_button = view.findViewById(R.id.dastur_haqida_ok_button);
        dastur_haqida_ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }
}