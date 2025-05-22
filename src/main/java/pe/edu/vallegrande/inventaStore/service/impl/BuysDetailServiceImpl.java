package pe.edu.vallegrande.inventaStore.service.impl;

import pe.edu.vallegrande.inventaStore.model.BuysDetail;
import pe.edu.vallegrande.inventaStore.repository.BuysDetailRepository;
import pe.edu.vallegrande.inventaStore.service.BuysDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuysDetailServiceImpl implements BuysDetailService {

    private final BuysDetailRepository buysDetailRepository;

    @Autowired
    public BuysDetailServiceImpl(BuysDetailRepository buysDetailRepository) {
        this.buysDetailRepository = buysDetailRepository;
    }

    @Override
    public List<BuysDetail> findAll() {
        return buysDetailRepository.findAll();
    }

    @Override
    public Optional<BuysDetail> findById(Long identifier) {
        return buysDetailRepository.findById(identifier);
    }

    @Override
    public BuysDetail save(BuysDetail buysDetail) {
        return buysDetailRepository.save(buysDetail);
    }
}
