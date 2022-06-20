package web2022.service;

import java.util.ArrayList;

import web2022.dto.TestDTO;
import web2022.model.Test;
import web2022.repository.TestRepository;

public class TestService {
	
	private TestRepository testRepository;
		
	public TestService() {
		this.testRepository = new TestRepository();
	}
	
	public ArrayList<Test> getAll() {
		 ArrayList<Test> testovi = testRepository.getAll();
		 return testovi;
	}
	
	public Test addTest(TestDTO testDTO) {
//		Test test = new Test(testDTO);
		Test test = new Test();
		test.setId(System.currentTimeMillis());
		test.setDeleted(false);
		test.setName("Test " + getAll().size());
		test.setUser(testDTO.getUser());
		test.getUser().setId(System.currentTimeMillis());
		testRepository.add(test);
		return test;
	}
	
	public Test updateTest(TestDTO testDTO) {
		if(testDTO == null) {
			return null;
		}
		Test test = testRepository.getById(testDTO.getId());
		if(test == null) {
			return null;
		}
		test.setDeleted(testDTO.isDeleted());
		test.setName(testDTO.getName());
		test.setUser(testDTO.getUser());
		testRepository.update(test);
		return test;
	}
	
	public Test deleteTest(Long id) {
		Test test = testRepository.getById(id);
		if(test == null) {
			return null;
		}
		test.setDeleted(true);
		testRepository.update(test);
		return test;
	}
	
}
