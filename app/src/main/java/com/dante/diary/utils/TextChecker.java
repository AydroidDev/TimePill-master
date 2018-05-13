package com.dante.diary.utils;

import android.widget.EditText;


public class TextChecker {

    public static boolean isTextInvalid(EditText editText) {
        return (editText == null || editText.getText() == null ||
                editText.getText().toString().replace(" ", "").length() == 0);
    }
}
