package io.springboot.junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import io.springboot.junit.helper.BookDetailsHelper;
import io.springboot.junit.repo.ILibraryBookDao;
import io.springboot.junit.service.ILibraryBookService;
import io.springboot.junit.service.LibraryBookService;

@RunWith(MockitoJUnitRunner.class)
public class TestLibraryBookService {

	@Mock
	private ILibraryBookDao mockDao;
	
	@InjectMocks
	ILibraryBookService service=new LibraryBookService();
	
	@Before
	public void setUp() {
		Mockito.when(mockDao.getAllBooks()).thenReturn(BookDetailsHelper.getBooks());
	}
	
	@Test
	public void testFindAllBooks() {
		assertTrue(service.findAllBooks().size()==3);
	}

}
