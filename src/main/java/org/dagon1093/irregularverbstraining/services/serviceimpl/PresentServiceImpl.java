package org.dagon1093.irregularverbstraining.services.serviceimpl;


import org.dagon1093.irregularverbstraining.model.Present;
import org.dagon1093.irregularverbstraining.repositories.ParticipleRepository;
import org.dagon1093.irregularverbstraining.repositories.PastRepository;
import org.dagon1093.irregularverbstraining.repositories.PresetRepository;
import org.dagon1093.irregularverbstraining.services.PresentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PresentServiceImpl implements PresentService {

    private final ParticipleRepository participleRepository;
    private final PresetRepository presetRepository;
    private final PastRepository pastRepository;

    public PresentServiceImpl(ParticipleRepository participleRepository, PresetRepository presetRepository, PastRepository pastRepository) {
        this.participleRepository = participleRepository;
        this.presetRepository = presetRepository;
        this.pastRepository = pastRepository;
    }

    @Override
    public Set<Present> findAll() {
        Set<Present> presentSet = new HashSet<>();
        presetRepository.findAll().forEach(presentSet::add);
        return presentSet;
    }

    @Override
    public Present findById(Long aLong) {
        return presetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Present save(Present object) {
        return presetRepository.save(object);
    }

    @Override
    public void delete(Present object) {
        presetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        presetRepository.deleteById(aLong);
    }


}
