package pe.edu.vallegrande.inventaStore.service.impl;

import pe.edu.vallegrande.inventaStore.model.SaleDetail;
import pe.edu.vallegrande.inventaStore.repository.SaleDetailRepository;
import pe.edu.vallegrande.inventaStore.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleDetailServiceImpl implements SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;

    @Autowired
    public SaleDetailServiceImpl(SaleDetailRepository saleDetailRepository) {
        this.saleDetailRepository = saleDetailRepository;
    }

    @Override
    public List<SaleDetail> findAll() {
        return saleDetailRepository.findAll();
    }

    @Override
    public Optional<SaleDetail> findById(Long identifier) {
        return saleDetailRepository.findById(identifier);
    }

    @Override
    public SaleDetail save(SaleDetail saleDetail) {
        return saleDetailRepository.save(saleDetail);
    }
}
