package dz.sikkens.scanlib.controller;

import dz.sikkens.scanlib.model.Produit;
import dz.sikkens.scanlib.model.ProduitDto;
import dz.sikkens.scanlib.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class ProduitController {

	@Autowired
	private ProduitService produitService;


	@GetMapping("produit/all")
	public List<Produit> findAll() {
		return produitService.findAll();
	}

	@GetMapping("produit/{reference}")
	public Optional<Produit> findByReference(@PathVariable("reference") String reference) {
		return produitService.findProduitByReference(reference);
	}

	@PostMapping("produit/saveOrUpdate")
	public Produit saveOrUpdate(@RequestBody ProduitDto produit) {
		return produitService.saveOrUpdate(produit);
	}

	@DeleteMapping("produit/delete")
	public void delete(@RequestBody ProduitDto produit) {
		produitService.delete(produit);
	}
}
