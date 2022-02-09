import java.util.HashMap;
import java.util.Set;

public class HashMatique {
    
    public static void iterateHashmap() {

        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Twinkle twinkle", "Twinkle twinkle little star...");
        trackList.put("Row Row Row Your Boat", "Row, row, row your boat Gently down the stream");
        trackList.put("Head shoulders knees and toes", "Head shoulders knees and toes...");
        trackList.put("Rain, rain, go away", "Rain, rain, go away...");

        String val = trackList.get("Twinkle twinkle");

        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.printf("trackList: %s\n", key, trackList.get(key));
        }

    }


}