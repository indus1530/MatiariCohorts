package edu.aku.hassannaqvi.blf_screening.ui.list_activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.adapter.FormsAdapter;
import edu.aku.hassannaqvi.blf_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.blf_screening.models.FormsSL;


public class FormsReportDate extends AppCompatActivity {
    DatabaseHelper db;
    Collection<FormsSL> form;
    String sysdateToday = new SimpleDateFormat("dd-MM-yy").format(new Date());
    TextView dtFilter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter formsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_report_date);
        recyclerView = findViewById(R.id.fc_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dtFilter = findViewById(R.id.dtFilter);
        db = new DatabaseHelper(this);
//        form = db.getTodayForms(sysdateToday);

        // specify an adapter (see also next example)
        formsAdapter = new FormsAdapter((List<FormsSL>) form, this);
        recyclerView.setAdapter(formsAdapter);
    }

    public void filterForms(View view) {
        Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
//        form = db.getTodayForms(dtFilter.getText().toString());
        formsAdapter = new FormsAdapter((List<FormsSL>) form, this);
        formsAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(formsAdapter);

    }
}