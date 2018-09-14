package adam.magazyn.service;

import adam.magazyn.entity.Czesci;
import adam.magazyn.repository.CzesciRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CzesciService {

    private final CzesciRepository czesciRepository;

    public CzesciService(CzesciRepository czesciRepository) {
        this.czesciRepository = czesciRepository;
    }

    public Czesci save(Czesci czesci) {
        return czesciRepository.save(czesci);
    }

    public Czesci findOne(Long id) {
        return czesciRepository.findOne(id);
    }

    public void delete(Long id) {
        czesciRepository.delete(id);
    }

    public List<Czesci> findAll() {
        return czesciRepository.findAll();
    }


}
