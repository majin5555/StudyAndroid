package com.e.demo_eventbus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * @author: majin
 * @date: 2020/4/26$
 * @desc:
 */
public class PublisherDialogFrgment extends DialogFragment {
    private static final String TAG = "PublisherDialogFrgment";

    private OnEventListener onEventListener;

    public interface OnEventListener {
        void onSuccess();

        void onFailure();
    }

    public void setEventListener(OnEventListener onEventListener) {
        this.onEventListener = onEventListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Publisher");
        final String[] items = {"Scccess", "Failure"};

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0:
                        //                        onEventListener.onSuccess();
                        //                        Toast.makeText(getActivity(), items[0].toString(), Toast.LENGTH_SHORT).show();
                        EventBus.getDefault().post(new SuccessEvent());

                        break;
                    case 1:
                        EventBus.getDefault().post(new FailureEvent());

                        //                        onEventListener.onFailure();
                        //                        Toast.makeText(getActivity(), items[1].toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return builder.create();

    }
}
