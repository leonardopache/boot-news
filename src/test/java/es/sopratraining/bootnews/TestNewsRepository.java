package es.sopratraining.bootnews;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.sopratraining.bootnews.model.News;
import es.sopratraining.bootnews.repository.NewsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestNewsRepository {

	@Autowired
	private NewsRepository newsRepository;
	
	@Before
	public void setup() {
		newsRepository.findAll().stream().forEach(i -> System.out.println("Element ======>  "+ i));
	}
	
	@After
	public void cleanDB() {
		newsRepository.deleteAll();
	}

	@Test
	public void newsSave() {
		try {
			newsRepository.save(getOneNewsMocked());
			assertThat(!newsRepository.findAll().isEmpty());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void newsUpdate() {
		try {
			News news = newsRepository.save(getOneNewsMocked());
			String time = String.valueOf(new Date().getTime());
			news.setAuthor(time);
			newsRepository.save(news);
			assertThat(newsRepository.findById(news.getId()).get().getAuthor().equals(time));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void newsFind() {
		try {
			News news = newsRepository.save(getOneNewsMocked());
			assertThat(newsRepository.findById(news.getId()).isPresent());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void newsDelete() {
		try {
			News news = newsRepository.save(getOneNewsMocked());
			newsRepository.delete(news);
			assertThat(newsRepository.findAll().isEmpty());
		} catch (Exception e) {
			fail();
		}
	}

	private News getOneNewsMocked() {
		return new News("author", "title", "msg");
	}
}
