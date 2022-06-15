package com.example.java.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.List;


import java.io.FileReader;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);

		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("src/main/resources/data/users.json"));

			JSONObject jsonObject = (JSONObject) obj;
			System.out.println("");
			System.out.println("Apkopojot visus NAME laukus");

			JSONArray userList = (JSONArray) jsonObject.get("users");

			List<Object> userNames = new ArrayList<>();

			for (int i = 0; i < userList.size(); i++) {
				JSONObject user = (JSONObject) userList.get(i);
				userNames.add(user.get("name"));
			}

			String userName = userNames.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println(userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


