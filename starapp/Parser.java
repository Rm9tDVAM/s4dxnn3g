package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class StarParser {
	public List<Star> getList(String urlString){
		List<Star> list=new ArrayList<>();
		JsonReader reader=null;
		HttpURLConnection con=null;
		try {
			URL url=new URL(urlString);
			con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			InputStream is=con.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			reader=new JsonReader(isr);
			JsonObject root=new Gson().fromJson(reader,JsonObject.class);
			JsonArray result=root.get("result").getAsJsonArray();
			for(int i=0;i<result.size();i++) {
				Star star=new Star();
				JsonObject sObj=result.get(i).getAsJsonObject();
				star.setEnName(sObj.get("enName").getAsString());
				star.setJpName(sObj.get("jpName").getAsString());
				star.setOrigin(sObj.get("origin").getAsString());
				star.setStarImage(sObj.get("starImage").getAsString());
				list.add(star);
			}
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con!=null) {
				con.disconnect();
			}
		}
		return list;
	}

}
