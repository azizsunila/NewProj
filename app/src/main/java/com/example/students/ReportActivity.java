package com.example.students;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // Initialize Views
        TextView tvOverallAttendance = findViewById(R.id.tvOverallAttendance);
        TextView tvPresentToday = findViewById(R.id.tvPresentToday);
        TextView tvAbsentToday = findViewById(R.id.tvAbsentToday);

        // Dummy Data
        float overallAttendance = 85.5f;
        int presentToday = 42;
        int absentToday = 8;

        // Set Text Views
        tvOverallAttendance.setText(String.format("%.1f%%", overallAttendance));
        tvPresentToday.setText(String.valueOf(presentToday));
        tvAbsentToday.setText(String.valueOf(absentToday));

        // Pie Chart
        PieChart pieChart = findViewById(R.id.pieChart);
        setupPieChart(pieChart, presentToday, absentToday);
    }

    private void setupPieChart(PieChart pieChart, int present, int absent) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(present, "Present"));
        entries.add(new PieEntry(absent, "Absent"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(new int[]{Color.rgb(16, 185, 129), Color.rgb(239, 68, 68)});
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(14f);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setCenterText("Today's Ratio");
        pieChart.setCenterTextColor(Color.DKGRAY);
        pieChart.setCenterTextSize(16f);
        pieChart.getLegend().setEnabled(false);
        pieChart.animateXY(1400, 1400);
    }
}
