package com.android_cademy.starwarstinder;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.android_cademy.starwarstinder.model.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ResourcesUtil {

  public static List<Profile> loadProfiles(Context context) {
    try {
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create();
      JSONArray array = new JSONArray(loadJSONFromAsset(context));
      List<Profile> profileList = new ArrayList<>();
      for (int i = 0; i < array.length(); i++) {
        Profile profile = gson.fromJson(array.getString(i), Profile.class);
        profileList.add(profile);
      }
      return profileList;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static String loadJSONFromAsset(Context context) {
    String jsonString = null;
    Writer writer = new StringWriter();
    char[] buffer = new char[1024];
    try {
      try (InputStream is = context.getResources().openRawResource(R.raw.profiles)) {
        Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        int n;
        while ((n = reader.read(buffer)) != -1) {
          writer.write(buffer, 0, n);
        }
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      } finally {
        jsonString = writer.toString();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonString;
  }
}
