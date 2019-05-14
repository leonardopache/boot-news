package es.sopratraining.bootnews;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.sopratraining.bootnews.controller.HomeController;
import es.sopratraining.bootnews.model.News;
import es.sopratraining.bootnews.repository.NewsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestNewsController {

	@Autowired
	private HomeController homeController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	NewsRepository newsRepository;

	@Test
	public void testHelloWorld() {
		assertThat(homeController).isNotNull();
	}

	@Test
	public void testContentController() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("Hello Sopra"));
	}

	@Test
	public void testGETAllNews() throws Exception {
		Mockito.when(newsRepository.findAll()).thenReturn(getNewsMocked());

		this.mockMvc.perform(get("/news")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testPOSTNewsFail() throws Exception {
		Mockito.when(newsRepository.findAll()).thenThrow(new RuntimeException());

		this.mockMvc.perform(post("/news")).andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	public void testPOSTNews() throws Exception {
		Mockito.when(newsRepository.save((News) Matchers.any(Object.class))).thenReturn(getOneNewsMocked());

		this.mockMvc.perform(post("/news")).andDo(print()).andExpect(status().is4xxClientError());
	}

	private List<News> getNewsMocked() {
		List<News> list = new ArrayList<>();
		News news = new News("Leonardo", "News Title", "msg");
		list.add(news);
		return list;
	}

	private News getOneNewsMocked() {
		return new News("author", "title", "msg");
	}
}
