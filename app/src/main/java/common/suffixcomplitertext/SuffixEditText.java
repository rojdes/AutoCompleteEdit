package common.suffixcomplitertext;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class SuffixEditText extends EditText {
	
	
	
	private static final String TAG="HINT_EDIT_TEXT";
	private  Suffixer mSuffixer= new Suffixer();
	
	private void log(String text){
		Log.e(TAG,text!=null?text:"null");
	}

	public SuffixEditText(Context context) {
		super(context);
		log("CONSTRUCTOR context");
	}
	
	public SuffixEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		log("CONSTRUCTOR context, attrs");
	}
	
	
	public SuffixEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		log("CONSTRUCTOR context,attrs, defstyle");
	}
	
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		mSuffixer.addEditText(this);
		mSuffixer.addComplter(new DotCompleter());
		log("onAttachedToWindow");
	}
	
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mSuffixer.release();
		log("onDetachedFromWindow");
	}
	
	@Override
	public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
		//log("onTextChanged");
		if (mSuffixer!=null)
	   	    mSuffixer.onTextChanged(text, start, lengthBefore, lengthAfter);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		log("onFinishInflate");
	}
	
	
	
	
}
