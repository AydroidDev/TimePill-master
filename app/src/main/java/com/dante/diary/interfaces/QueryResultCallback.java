package com.dante.diary.interfaces;

import java.util.List;



public interface QueryResultCallback<T> {
    void onExist(List<T> list);

    void notExist();
}
