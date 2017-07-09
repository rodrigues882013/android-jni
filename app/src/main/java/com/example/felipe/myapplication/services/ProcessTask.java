package com.example.felipe.myapplication.services;

import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by felipe on 7/9/17.
 */

public abstract class ProcessTask extends AsyncTask<Double, Void, Double> {

    protected WeakReference<Context> context;

    ProcessTask(Context ctx) {
        this.context = new WeakReference<Context>(ctx);
    }
}
