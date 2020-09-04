package dz.sikkens.scanlib.service;

import dz.sikkens.scanlib.dao.ProduitDAO;
import dz.sikkens.scanlib.model.Produit;
import dz.sikkens.scanlib.model.ProduitDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	private ProduitDAO produitDAO;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Produit saveOrUpdate(@NotNull ProduitDto produitDto) {
		Optional<Produit> produitExist = produitDAO.findProduitByreference(produitDto.getReference());
		if(produitExist.isPresent()) {
			produitExist.get().setQuantite(produitDto.getQuantite() - 1);
			return produitDAO.save(produitExist.get());
		}
		Produit pr = modelMapper.map(produitDto, Produit.class);
		pr.setLocalDate(LocalDate.now());
		return produitDAO.save(pr);
	}

	@Override
	public List<Produit> findAll() {
		return produitDAO.findAll();
	}

	@Override
	public Optional<Produit> findProduitByReference(String reference) {
		return produitDAO.findProduitByreference(reference);
	}

	@Override
	public void delete(ProduitDto produitDto) {
		Optional<Produit> produit = produitDAO.findProduitByreference(produitDto.getReference());
		produitDAO.delete(produit.get());
	}
}
