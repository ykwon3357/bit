package org.comstudy21.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Dao {
	FileReader reader = null;
	FileWriter writer = null;
	String filepath = "src\\org\\comstudy21\\resource\\members.json";

	private JSONObject getJSONObject() {
		try {
			File file = new File(filepath);
			reader = new FileReader(file);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject jsonObject = new JSONObject(tokener);
			return jsonObject;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Vector<Vector> selectAll() {
		// 파일을 읽어들인다. ->JSONObject 객체로 만든다.
		JSONObject rootObject = getJSONObject();

		JSONArray array = rootObject.getJSONArray("members");
		Vector<Vector> vector = new Vector<>();

		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = (JSONObject) array.getJSONObject(i);
			Vector v = new Vector<>();
			v.add(obj.getInt("no"));
			v.add(obj.get("name"));
			v.add(obj.get("email"));
			v.add(obj.get("phone"));
			vector.add(v);
		}

		return vector;
	}

	public void insert(Member dto) {
		JSONObject rootObject = getJSONObject();
		int seq = rootObject.getInt("seq");
		JSONArray array = rootObject.getJSONArray("members");
		
		JSONObject obj = new JSONObject();
		obj.put("no", seq++);
		obj.put("name", dto.getName());
		obj.put("email", dto.getEmail());
		obj.put("phone", dto.getPhone());
		array.put(obj);
		
		rootObject.put("seq", seq);
		
		try {
			File file = new File(filepath);
			writer = new FileWriter(file);
			writer.write(rootObject.toString(2));
			
			if(reader!=null) reader.close();
			if(writer!=null) writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
