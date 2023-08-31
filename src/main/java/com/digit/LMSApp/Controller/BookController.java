package com.digit.LMSApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digit.LMSApp.Entity.Book;
import com.digit.LMSApp.LmsService.BookService;
import com.digit.LMSApp.Payload.BookDto;

@RestController
@RequestMapping("/Library")
public class BookController {
	@Autowired
	BookService bookService;

	@PostMapping

	public ResponseEntity<String> addBook(@RequestBody BookDto bdto) {

		return new ResponseEntity<>(bookService.addBook(bdto), HttpStatus.CREATED);

	}
	
	@PostMapping("/all")

	public ResponseEntity<String> addBookall(@RequestBody List<BookDto> bdtoList) {

		return new ResponseEntity<>(bookService.addBookAll(bdtoList), HttpStatus.CREATED);

	}

	@GetMapping("getById/{bid}")

	public ResponseEntity<String> getSpecificPost(@PathVariable int bid) {

		return new ResponseEntity<>(bookService.getSpecificBook(bid), HttpStatus.CREATED);

	}

	@PutMapping("update/{bid}")
	public ResponseEntity<BookDto> updatePost(@RequestBody BookDto bdto, @PathVariable("bid") int bid) {

		return new ResponseEntity<>(bookService.updateBook(bdto,bid), HttpStatus.CREATED);

	}

	@DeleteMapping("delete/{bid}")
	public ResponseEntity<String> deleteBook(@PathVariable int bid) {
		return new ResponseEntity<>(bookService.deleteBook(bid), HttpStatus.CREATED);

	}

	@GetMapping("getbook")
	public ResponseEntity<List<BookDto>> getAll() {

		return new ResponseEntity<>(bookService.getAll(), HttpStatus.CREATED);

	}

}
