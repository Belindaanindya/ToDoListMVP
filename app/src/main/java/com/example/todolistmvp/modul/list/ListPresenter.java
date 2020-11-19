package com.example.todolistmvp.modul.list;

public class ListPresenter implements ListContract.Presenter {
    private final ListContract.View view;

    public ListPresenter(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performAdd(){
        //proses login
        //if login success call redirect to profile
        view.redirectToAdd();
    }

    @Override
    public void clearList() {
        view.emptyList();
    }
}
