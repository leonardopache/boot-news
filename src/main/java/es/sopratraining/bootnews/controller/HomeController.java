package es.sopratraining.bootnews.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.sopratraining.bootnews.model.News;
import es.sopratraining.bootnews.repository.NewsRepository;

@RestController
@ControllerAdvice
public class HomeController {

	@Autowired
	private NewsRepository newsRepository;

	@RequestMapping("/")
	public String helloWorld() {
		return "Hello Sopra";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "";
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public Iterable<News> getAllNews() {
		return newsRepository.findAll();
	}

	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public void postNews(@Valid @RequestBody News post) throws RuntimeException {
		try {
			newsRepository.save(post);
		} catch (Exception e) {
			throw new RuntimeException("not today!!");
		}
	}
}
