package rds.me.autocompletetextvew.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import rds.me.autocompleteedit.R;


public class FontTextView extends TextView{
	
	
	/**
	 * http://www.techrepublic.com/article/pro-tip-extend-androids-textview-to-use-custom-fonts/
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	private Typeface mTypeface;
	
	public FontTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}
	
	
	/**
	 * http://www.techrepublic.com/article/pro-tip-extend-androids-textview-to-use-custom-fonts/
	 * @param context
	 * @param attrs
	 */
	public FontTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
		
	}
	
	
	/**
	 * http://www.techrepublic.com/article/pro-tip-extend-androids-textview-to-use-custom-fonts/
	 * @param context
	 */
	public FontTextView(Context context) {
		super(context);
		init(null);
	}
	
	private void init(AttributeSet attrs) {
		if (attrs!=null) {
			 TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
			 String fontName = a.getString(R.styleable.FontTextView_fontName);
			 if (fontName!=null) {
				 mTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+fontName);
				 Log.e("FONT", "NAME = " + Typeface.createFromAsset(getContext().getAssets(), "fonts/"+fontName).toString());
			 }
			 a.recycle();
		}
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.e("FONT", "DRAW");
	}
	
	@Override
	public boolean onPreDraw() {
		return super.onPreDraw();
	}
	
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.e("FONT", "ATTACH");
		if (mTypeface!=null)
		setTypeface(mTypeface);
	}
	
}
