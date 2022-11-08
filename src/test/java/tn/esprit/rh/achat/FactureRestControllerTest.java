package tn.esprit.rh.achat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.rh.achat.controllers.FactureRestController;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;

@RunWith(SpringRunner.class)
@WebMvcTest(FactureRestController.class)

@AutoConfigureMockMvc
public class FactureRestControllerTest {
	
	@InjectMocks
	private FactureRestController factureController = new FactureRestController();
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	IFactureService factureService;
	   Boolean True;
	@Mock
	private Facture facture;
	   
	   
	 @Test
	 public void  InsertFactures() throws Exception {
	 factureService.retrieveAllFactures();
		 System.out.println("jjjj");
		 
		 Facture facture2 = new Facture();
		 Mockito.when(facture2.getFournisseur().equals(null)).thenReturn(True);
	       
	    }
	
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
	
	
	
	    

}
