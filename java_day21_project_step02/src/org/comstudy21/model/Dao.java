package org.comstudy21.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.comstudy21.resource.R;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Dao {

	private String pathname = "src/org/comstudy21/resource/students.json";
	FileReader reader = null;
	FileWriter writer = null;

	private JSONObject getJSONObject() {
		// String src = "data.json";
		// InputStream inputStream = R.class.getResourceAsStream(src);

		File dataFile = new File(pathname);
		try {
			reader = new FileReader(dataFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (reader == null) {
			System.out.println("읽어들일 파일이 없습니다!");
			return null;
		}

		JSONTokener token = new JSONTokener(reader);
		return new JSONObject(token);
	}

	public Vector<Vector> selectAll() {
		JSONObject object = getJSONObject();
		JSONArray array = object.getJSONArray("studentArr");
		Vector<Vector> vector = new Vector<>();

		for (int i = 0; i < array.length(); i++) {
			JSONObject el = array.getJSONObject(i);
			Vector member = new Vector();
			member.add(el.getInt("no"));
			member.add((String) el.get("name"));
			member.add((String) el.get("email"));
			member.add((String) el.get("phone"));
			vector.add(member);
		}

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return vector;
	}

	public void insert(Member dto) {
		JSONObject jsonObj = getJSONObject();
		JSONArray jsonArr = jsonObj.getJSONArray("studentArr");
		int seq = (int) jsonObj.get("seq");

		try {
			writer = new FileWriter(new File(pathname));
			if (writer == null) {
				System.out.println("읽어들일 파일이 없습니다!");
				return;
			}

			JSONObject json = new JSONObject();
			json.put("no", seq++);
			json.put("name", dto.getName());
			json.put("email", dto.getEmail());
			json.put("phone", dto.getPhone());
			jsonArr.put(json);

			JSONObject object = new JSONObject();
			object.put("seq", seq);
			object.put("studentArr", jsonArr);

			writer.write(object.toString(2));
			// System.out.println("JSON 파일로 내보내기 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Vector<Vector> select(Member member) {
		Vector<Vector> vector = new Vector<>();
		
		JSONObject rootObject = getJSONObject();
		JSONArray array = rootObject.getJSONArray("studentArr");

		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			if ((member.getName().length()!=0&&(obj.get("name")).toString().indexOf(member.getName())!=-1)//일부분 같아도 같은걸로 처리,한 문자도 같은게 없다면 -1 
					|| (member.getEmail().length()!=0&&(obj.get("email")).toString().indexOf(member.getEmail())!=-1)
					|| (member.getPhone().length()!=0&&(obj.get("phone")).toString().indexOf(member.getPhone())!=-1)) {
				Vector v = new Vector<>();
				v.add(obj.getInt("no"));
				v.add(obj.get("name"));
				v.add(obj.get("email"));
				v.add(obj.get("phone"));
				vector.add(v);
			}
		}

		return vector;
	}

	public void delete(Member dto) {
		JSONObject rootObject = getJSONObject();
		JSONArray array = rootObject.getJSONArray("studentArr");
		int seq = rootObject.getInt("seq");
		
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			if ( obj.getInt("no")==dto.getNo()
					/* && obj.get("name").equals(dto.getName())*/) {
				array.remove(i);
				seq--;
			}
		}

		File file = new File(pathname);
		try {
			writer = new FileWriter(file);
			writer.write(rootObject.toString(2));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// public static void main(String[] args) {
	// Dao dao = new Dao();
	// dao.insert(new Member(100, "test", "test@test.com", "99999999"));
	// }
}
