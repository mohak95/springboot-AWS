package com.jdbctest.SpringJdbcApp.pojo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

	public static void main(String[] args) {
		String jsonStr = "{\r\n" + 
				"   \"id\" : 100,\r\n" + 
				"   \"address\" : \"India\",\r\n" + 
				"   \"name\" : \"Mohak\",\r\n" + 
				"   \"roll\" : \"800000\"\r\n" + 
				"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			UserStudent student = objectMapper.readValue(jsonStr, UserStudent.class);
			System.out.println(student.getId()+"  "+student.getAddress());
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
