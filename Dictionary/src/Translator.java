
import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import okhttp3.*;

public class Translator {
    /*  Configure the local environment:
     * Set the TRANSLATOR_TEXT_SUBSCRIPTION_KEY and TRANSLATOR_TEXT_ENDPOINT environment
     * variables on your local machine using the appropriate method for your
     * preferred shell (Bash, PowerShell, Command Prompt, etc.).
     *
     * For TRANSLATOR_TEXT_ENDPOINT, use the same region you used to get your
     * subscription keys.
     *
     * If the environment variable is created after the application is launched
     * in a console or with Visual Studio, the shell (or Visual Studio) needs to be
     * closed and reloaded to take the environment variable into account.
     */
    private static String subscriptionKey = "3e4f640e8b1c4658bcdfc13d9f23685d";
    private static String endpoint = "https://api.cognitive.microsofttranslator.com/";
    String url = endpoint + "/translate?api-version=3.0&to=vi";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post() throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "[{\n\t\"Text\": \"Welcome to Microsoft Translator. Guess how many languages I speak!\"\n}]");
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Content-type", "application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String parseJSON(String json) {
        JsonElement element = JsonParser.parseString(json);
        return element.getAsJsonArray().get(0).getAsJsonObject().get("translations").getAsJsonArray().get(0).getAsJsonObject().get("text").toString();
    }

    public static void main(String[] args) {
        try {
            Translator translateRequest = new Translator();
            String response = translateRequest.Post();
            System.out.println(parseJSON(response));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}