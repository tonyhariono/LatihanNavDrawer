package id.co.imastudio.latihannavdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor
    }

    Button btnGallery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View fragmentView=inflater.inflate(R.layout.fragment_gallery, container, false);

        btnGallery=(Button) fragmentView.findViewById(R.id.btnGallery);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda akan melihat Gallery", Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return fragmentView;


    }

}
