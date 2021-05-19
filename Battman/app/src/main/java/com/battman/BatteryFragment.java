package com.battman;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.battman.api.AbstractApiListener;

import java.util.List;


public class BatteryFragment extends Fragment {

    private OnFragmentInteractionListener listener;


    public BatteryFragment() {
        // Required empty public constructor
    }


    public static BatteryFragment newInstance() {
        BatteryFragment fragment = new BatteryFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void onItemSelected(Battery battery){
        if(listener != null){
            listener.onItemSelected(battery);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_battery, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(view instanceof RecyclerView){
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            DividerItemDecoration decoration = new DividerItemDecoration(context,
                    DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(decoration);

            Application application = this.getActivity().getApplication();
            Model model = Model.getInstance(application);
            final List<Battery> batteries = model.getBatteries();

            final BatteryAdapter adapter = new BatteryAdapter(this, batteries);
            recyclerView.setAdapter(adapter);

            model.loadBatteries(new AbstractApiListener() {
                @Override
                public void onBatteriesLoaded(List<Battery> loadedBatteries) {
                    batteries.clear();
                    batteries.addAll(loadedBatteries);
                    adapter.notifyDataSetChanged();
                }


            });


        }

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        }
        else {
            throw new RuntimeException(context.toString() + "must implement" +
                    " OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener{
        void onItemSelected(Battery battery);
    }
}