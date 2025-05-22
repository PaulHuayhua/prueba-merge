package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.Buy;
import pe.edu.vallegrande.inventaStore.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/buy")
public class BuyRest {

    private final BuyService buyService;

    @Autowired
    public BuyRest(BuyService buyService) {
        this.buyService = buyService;
    }

    @GetMapping
    public List<Buy> findAll() {
        return buyService.findAll();
    }

    @GetMapping("/{identifier}")
    public Optional<Buy> findById(@PathVariable Long identifier) {
        return buyService.findById(identifier);
    }

    @PostMapping("/save")
    public Buy save(@RequestBody Buy buy) {
        return buyService.save(buy);
    }

    // Agrega métodos update o delete solo si realmente los necesitas

}
