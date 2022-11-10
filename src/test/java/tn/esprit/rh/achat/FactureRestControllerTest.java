package tn.esprit.rh.achat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.controllers.FactureRestController;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.IFactureService;

@RunWith(SpringRunner.class)
@WebMvcTest(FactureRestController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@Slf4j
public class FactureRestControllerTest {
	
	//@InjectMocks
	//private FactureRestController factureController = new FactureRestController();
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	FactureServiceImpl factureService;
	   Boolean True;
	@InjectMocks
	 Facture ps;
	@Autowired
	IFactureService us;
	@Mock
	FactureRepository factureRepo;
	@Mock 
	IFactureService factureserviceinterface;
	
	
	
	
	   
	   
	
	 @Test
	 public void create()  {
	     Facture f = new Facture();
	     f.setMontantFacture(5);
		 when(factureService.addFacture(f)).thenReturn(f);
		 Facture created = factureService.addFacture(f);
		 assertEquals(created.getMontantFacture(),f.getMontantFacture(),5);
		 verify(factureService).addFacture(f);
		 	 
	
	 }
	 @Test
	 public void assign() {
		 FactureRestController fct = new FactureRestController();
		 float response =fct.pourcentageRecouvrement(null, null);
		 assertEquals((float)5,response,5);
	 }

	 @Test
	 @Order(1)
	 public void testUser()  {
		 
		 List<Facture> facturejs = us.retrieveAllFactures();
		 Assertions.assertEquals(0, facturejs.size());
		 
	 }
	 
	 //@Test
	 //@Order(3)
	 //public void deleTest() {
//		 Mockito.when(factureRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
	//	 List<Facture> facture = factureService.retrieveAllFactures();
		 
		// Facture facture1 = factureService.addFacture(f);
		// List<Facture> facture7 = factureService.retrieveAllFactures();
			
	//	 assertEquals(facture,facture7);
//		 log.info("get ===>" + facture1+"facture2"+facture7);
	//	 verify(factureRepo).findById(Mockito.anyLong());
	// }
	// @Test
	// @Order(3)
	// public void deleteTest() {
	//	 Mockito.when(factureRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
	//	 factureService.retrieveFacture(f.getIdFacture());
	 //     assertNotSame(new Facture(),new Produit());
	       
	//	 log.info("get ===>" );
	//	 verify(factureRepo).findById(Mockito.anyLong());
	// }
	 
	 
	 @Test
	 public void deleteTest() {
		// Facture ps=Mockito.mock(Facture.class);
		// Facture ps = new Facture();
		 ps.setMontantRemise(3);
//		 Mockito.when(factureRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(ps));
	//	 Mockito.when(factureRepo.save(ArgumentMatchers.any(Facture.class))).thenReturn(ps);
		 Mockito.when(factureRepo.save(ps)).thenReturn(ps);
			
		 Facture fact = factureService.addFacture(ps);
	      //assertNotSame(new Facture(),new Produit());
	       
		 log.info("get ===>" );
	
		 verify(factureService).addFacture(ps);
	 }
	
	
	
	
	    

}
