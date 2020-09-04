package dz.sikkens.scanlib.dao;

import dz.sikkens.scanlib.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProduitDAO extends JpaRepository<Produit, Integer> {

	@Query("From Produit p where p.reference = :reference")
	Optional<Produit> findProduitByreference(String reference);
}
