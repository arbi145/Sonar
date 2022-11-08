package tn.esprit.rh.achat;


import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ProduitTest{
	

	@Mock
	private ProduitRepository produitRepository;
	
	@InjectMocks
	private ProduitServiceImpl produitService;
	
	@Mock
	private StockRepository stockRepository;
	
	@InjectMocks
	private StockServiceImpl stockService;
	
	//NewProject
	
	
	
	@Test
	public void addProduitTest() {
		
		Produit p = new Produit();
		p.setCodeProduit("123");
		p.setLibelleProduit("Bread");
		p.setPrix(2000);
		p.setDateCreation(new Date());
		p.setDateDerniereModification(new Date());
		
		when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(p);
		Produit created = produitService.addProduit(p);
		assertSame(created, p);
		verify(produitRepository).save(p);
		
	}
	

	
	
	
		


		
		
	}


