package com.example.todolistmvp.modul.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.model.Task;
import com.example.todolistmvp.modul.list.ListActivity;
import com.example.todolistmvp.utils.Database;

import java.util.ArrayList;

public class AddFragment extends BaseFragment<AddActivity, AddContract.Presenter> implements AddContract.View {
    private EditText etTitle;
    private EditText etDescription;
    private Button btnAdd;
    private ArrayList<Task> toDoList;
    private Database database;

    public AddFragment() {
        this.database = Database.getInstance();
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add, container, false);
        mPresenter = new AddPresenter(this);
        mPresenter.start();

        toDoList = database.getTasks();
        btnAdd = fragmentView.findViewById(R.id.bt_save);
        etTitle = fragmentView.findViewById(R.id.et_title);
        etDescription = fragmentView.findViewById(R.id.et_description);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.performList();
            }
        });

        setTitle("Add Item View");

        return fragmentView;
    }

    @Override
    public void setPresenter(AddContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToList() {
        if(etTitle.getText() != null && etDescription.getText() != null)
            database.addTask(etTitle.getText().toString(), etDescription.getText().toString());

        Intent returnIntent = new Intent(activity, ListActivity.class);
        startActivity(returnIntent);
        activity.finish();
    }
}
