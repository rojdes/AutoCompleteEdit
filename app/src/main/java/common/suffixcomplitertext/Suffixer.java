package common.suffixcomplitertext;

import java.lang.ref.WeakReference;

import android.widget.EditText;

import common.suffixcomplitertext.completers.AbstractCompleter;

class Suffixer {
	
	
	
	private WeakReference<EditText> mEditText;
	
	private AbstractCompleter mCompleter;
	
//	private void log(String text){
//		final String TAG=Suffixer.class.getSimpleName().toUpperCase(Locale.ENGLISH);
//		Log.e(TAG, text);
//	}
	
	public Suffixer(EditText editText, AbstractCompleter completer) {
		mCompleter=completer;
        mEditText= new WeakReference<EditText>(editText);
	}
	
	public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter){
		if (mCompleter!=null)
		     handle(text.toString(), lengthBefore, lengthAfter);
	}
	
	private void handle(String text, int lengthBefore, int lengthAfter){
		if(isTextContainSeparator(text, lengthBefore, lengthAfter)){
			int index=text.indexOf(mCompleter.getSeparator());
			int pos=mEditText.get().getSelectionStart();
//When CHECK com TO org - there is mistake
			String tmp=text.substring(index+1,pos); 
			String suf=mCompleter.getSuffixFor(tmp);
		    mEditText.get().setText(SpannableDecorator.getfrom(text.substring(0,pos)+ suf, pos, suf.length()+pos));
			mEditText.get().setSelection(pos);
		}
	}
	
	private int wasRemoveAction(int lengthBefore, int lengthAfter){
        if (lengthBefore>lengthAfter)
        	return mEditText.get().getSelectionStart(); 
        else return -1;
	}
	
	private int wasAddAction(int lengthBefore, int lengthAfter){
        if (lengthBefore<lengthAfter)
        	return mEditText.get().getSelectionStart();
        else return -1;
	}
	
	private boolean isTextContainSeparator(String targetText, int lengthBefore, int lengthAfter){
		if (targetText.indexOf(mCompleter.getSeparator())==-1) return false;
		int i;
		i=wasAddAction(lengthBefore, lengthAfter);
		if (i<0)
		 i=wasRemoveAction(lengthBefore, lengthAfter);
		return i>targetText.indexOf(mCompleter.getSeparator());
	}
		
	public void release(){
		mCompleter=null;
	}
}
