package pe.edu.vallegrande.inventaStore.service.impl;

import pe.edu.vallegrande.inventaStore.model.Buy;
import pe.edu.vallegrande.inventaStore.repository.BuyRepository;
import pe.edu.vallegrande.inventaStore.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    @Override
    public Buy update(Buy buy) {
        if (buy.getIdentifier() == null || !buyRepository.existsById(buy.getIdentifier())) {
            throw new RuntimeException("La compra con identificador " + buy.getIdentifier() + " no existe");
        }
        return buyRepository.save(buy);
    }

}
