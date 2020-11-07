package com.example.bottomeditext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class CustomEditText extends EditText {

	public CustomEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CustomEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	

	public OnPopuWindowListener onPupuWindowListener;

	public interface OnPopuWindowListener {
		void closePopuWindow();
	}

	public void setOnPopuWindowListener(
			OnPopuWindowListener onPopuWindowListener) {
		this.onPupuWindowListener = onPopuWindowListener;
	}

	@Override
	public boolean dispatchKeyEventPreIme(KeyEvent event) {
		if ((event.getKeyCode() == KeyEvent.KEYCODE_BACK || event.getKeyCode() == KeyEvent.KEYCODE_MENU)
				&& event.getAction() == KeyEvent.ACTION_UP) {
			InputMethodManager imm = (InputMethodManager) getContext()
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			if (imm.isAcceptingText()) {
				// �Լ��Ĵ������

				onPupuWindowListener.closePopuWindow();
				return false;
			}
		}
		return super.dispatchKeyEventPreIme(event);
	}

}
