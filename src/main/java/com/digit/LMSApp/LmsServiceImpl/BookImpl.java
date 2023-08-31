package com.digit.LMSApp.LmsServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.LMSApp.Entity.Book;
import com.digit.LMSApp.LmsService.BookService;
import com.digit.LMSApp.Payload.BookDto;
import com.digit.LMSApp.Repository.BookRepository;

@Service
public class BookImpl implements BookService {
	@Autowired

	private BookRepository brepo;


	@Override
	public String addBook(BookDto bdto) {
		
		// TODO Auto-generated method stub
			
		if(bdto.getBname()!=null && bdto.getBname()!="") {
			
		Book b = new Book();
		b.setBname(bdto.getBname());
		b.setAuthor(bdto.getAuthor());
		b.setCost(bdto.getCost());
		Book bk = brepo.save(b);
		BookDto bookresponse = new BookDto();
		bookresponse.setBname(bk.getBname());
		bookresponse.setAuthor(bk.getAuthor());
		bookresponse.setCost(bk.getCost());

		return "Book Added Successfully";
		}
		else if(bdto.getBname()==null && bdto.getBname()=="") {
			return "Book Not Found";
		}
		else {
			return "Other data not found";
		}
		
//		return "Something Wrong";
		
	}
	
	@Override
	public String addBookAll(List<BookDto> bdtoList) {
		
		// TODO Auto-generated method stub
		List<Book> bookList=new ArrayList<Book>();
		for (BookDto bookDto : bdtoList) {
			if(bookDto.getBname()==null || bookDto.getBname()=="") {
				return "data is not correct";
			}
			Book b = new Book();
			b.setBname(bookDto.getBname());
			b.setAuthor(bookDto.getAuthor());
			b.setCost(bookDto.getCost());
			bookList.add(b);
		}
		brepo.saveAll(bookList);
		return "all books are added";
			
	
		
	}

	@Override
	public String getSpecificBook(int bid) {
		// TODO Auto-generated method stub
		Book b = brepo.findById(bid).orElse(null);
		
		if(b==null) {
			return "No Book is present ";
		}
		
		BookDto bookresponse = new BookDto();
		bookresponse.setBid(b.getBid());
		bookresponse.setBname(b.getBname());
		bookresponse.setAuthor(b.getAuthor());
		bookresponse.setCost(b.getCost());

		return "Book Added Successfully";
	}

	@Override
	public BookDto updateBook(BookDto bdto,int bid) {
		// TODO Auto-generated method stub
		Book b = brepo.findById(bid).orElse(null);
		
		//b.setBid(bdto.getBid());
		b.setBname(bdto.getBname());
		b.setAuthor(bdto.getAuthor());
		b.setCost(bdto.getCost());
		brepo.save(b);
		BookDto bookDto = new BookDto();
		bookDto.setBid(b.getBid());
		bookDto.setBname(b.getBname());
		bookDto.setAuthor(b.getAuthor());
		bookDto.setCost(b.getCost());
		return bookDto;
	}

	@Override
	public String deleteBook(int bid) {
		// TODO Auto-generated method stub
		brepo.deleteById(bid);

		return "Deleted Successfully";

	}

	@Override
	public List<BookDto> getAll() {
		// TODO Auto-generated method stub
		List<Book> b = brepo.findAll();
		List<BookDto> bd = new ArrayList<BookDto>();
		for (Book book : b) {
			BookDto bdto = new BookDto();
			bdto.setBid(book.getBid());
			bdto.setBname(book.getBname());
			bdto.setAuthor(book.getAuthor());
			bdto.setCost(book.getCost());
			bd.add(bdto);
		}
		return bd;
	}
	
	
	

}
