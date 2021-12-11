package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnifferService {
    @Autowired
    private SnifferRepository snifferRepository;

    public List<SnifferEntity> fetchSniffers() {
        List<SnifferEntity> sniffers = new ArrayList<>();

        Iterable<SnifferEntity> all = snifferRepository.findAll();
        all.forEach(sniffers::add);

        return sniffers;
    }

    public void savesniffers(List<SnifferEntity> sniffers) {
        snifferRepository.saveAll(sniffers);
    }

    public void postsniffer(SnifferEntity sniffer) {
        snifferRepository.save(sniffer);
    }

    public SnifferEntity getSniffer(int snifferID) {
        Optional<SnifferEntity> sniffer = snifferRepository.findById(snifferID);
        if (sniffer.isEmpty())
            return null;

        return sniffer.get();

    }

    public boolean existsByID(int id) {
        return snifferRepository.existsById(id);
    }

}
