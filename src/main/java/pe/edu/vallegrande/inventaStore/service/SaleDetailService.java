package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.SaleDetail;

import java.util.List;
import java.util.Optional;

public interface SaleDetailService {

    List<SaleDetail> findAll();

    Optional<SaleDetail> findById(Long identifier);

    SaleDetail save(SaleDetail saleDetail);
}
