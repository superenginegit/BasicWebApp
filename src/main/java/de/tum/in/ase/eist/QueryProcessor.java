package de.tum.in.ase.eist;

import java.util.Arrays;

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
	        } else if (query.contains("eiffel tower")) {
		           return "Paris";
		    }else if (query.contains("theresa may") && query.contains("prime minister")) {
		           return "2016";
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
	        } else if (query.contains("is the largest:")) {
	        	String numbers = query.substring(query.indexOf(':')+2);
	        	String[] splitStrings = numbers.split(",");
	        	int[] integers = new int[splitStrings.length];
	        	for (int i = 0; i < splitStrings.length; i++) {
	        		integers[i] = Integer.parseInt(splitStrings[i]);
	        	}
	        	return String.valueOf(Arrays.stream(integers).max().orElseThrow(IllegalArgumentException::new));
	        } else if (query.contains("multiplied")){
	        	String[] splitupStrings = query.split(" ");
	        	for (int i = 0; i < splitupStrings.length; i++) {
	        		if (splitupStrings[i].equals("multiplied")) {
        				Integer oneInteger = Integer.parseInt(splitupStrings[i-1]);
        				Integer twoInteger = Integer.parseInt(splitupStrings[i+2]);
        				return String.valueOf(oneInteger * twoInteger);
	        		}
	        	}
	        	return "";
	        }else {
	            return "";
	        }
        } catch (Exception e) {
			return "";
		}
    }
}
