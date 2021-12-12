package org.dagon1093.irregularverbstraining.bootstrap;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.model.Present;
import org.dagon1093.irregularverbstraining.repositories.ParticipleRepository;
import org.dagon1093.irregularverbstraining.repositories.PastRepository;
import org.dagon1093.irregularverbstraining.repositories.PresetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
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
    public void run(String... args) {

        Present presentWord1 = new Present();
        presentWord1.setWord("abide");
        presetRepository.save(presentWord1);

        Past pastWord1 = new Past();
        pastWord1.setWord("abode");
        pastWord1.setPresent(presentWord1);
        pastRepository.save(pastWord1);

        Past pastWord2 = new Past();
        pastWord2.setWord("abided");
        pastWord2.setPresent(presentWord1);
        pastRepository.save(pastWord2);

        Participle participleWord1 = new Participle();
        participleWord1.setWord("abode");
        participleWord1.setPresent(presentWord1);
        participleRepository.save(participleWord1);

        Participle participleWord2 = new Participle();
        participleWord2.setWord("abided");
        participleWord2.setPresent(presentWord1);
        participleRepository.save(participleWord2);

        Set<Past> pastSet = new HashSet<>();
        pastSet.add(pastWord1);
        pastSet.add(pastWord2);
        presetRepository.save(presentWord1);

    }
}
