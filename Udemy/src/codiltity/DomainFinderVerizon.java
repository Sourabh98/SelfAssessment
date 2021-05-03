package codiltity;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainFinderVerizon {
	/*
	 * Problem: Create a class to take an input List of URLs as string, process the
	 * array and output a List of strings that contains the domain names from the
	 * URLs followed by the count of the occurrence of that domain in the URLs.
	 * 
	 * Input: ["https://www.yahoo.com/", "http://www.yahoo.com/" ,
	 * "https://www.yahoo.com/news/", "https://sports.yahoo.com/",
	 * "https://techcrunch.com/startups/", "https://www.huffingtonpost.com/",
	 * "https://www.huffingtonpost.co.uk/",
	 * "https://www.huffingtonpost.co.uk/entry/brexit-secretary?utm_hp_ref=uk-politics",
	 * "https://developer.github.com/apps/building-oauth-apps/",
	 * "https://developer.github.com/v3/", "https://developer.github.com:8080/v3/"]
	 * 
	 * Output: ["www.yahoo.com 3", "sports.yahoo.com 1", "techcrunch.com 1",
	 * "www.huffingtonpost.com 1", "www.huffingtonpost.co.uk 2",
	 * "developer.github.com 3"]
	 * 
	 * Tips: Write as many functions and tests as you deemed necessary to solve this
	 * task. Please focus on code quality and not only hacking something together to
	 * make it work. You will be asked to explain & comment your solution.
	 * 
	 * It would also help us if you could use this screen for the entire task, so
	 * that we can see how you got to the solution of this problem.
	 */

	public static void main(String[] args) throws Exception {

		String[] urls = { "https://www.yahoo.com/", "http://www.yahoo.com/", "https://sports.yahoo.com/",
				"https://techcrunch.com/startups/", "https://www.huffingtonpost.com/",
				"https://www.huffingtonpost.co.uk/",
				"https://www.huffingtonpost.co.uk/entry/brexit-secretary?utm_hp_ref=uk-politics",
				"https://developer.github.com/apps/building-oauth-apps/", "https://www.yahoo.com/news/",
				"https://developer.github.com/v3/", "https://developer.github.com:8080/v3/" };
		List<String> list = findDomain(Arrays.asList(urls));
		for (String str : list) {
			System.out.print(str+",");
		}

	}

	public static List<String> findDomain(List<String> urls) throws Exception {
		List<String> arrList = new ArrayList<String>();
		Set<String> hashSet = new HashSet<String>();
		for (String url : urls) {
			/*
			 * String[] urlDomain = url.split("/"); arrList.add(urlDomain[2]);
			 */
			URL urlObj = new URL(url);
			String hostName = urlObj.getHost();
			arrList.add(hostName);
		}

		for (String url : arrList) {
			int frequency = Collections.frequency(arrList, url);
			hashSet.add(url + " " + frequency);

		}
		arrList.clear();
		arrList.addAll(hashSet);
		return arrList;
	}

}
