package common.suffixcomplitertext;

import java.util.List;
import java.util.Locale;

import android.text.TextUtils;
import android.util.Log;

public abstract class AbstractCompleter {
	
	private static final String TAG=AbstractCompleter.class.getSimpleName().toUpperCase(Locale.ENGLISH);
	
	public abstract String getSeparator();
	
	public abstract List<String> getSuffixes();
	
	
	
	
	private String mLastSuffix="";
	
	public String getLastSuffix(){
		return mLastSuffix;
	}
	
	public void clearLastSuffix(){
		 mLastSuffix="";
	}

	/**
	 * 
	 * @param text text without first separator
	 * @return
	 */
	public String getSuffixFor(String text){
		if(TextUtils.isEmpty(text)) 
			mLastSuffix=getSuffixes().get(0);
		else
			mLastSuffix= matchWithList(text);
		return mLastSuffix;
	}

	private String matchWithList(String subText) {
		Log.e(TAG, "subtext = " + subText);
		for(String item:getSuffixes()){
			if (item.indexOf(subText)>=0&&!item.equals(subText))
				return item.substring(subText.length(), item.length());
		}
		return "";
	}
}
