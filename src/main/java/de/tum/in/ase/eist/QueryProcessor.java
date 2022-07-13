package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		try {
	    	query = query.toLowerCase();
	        if (query.contains("shakespeare")) {
	            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
	                    "English poet, playwright, and actor, widely regarded as the greatest " +
	                    "writer in the English language and the world's pre-eminent dramatist.";
	        } else if (query.contains("name")) {
	           return "Simon";
	        } else if (query.contains("plus")){
	        	String[] splitupStrings = query.split(" ");
	        	for (int i = 0; i < splitupStrings.length; i++) {
	        		if (splitupStrings[i].equals("plus")) {
        				Integer oneInteger = Integer.parseInt(splitupStrings[i-1]);
        				Integer twoInteger = Integer.parseInt(splitupStrings[i+1]);
        				return String.valueOf(oneInteger + twoInteger);
	        		}
	        	}
	        	return "";
	        } else {
	            return "";
	        }
        } catch (Exception e) {
			return "";
		}
    }
}
