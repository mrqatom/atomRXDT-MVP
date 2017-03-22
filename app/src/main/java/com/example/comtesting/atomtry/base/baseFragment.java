package com.example.comtesting.atomtry.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by atom on 2017/3/16.
 */

public class baseFragment extends RxFragment {
    public ProgressDialog progressDialog;
    Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    public void showProgressDialog(String content){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(mContext);
        }
        progressDialog.setMessage(content);
        progressDialog.show();
    }
    public void disMissProgressDialog(){
        if (progressDialog==null){
            return;
        }
        progressDialog.dismiss();
    }

    public void showToast(String content){
        Toast.makeText(mContext,content,Toast.LENGTH_SHORT).show();
    }
}
