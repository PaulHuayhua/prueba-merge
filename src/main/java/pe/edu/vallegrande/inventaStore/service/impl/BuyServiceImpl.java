package pe.edu.vallegrande.inventaStore.service.impl;

import pe.edu.vallegrande.inventaStore.model.Buy;
import pe.edu.vallegrande.inventaStore.repository.BuyRepository;
import pe.edu.vallegrande.inventaStore.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyServiceImpl implements BuyService {

    private final BuyRepository buyRepository;

    @Autowired
    public BuyServiceImpl(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    @Override
    public List<Buy> findAll() {
        return buyRepository.findAll();
    }

    @Override
    public Optional<Buy> findById(Long identifier) {
        return buyRepository.findById(identifier);
    }

    @Override
    public Buy save(Buy buy) {
        return buyRepository.save(buy);
    }
}
