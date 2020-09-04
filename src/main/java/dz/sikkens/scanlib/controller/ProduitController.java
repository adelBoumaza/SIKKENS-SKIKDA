package dz.sikkens.scanlib.controller;

import dz.sikkens.scanlib.model.Produit;
import dz.sikkens.scanlib.model.ProduitDto;
import dz.sikkens.scanlib.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public List<Produit> findByReference(@PathVariable("reference") String reference) {
		return produitService.findAll();
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
