/**
 * Copyright 2018 Comcast Cable Communications Management, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vinyldns.java.serializers;

import vinyldns.java.model.record.data.RecordData;
import vinyldns.java.model.record.data.UNKNOWNData;
import com.google.gson.*;

import java.lang.reflect.Type;

public class RecordDataDeserializer implements JsonDeserializer<RecordData>, JsonSerializer<RecordData> {

    @Override
    public JsonElement serialize(RecordData src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src, src.getClass()).getAsJsonObject();
    }

    @Override
    public RecordData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement typeElement = jsonObject.get("type");

        if (typeElement.isJsonNull()) {
            return new UNKNOWNData(json.getAsString());
        }

        String type = typeElement.getAsString();

        try {
            String thepackage = RecordData.class.getPackage().getName() + ".";

            return context.deserialize(jsonObject, Class.forName(thepackage + type + "Data"));

        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }

}