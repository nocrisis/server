package com.questionaire.common.util;

import org.apache.commons.lang3.StringUtils;

public class CommonStringUtils {
	public static String escapeSearchCharacter(String request){
		if(StringUtils.isNotBlank(request)){
		    request = request.trim();
			request = request.replaceAll("\\\\", "\\\\\\\\");
			request = request.replaceAll("%", "\\\\%");
			request = request.replaceAll("_", "\\\\_");
		}
		return request;
	}
}
