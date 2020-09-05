package dz.sikkens.scanlib.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProduitDto {
	private Integer pkId;
	private String reference;
	private LocalDate localDate;
	private Integer quantite;
	private BigDecimal prix;
	private boolean isNotAddition;
}
