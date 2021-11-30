package com.zybooks.dickman_final_practical;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFragment extends Fragment {
    private static final String TAG = "Detail Fragment";
    private static String time_select_early;
    private static String cost;
    private static String time_select_late;
    private Band mBand;
    public static final String ARG_BAND_ID = "band_id";

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int bandId = 1;

        // Get the band ID from the fragment arguments
        Bundle args = getArguments();
        if (args != null) {
            bandId = args.getInt(ARG_BAND_ID);
        }

        // Get the selected band
        mBand = BandRepository.getInstance(requireContext()).getBand(bandId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if (mBand != null) {
            TextView nameTextView = rootView.findViewById(R.id.band_name);
            nameTextView.setText(mBand.getName());
            Toast.makeText(nameTextView.getContext(), "Information about "+mBand.getName()+" concert!", Toast.LENGTH_SHORT).show();
            TextView descriptionTextView = rootView.findViewById(R.id.band_description);
            TextView timeTextView = rootView.findViewById(R.id.band_time);
            descriptionTextView.setText(mBand.getDescription());
            timeTextView.setText(mBand.getTimes());
            Log.d(TAG, mBand.getTimes());
        }
        return rootView;
    }

//    private static void setEarlyDateTime(Band band) {
//        time_select_early = band.getDate(9, 28);
//    }
//
//    private static void setLateDateTime(Band band) {
//        time_select_late = band.getDate(30, 45);
//    }
//
//    public static String getEarlyDateTime() {
//        return time_select_early;
//    }
//
//    public static String getLateDateTime() {
//        return time_select_late;
//    }
//
//    private static void setCostTicket(Band band) {
//        cost = band.getCost();
//    }
//
//    public static String getCostTicket() {
//        return cost;
//    }
}


