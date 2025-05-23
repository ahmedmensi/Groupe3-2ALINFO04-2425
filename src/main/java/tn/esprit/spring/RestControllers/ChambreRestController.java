package tn.esprit.spring.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.TypeChambre;
import tn.esprit.spring.Services.Chambre.IChambreService;

import java.util.List;

@RestController
@RequestMapping("chambre")
@AllArgsConstructor
public class ChambreRestController {

    private final IChambreService service;

    @PostMapping("addOrUpdate")
    public Chambre addOrUpdate(@RequestBody Chambre c) {
        return service.addOrUpdate(c);
    }

    @GetMapping("findAll")
    public List<Chambre> findAll() {
        return service.findAll();
    }

    @GetMapping("findById")
    public Chambre findById(@RequestParam long id) {
        return service.findById(id);
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody Chambre c) {
        service.delete(c);
    }

    @DeleteMapping("deleteById")
    public void deleteById(@RequestParam long id) {
        service.deleteById(id);
    }

    @GetMapping("getChambresParNomBloc")
    public List<Chambre> getChambresParNomBloc(@RequestParam String nomBloc) {
        return service.getChambresParNomBloc(nomBloc);
    }

    @GetMapping("nbChambreParTypeEtBloc")
    public long nbChambreParTypeEtBloc(@RequestParam TypeChambre type, @RequestParam long idBloc) {
        return service.nbChambreParTypeEtBloc(type, idBloc);
    }

    @GetMapping("getChambresNonReserveParNomFoyerEtTypeChambre")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@RequestParam String nomFoyer, @RequestParam TypeChambre type) {
        return service.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer, type);
    }
}
