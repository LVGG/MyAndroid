package com.lyu.myandroid.myview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lyu.myandroid.R;

import org.w3c.dom.Text;

public class MyEditText extends RelativeLayout {
    private EditText editText;
    private ImageView ivDelete;
    private Button btSend;

    public MyEditText(Context context) {
        super(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflate(context, R.layout.my_edit_text, this);

        editText = view.findViewById(R.id.et_input);
        ivDelete = view.findViewById(R.id.iv_delete);
        btSend = view.findViewById(R.id.bt_send);

        init();
    }


    private void init() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                btSend.setEnabled(editText.getText().length() > 0);
            }
        });

        btSend.setOnClickListener(view -> {
            String content = editText.getText().toString();
            if ( onMsgSendListener != null ) {
                onMsgSendListener.onSend(content);
                editText.setText("");
            }
        });

        ivDelete.setOnClickListener(view -> {
            deleteChar();
        });
    }


    private synchronized void deleteChar() {
        int cursorPosition = editText.getSelectionStart();
        if ( cursorPosition > 0 ) {
            Editable editable = editText.getText();
            editable.delete(cursorPosition-1, cursorPosition);
        }
    }



    private onMsgSendListener onMsgSendListener = null;
    public void setOnMsgSendListener(final onMsgSendListener listener){
        this.onMsgSendListener = listener;
    }


    public interface onMsgSendListener{
        void onSend(String string);
    }


}
