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

        Pattern pattern = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        String present;
        String presentTranscription;
        String past;
        String pastTranscription;
        String past2;
        String past2Transcription;
        String participle;
        String participleTrascription;
        String participle2;
        String participle2Trascription;
        String translate;
        boolean found;

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

                found = matcher.group(5).contains("<br>");

            } else	{
                continue;
            }
            if (found) {
                String newMatch = pastTranscription.replaceAll("(?m)^\\s+", "");
                Matcher matcher2 = pattern2.matcher(newMatch);
                if (matcher2.find()) {
                    pastTranscription = matcher2.group(1);
                    past2 = matcher2.group(2);
                    past2Transcription = matcher.group(3);

                }
                newMatch = participleTrascription.replaceAll("(?m)^\\s+", "");
                matcher2 = pattern2.matcher(newMatch);
                if (matcher2.find()) {
                    participleTrascription = matcher2.group(1);
                    participle2 = matcher2.group(2);
                    participle2Trascription = matcher.group(3);
                }

            }

            System.out.println(present);
//			System.out.println(presentTranscription);
            System.out.println(past);
//			System.out.println(pastTranscription);
//			System.out.println(past2);
//			System.out.println(past2Transcription);
//			System.out.println(participle);
//			System.out.println(participleTrascription);
//			System.out.println(participle2);
//			System.out.println(participle2Trascription);
//			System.out.println(translate);

        }

//        Present presentWord1 = new Present();
//        presentWord1.setWord("abide");
//        presetRepository.save(presentWord1);
//
//        Past pastWord1 = new Past();
//        pastWord1.setWord("abode");
//        pastWord1.setPresent(presentWord1);
//        pastRepository.save(pastWord1);
//
//        Past pastWord2 = new Past();
//        pastWord2.setWord("abided");
//        pastWord2.setPresent(presentWord1);
//        pastRepository.save(pastWord2);
//
//        Participle participleWord1 = new Participle();
//        participleWord1.setWord("abode");
//        participleWord1.setPresent(presentWord1);
//        participleRepository.save(participleWord1);
//
//        Participle participleWord2 = new Participle();
//        participleWord2.setWord("abided");
//        participleWord2.setPresent(presentWord1);
//        participleRepository.save(participleWord2);
//
//        Set<Past> pastSet = new HashSet<>();
//        pastSet.add(pastWord1);
//        pastSet.add(pastWord2);
//        presetRepository.save(presentWord1);

    }
}
