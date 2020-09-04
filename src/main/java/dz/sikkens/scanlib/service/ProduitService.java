package dz.sikkens.scanlib.service;

import dz.sikkens.scanlib.model.Produit;
import dz.sikkens.scanlib.model.ProduitDto;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
	Produit saveOrUpdate(ProduitDto produitDto);
	List<Produit> findAll();
	Optional<Produit> findProduitByReference(String reference);
	void delete(ProduitDto produitDto);
}
