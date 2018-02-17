package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich ourSandwich = new Sandwich();

        try {
            // parse whole json as object
            JSONObject obj = new JSONObject(json);

            // name is first item, which has 2 items
            JSONObject objName = obj.getJSONObject("name");

            // array name has 2 objects, main name and also known as array
            String mainName = objName.getString("mainName");
            JSONArray arrAlsoKnown = objName.getJSONArray("alsoKnownAs");

            // Also known is also an array of strings
            ArrayList<String> alsoKnownList = new ArrayList<String>();

            for (int i =0; i< arrAlsoKnown.length(); i++)
            {
                alsoKnownList.add(arrAlsoKnown.getString(i));
            }

            ourSandwich.setMainName(mainName);
            ourSandwich.setAlsoKnownAs(alsoKnownList);

            // description and place of origins are strings found in our arr object

            ourSandwich.setDescription(obj.getString("description"));
            ourSandwich.setPlaceOfOrigin(obj.getString("placeOfOrigin"));

            // image is a link, parsed as string

            ourSandwich.setImage(obj.getString("image"));

            // ingredients is an array of strings

            JSONArray arrIngredients = obj.getJSONArray("ingredients");

            ArrayList<String> ingredientsList = new ArrayList<String>();

            for (int i=0; i<arrIngredients.length(); i++)
            {
                ingredientsList.add(arrIngredients.getString(i));
            }

            ourSandwich.setIngredients(ingredientsList);


            return ourSandwich;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
    }
}
