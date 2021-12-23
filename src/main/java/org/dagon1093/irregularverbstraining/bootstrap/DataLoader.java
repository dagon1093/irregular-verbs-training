package org.dagon1093.irregularverbstraining.bootstrap;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.model.Present;
import org.dagon1093.irregularverbstraining.repositories.ParticipleRepository;
import org.dagon1093.irregularverbstraining.repositories.PastRepository;
import org.dagon1093.irregularverbstraining.repositories.PresetRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Profile("parser")
public class DataLoader implements CommandLineRunner {

    private final PresetRepository presetRepository;
    private final PastRepository pastRepository;
    private final ParticipleRepository participleRepository;

    public DataLoader(PresetRepository presetRepository, PastRepository pastRepository, ParticipleRepository participleRepository) {
        this.presetRepository = presetRepository;
        this.pastRepository = pastRepository;
        this.participleRepository = participleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Document doc = Jsoup.connect("http://www.ph4.ru/eng_irregular.php?al=a#google_vignette").get();
        Elements elements = doc.select("body > table > tbody > tr > td > div > table > tbody > tr");

        String regex1 = "<td class=\"silver\">(\\d+)</td>\n" +
                " <td><b>(\\w+)</b> (.+?)</td>\n" +
                " <td><b>(\\w+)</b> (.+?)</td>\n" +
                " <td><b>(\\w+)</b> (.+?)</td>\n" +
                " <td class=\"silver\">([а-яёА-ЯЁ,; ]+)</td>";

        String regex2 = "^(.+?)<br><b>(\\w+)</b> (.+?)$";
        String regex3 = "^(.+?)<";
        String regex4 = "<b>(\\w+)<";
        String regex5 = "</b> (.+?)$";

        Pattern pattern = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        Pattern pattern4 = Pattern.compile(regex4);
        Pattern pattern5 = Pattern.compile(regex5);

        String present = "";
        String presentTranscription = "";
        String past = "";
        String pastTranscription = "";
        String past2 = "";
        String past2Transcription = "";
        String participle = "";
        String participleTrascription = "";
        String participle2 = "";
        String participle2Trascription = "";
        String translate = "";
        boolean foundPast = false;
        boolean foundParticiple = false;

        for (int i = 0; i < elements.size(); i++) {

            Matcher matcher = pattern.matcher(elements.get(i).toString());

            if (matcher.find()) {

                present = matcher.group(2);
                presentTranscription = matcher.group(3);
                past = matcher.group(4);
                pastTranscription = matcher.group(5);
                participle = matcher.group(6);
                participleTrascription = matcher.group(7);
                translate = matcher.group(8);

                foundPast = matcher.group(5).contains("<br>");
                foundParticiple = matcher.group(7).contains("<br>");

            } else	{
                continue;
            }
            if (foundPast) {
                String newMatch = pastTranscription.replaceAll("(?m)^\\s+", "");
                Matcher matcher3 = pattern3.matcher(newMatch);
                Matcher matcher4 = pattern4.matcher(newMatch);
                Matcher matcher5 = pattern5.matcher(newMatch);
                pastTranscription = (matcher3.find()) ? matcher3.group(1) : "";
                past2 = (matcher4.find()) ? matcher4.group(1) : "";
                past2Transcription = (matcher5.find()) ? matcher5.group(1) : "";
            }
            if(foundParticiple){
                String newMatch = participleTrascription.replaceAll("(?m)^\\s+", "");
                Matcher matcher3 = pattern3.matcher(newMatch);
                Matcher matcher4 = pattern4.matcher(newMatch);
                Matcher matcher5 = pattern5.matcher(newMatch);
                participleTrascription = (matcher3.find()) ? matcher3.group(1) : "";
                participle2 = (matcher4.find()) ? matcher4.group(1) : "";
                participle2Trascription = (matcher5.find()) ? matcher5.group(1) : "";

            }

//          System.out.println(present);
//			System.out.println(presentTranscription);
//          System.out.println(past);
//			System.out.println(pastTranscription);
//			System.out.println(past2);
//			System.out.println(past2Transcription);
//			System.out.println(participle);
//			System.out.println(participleTrascription);
//			System.out.println(participle2);
//			System.out.println(participle2Trascription);
//			System.out.println(translate);

            Present presentWord = new Present();
            Set<Past> pastSet = new HashSet<>();
            Set<Participle>  participleSet = new HashSet<>();
            presentWord.setWord(present);
            presentWord.setTranslate(translate);
            presentWord.setTranscription(presentTranscription);
            presentWord.setPastSet(pastSet);
            presentWord.setParticipleSet(participleSet);
            presetRepository.save(presentWord);

            Past pastWord1 = new Past();
            pastWord1.setWord(past);
            pastWord1.setTranscription(pastTranscription);
            pastWord1.setPresent(presentWord);
            pastRepository.save(pastWord1);

            Participle participleWord1 = new Participle();
            participleWord1.setWord(participle);
            participleWord1.setTranscription(participleTrascription);
            participleWord1.setPresent(presentWord);
            participleRepository.save(participleWord1);

            if (foundPast) {
                Past pastWord2 = new Past();
                pastWord2.setWord(past2);
                pastWord2.setTranscription(past2Transcription);
                pastWord2.setPresent(presentWord);
                pastRepository.save(pastWord2);
            }
            if (foundParticiple){
                Participle participleWord2 = new Participle();
                participleWord2.setWord(participle2);
                participleWord2.setTranscription(participle2Trascription);
                participleWord2.setPresent(presentWord);
                participleRepository.save(participleWord2);
            }

            presetRepository.save(presentWord);

            present = "";
            presentTranscription = "";
            past = "";
            pastTranscription = "";
            past2 = "";
            past2Transcription = "";
            participle = "";
            participleTrascription = "";
            participle2 = "";
            participle2Trascription = "";
            translate = "";


        }


    }
}
