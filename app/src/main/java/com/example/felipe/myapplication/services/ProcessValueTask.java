package com.example.felipe.myapplication.services;

import android.content.Context;

/**
 * Created by felipe on 7/9/17.
 */

public class ProcessValueTask extends ProcessTask{

    static {
        System.loadLibrary("native-lib");
    }

    public ProcessValueTask(Context ctx) {
        super(ctx);
    }

    @Override
    protected Double doInBackground(Double... params) {
        return callbackToNative(params[0]);
    }

    @Override
    protected void onPostExecute(Double result) {
        Context ctx = context.get();
        if (ctx != null) {
            ((DoneTaskListener)ctx).onDoneCompleted(result);
        }
    }

    public native double callbackToNative(double num);
}
