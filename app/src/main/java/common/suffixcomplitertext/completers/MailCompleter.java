package common.suffixcomplitertext.completers;

import java.util.Arrays;
import java.util.List;

public class MailCompleter extends AbstractCompleter {
	
	@Override
	public String getSeparator() {
		return "@";
	}


	@Override
	public List<String> getSuffixes() {
		return Arrays.asList(new String[]{"ya.ru",
                                          "google.com",
                                          "yahoo.com",
                                          "rambler.ru"});
	}
}
