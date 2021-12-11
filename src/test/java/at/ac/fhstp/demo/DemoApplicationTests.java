package at.ac.fhstp.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@Mock 
	PupdateEntity pupdate;
	@Mock
	PupdateRepository pupdateRepository;
	@Test
	void contextLoads() {
	}
	

	@Test
	public void TestFetchPupdates(){
		assertNotNull(pupdate);
		List<PupdateEntity> pupdates =pupdateRepository.findPupdatesbySniffer(1);
		assertNotNull(pupdates);
		
	}

}
 