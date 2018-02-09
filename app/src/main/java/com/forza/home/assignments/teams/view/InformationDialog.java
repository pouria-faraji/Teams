package com.forza.home.assignments.teams.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;


import com.forza.home.assignments.teams.R;
import com.forza.home.assignments.teams.application.Global;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pouria on 2/5/2018.
 */

public class InformationDialog extends Dialog {
    private Context _context;
    private String _msg;
    @BindView(R.id.information_dialog_layout)LinearLayout information_dialog_layout;
    @BindView(R.id.information_dialog_text) MuseoTextView information_dialog_text;
    @BindView(R.id.information_dialog_button) MuseoTextView information_dialog_button;

    public InformationDialog(@NonNull Context context, String msg) {
        super(context);
        _context = context;
        _msg = msg;
    }

    public InformationDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected InformationDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.information_dialog);
        getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
        ButterKnife.bind(this);
        prepareUI();
        information_dialog_text.setText(_msg);
        information_dialog_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void prepareUI() {
        information_dialog_layout.getLayoutParams().width = (int) (0.7* Global.getAppWidth());
        information_dialog_layout.getLayoutParams().height = (int) (0.3*Global.getAppHeight());

//        information_dialog_layout.setBackground(_context.getDrawable(R.drawable.dialog_background));

        float review_question_text_size =  (float) (0.027 * Global.getAppHeight());
        information_dialog_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, review_question_text_size);
        information_dialog_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, review_question_text_size);
    }
}
