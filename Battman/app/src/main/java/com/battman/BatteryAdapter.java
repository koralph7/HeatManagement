package com.battman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BatteryAdapter extends RecyclerView.Adapter<BatteryAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final View mView;
        public final TextView name;
        public final TextView numCel2V;
        public final TextView alarm;
        public Battery battery;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            name = itemView.findViewById(R.id.battery_name);
            numCel2V = itemView.findViewById(R.id.num_of_cell2v);
            alarm = itemView.findViewById(R.id.alarm1);
        }
    }

    private BatteryFragment mbatteryFrag;
    private List<Battery>mBatteries;

    public BatteryAdapter(BatteryFragment batteryFragment, List<Battery> batteries) {
        mbatteryFrag = batteryFragment;
        mBatteries = batteries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_battery_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Battery battery = mBatteries.get(position);
        holder.name.setText(battery.getName());
        holder.numCel2V.setText(battery.getNumOfCel2V());
        holder.alarm.setText(battery.getAlarm1());
        holder.battery = battery;
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mbatteryFrag.onItemSelected(battery);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBatteries.size();
    }
}
