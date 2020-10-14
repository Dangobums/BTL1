//import java.util.Locale;
//import javax.speech.Central;
//import javax.speech.synthesis.Synthesizer;
//import javax.speech.synthesis.SynthesizerModeDesc;
//import javax.speech.synthesis.Voice;
import com.sun.speech.freetts.*;

public class Voice{
    private String name = "kevin16";
    private com.sun.speech.freetts.Voice voice;

    public Voice() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager vn = VoiceManager.getInstance();
        voice = vn.getVoice(name);
        voice.allocate();

    }
    public void Speak(String word){
        voice.speak(word);
    }
}