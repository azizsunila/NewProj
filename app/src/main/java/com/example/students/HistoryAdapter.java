package com.example.students;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<HistoryItem> historyItems;

    public HistoryAdapter(List<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }

    public void setHistoryItems(List<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        HistoryItem item = historyItems.get(position);

        holder.tvStudentName.setText(item.getStudentName());
        holder.tvSubject.setText(item.getSubject());
        holder.tvTimestamp.setText(item.getTimestamp());
        holder.tvStatus.setText(item.getStatus());

        // Set status badge color and icon
        switch (item.getStatus().toUpperCase()) {
            case "PRESENT":
                holder.statusIconContainer.setBackgroundResource(R.drawable.bg_status_present);
                holder.tvStatusIcon.setText("✓");
                holder.tvStatus.setBackgroundResource(R.drawable.bg_text_present);
                holder.tvStatus.setTextColor(0xFF10B981);
                break;
            case "ABSENT":
                holder.statusIconContainer.setBackgroundResource(R.drawable.bg_status_absent);
                holder.tvStatusIcon.setText("✗");
                holder.tvStatus.setBackgroundResource(R.drawable.bg_text_absent);
                holder.tvStatus.setTextColor(0xFFEF4444);
                break;
            case "LATE":
                holder.statusIconContainer.setBackgroundResource(R.drawable.bg_status_late);
                holder.tvStatusIcon.setText("⏰");
                holder.tvStatus.setBackgroundResource(R.drawable.bg_text_late);
                holder.tvStatus.setTextColor(0xFFF59E0B);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudentName, tvSubject, tvTimestamp, tvStatus, tvStatusIcon;
        LinearLayout statusIconContainer;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvStatusIcon = itemView.findViewById(R.id.tvStatusIcon);
            statusIconContainer = itemView.findViewById(R.id.status_icon_container);
        }
    }
}
