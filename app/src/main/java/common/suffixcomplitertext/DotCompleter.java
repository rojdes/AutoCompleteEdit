package common.suffixcomplitertext;

import java.util.Arrays;
import java.util.List;

public class DotCompleter extends AbstractCompleter {

	@Override
	public String getSeparator() {
		return ".";
	}

	@Override
	public List<String> getSuffixes() {
		return Arrays.asList(new String[]{"com", "ru", "org", "net"});
	}

}
