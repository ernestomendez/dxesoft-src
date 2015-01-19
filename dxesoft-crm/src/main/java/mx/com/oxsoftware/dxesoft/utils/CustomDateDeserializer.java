package mx.com.oxsoftware.dxesoft.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Date: 1/18/15
 * User: ernesto
 */
public class CustomDateDeserializer extends JsonDeserializer<DateTime> {
//    private static DateTimeFormatter format = new DateTimeFormat.forPattern("dd-MM-yyyy 00:00:00");
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String date = jsonParser.getText();
            return formatter.parseDateTime(date);
    }
}
