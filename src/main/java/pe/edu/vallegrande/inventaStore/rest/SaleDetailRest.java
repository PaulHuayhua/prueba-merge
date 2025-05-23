package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.SaleDetail;
import pe.edu.vallegrande.inventaStore.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/saledetail")
public class SaleDetailRest {

    private final SaleDetailService saleDetailService;

    @Autowired
    public SaleDetailRest(SaleDetailService saleDetailService) {
        this.saleDetailService = saleDetailService;
    }

    @GetMapping
    public List<SaleDetail> findAll() {
        return saleDetailService.findAll();
    }

    @GetMapping("/{identifier}")
    public Optional<SaleDetail> findById(@PathVariable Long identifier) {
        return saleDetailService.findById(identifier);
    }

    @PostMapping("/save")
    public SaleDetail save(@RequestBody SaleDetail saleDetail) {
        return saleDetailService.save(saleDetail);
    }

}
