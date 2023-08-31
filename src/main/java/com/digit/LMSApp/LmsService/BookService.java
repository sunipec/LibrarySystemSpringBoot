package com.digit.LMSApp.LmsService;

import java.util.List;

import com.digit.LMSApp.Payload.BookDto;

public interface BookService {
	String addBook(BookDto bdto);

	String getSpecificBook(int bid);

	BookDto updateBook(BookDto bdto, int bid);

	String deleteBook(int bid);

	List<BookDto> getAll();

	String addBookAll(List<BookDto> bdto);

}