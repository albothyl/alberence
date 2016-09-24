package com.java.alberence.application.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import static com.java.alberence.application.util.StringUtils.EMPTY_STRING;

@Slf4j
public class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static String ObjectToJsonString(Object target) {

		try {
			return OBJECT_MAPPER.writeValueAsString(target);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return EMPTY_STRING;
	}
}
