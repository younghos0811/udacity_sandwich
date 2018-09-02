package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//private String mainName;
//private List<String> alsoKnownAs = null;
//private String placeOfOrigin;
//private String description;
//private String image;
//private List<String> ingredients = null;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        /** static name definition **/
        final String SANDWITCH_NAME = "name";
        final String SANDWITCH_NAME_MAINNAME = "mainName";
        final String SANDWITCH_NAME_ALSOKWN_ = "alsoKnownAs";
        final String SANDWITCH_ORIGIN = "placeOfOrigin";
        final String SANDWITCH_DESCRIPT = "description";
        final String SANDWITCH_IMAGE = "image";
        final String SANDWITCH_INGREDIENTS = "ingredients";

        String mainName = null;
        List<String> alsoKnownAs = null;
        String placeOfOrigin = null;
        String description = null ;
        String image = null;
        List<String> ingredients = null;

        /** get Json **/
        JSONObject sandwitchJson = new JSONObject(json);

        /** extract Json to Name **/
        JSONObject sandwitchNameJson = sandwitchJson.getJSONObject(SANDWITCH_NAME);
        mainName = sandwitchNameJson.getString(SANDWITCH_NAME_MAINNAME); // get main name
        JSONArray sandwitchAlsokwnArray = sandwitchNameJson.getJSONArray(SANDWITCH_NAME_ALSOKWN_);

        if(sandwitchAlsokwnArray.length() > 0)
            alsoKnownAs = new ArrayList<>();

        for(int i = 0; i < sandwitchAlsokwnArray.length(); i++) {
            alsoKnownAs.add(sandwitchAlsokwnArray.getString(i));
        } //get alsoKnownAs

        /** extract Json to Origin **/
        placeOfOrigin = sandwitchJson.getString(SANDWITCH_ORIGIN);

        /** extract Json to Description **/
        description = sandwitchJson.getString(SANDWITCH_DESCRIPT);

        /** extract Json to Image URL **/
        image = sandwitchJson.getString(SANDWITCH_IMAGE);

        /** extract Json to Ingredients **/
        JSONArray sandwitchIngreArray = sandwitchJson.getJSONArray(SANDWITCH_INGREDIENTS);

        if(sandwitchIngreArray.length() > 0)
            ingredients = new ArrayList<>();

        for(int i = 0; i < sandwitchIngreArray.length(); i++) {
            ingredients.add(sandwitchIngreArray.getString(i));
        } //get alsoKnownAs

        return new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);
    }
}
