package org.dagon1093.irregularverbstraining.services.serviceimpl;

import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.repositories.ParticipleRepository;
import org.dagon1093.irregularverbstraining.repositories.PastRepository;
import org.dagon1093.irregularverbstraining.repositories.PresetRepository;
import org.dagon1093.irregularverbstraining.services.PastService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PastServiceIpl implements PastService {

    private final ParticipleRepository participleRepository;
    private final PresetRepository presetRepository;
    private final PastRepository pastRepository;

    public PastServiceIpl(ParticipleRepository participleRepository, PresetRepository presetRepository, PastRepository pastRepository) {
        this.participleRepository = participleRepository;
        this.presetRepository = presetRepository;
        this.pastRepository = pastRepository;
    }

    @Override
    public Set<Past> findAll() {
        Set<Past> pastSet = new HashSet<>();
        pastRepository.findAll().forEach(pastSet::add);
        return pastSet;
    }

    @Override
    public Past findById(Long aLong) {
        return pastRepository.findById(aLong).orElse(null);
    }

    @Override
    public Past save(Past object) {
        return pastRepository.save(object);
    }

    @Override
    public void delete(Past object) {
        pastRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        pastRepository.deleteById(aLong);
    }

}
