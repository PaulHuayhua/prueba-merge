package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.BuysDetail;
import pe.edu.vallegrande.inventaStore.service.BuysDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/buys-detail")
public class BuysDetailRest {

    private final BuysDetailService buysDetailService;

    @Autowired
    public BuysDetailRest(BuysDetailService buysDetailService) {
        this.buysDetailService = buysDetailService;
    }

    @GetMapping
    public List<BuysDetail> findAll() {
        return buysDetailService.findAll();
    }

    @GetMapping("/{identifier}")
    public Optional<BuysDetail> findById(@PathVariable Long identifier) {
        return buysDetailService.findById(identifier);
    }

    @PostMapping("/save")
    public BuysDetail save(@RequestBody BuysDetail buysDetail) {
        return buysDetailService.save(buysDetail);
    }

    // Agrega métodos update o delete solo si los necesitas
}
