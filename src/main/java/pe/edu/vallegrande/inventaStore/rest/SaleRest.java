package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.Sale;
import pe.edu.vallegrande.inventaStore.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/sale")
public class SaleRest {

    private final SaleService saleService;

    @Autowired
    public SaleRest(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<Sale> findAll() {
        return saleService.findAll();
    }

    @GetMapping("/{identifier}")
    public Optional<Sale> findById(@PathVariable Long identifier) {
        return saleService.findById(identifier);
    }

    @PostMapping("/save")
    public Sale save(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

}
