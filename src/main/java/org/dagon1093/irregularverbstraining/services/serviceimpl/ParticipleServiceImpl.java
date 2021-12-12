package org.dagon1093.irregularverbstraining.services.serviceimpl;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.model.Present;
import org.dagon1093.irregularverbstraining.repositories.ParticipleRepository;
import org.dagon1093.irregularverbstraining.repositories.PastRepository;
import org.dagon1093.irregularverbstraining.repositories.PresetRepository;
import org.dagon1093.irregularverbstraining.services.ParticipleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ParticipleServiceImpl implements ParticipleService {

    private final ParticipleRepository participleRepository;
    private final PresetRepository presetRepository;
    private final PastRepository pastRepository;

    public ParticipleServiceImpl(ParticipleRepository participleRepository, PresetRepository presetRepository, PastRepository pastRepository) {
        this.participleRepository = participleRepository;
        this.presetRepository = presetRepository;
        this.pastRepository = pastRepository;
    }

    @Override
    public Set<Participle> findAll() {
        Set<Participle> participleSet = new HashSet<>();
        participleRepository.findAll().forEach(participleSet::add);
        return participleSet;
    }

    @Override
    public Participle findById(Long aLong) {
        return participleRepository.findById(aLong).orElse(null);
    }

    @Override
    public Participle save(Participle object) {
        return participleRepository.save(object);
    }

    @Override
    public void delete(Participle object) {
        participleRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        participleRepository.deleteById(aLong);
    }

}
