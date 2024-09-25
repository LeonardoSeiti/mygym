package br.com.fiap.mygym.split;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SplitService {
    private final SplitRepository splitRepository;

    public SplitService(SplitRepository splitRepository){
        this.splitRepository = splitRepository;
    }

    public Page<Split> findAll(Pageable pageable){
        return splitRepository.findAll(pageable);
    }
    public Split create(Split split){
        return splitRepository.save(split);
    }
}
