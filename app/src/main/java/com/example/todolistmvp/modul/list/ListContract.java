package com.example.todolistmvp.modul.list;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface ListContract {
    interface View extends BaseView<ListContract.Presenter> {
        void redirectToAdd();
        void emptyList();
    }

    interface Presenter extends BasePresenter {
        //void performList();
        void performAdd();
        void clearList();
    }
}
