package com.example.todolistmvp.modul.list;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.model.Task;
import com.example.todolistmvp.modul.add.AddActivity;
import com.example.todolistmvp.modul.login.LoginActivity;
import com.example.todolistmvp.utils.Database;
import com.example.todolistmvp.utils.RecyclerViewAdapterTodolist;

import java.util.ArrayList;
import java.util.Arrays;

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {
    private Button btnAdd;
    private Button btnClear;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Task> toDoArrayList;
    private Database database;

    public ListFragment() {
        this.database = Database.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        mPresenter = new ListPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewTodolist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        btnAdd = fragmentView.findViewById(R.id.bt_add);
        btnClear = fragmentView.findViewById(R.id.bt_clear);

        toDoArrayList = database.getTasks();
        mAdapter = new RecyclerViewAdapterTodolist(toDoArrayList);
        mRecyclerView.setAdapter(mAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performAdd();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clearList();
            }
        });

        setTitle("My To Do List View");

        return fragmentView;
    }

    @Override
    public void setPresenter(ListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToAdd() {
        Intent intent = new Intent(activity, AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void emptyList() {
        database.deleteAll();
        mAdapter.notifyDataSetChanged();
    }
}
