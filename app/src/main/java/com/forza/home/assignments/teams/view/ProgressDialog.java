package com.forza.home.assignments.teams.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.forza.home.assignments.teams.R;
import com.forza.home.assignments.teams.application.Global;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class ProgressDialog extends Dialog {
    private Context _context;
    @BindView(R.id.progressbar_layout)LinearLayout progressbar_layout;
    @BindView(R.id.progressbar_text) MuseoTextView progressbar_text;
    @BindView(R.id.progressbar) ProgressBar progressbar;

    private String message;
    public ProgressDialog(@NonNull Context context, String msg) {
        super(context);
        this.message = msg;
    }

    public ProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.progress_dialog);
        getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
        ButterKnife.bind(this);
        prepareUI();
    }
    private void prepareUI() {
        progressbar_layout.getLayoutParams().width = (int) (0.8* Global.getAppWidth());
        progressbar_layout.getLayoutParams().height = (int) (0.15*Global.getAppHeight());

        float progressBar_text_size =  (float) (0.025 * Global.getAppHeight());
        progressbar_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, progressBar_text_size);
        progressbar_text.setText(message);
        progressbar_text.setGravity(Gravity.CENTER_VERTICAL);
    }
}
