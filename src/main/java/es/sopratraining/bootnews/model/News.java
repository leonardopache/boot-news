package es.sopratraining.bootnews.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class News {
	private String id, author, title, msg;

	public News() {
	}

	public News(String author, String title, String msg) {
		this.author = author;
		this.title = title;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", author=" + author + ", title=" + title + ", msg=" + msg + "]";
	}

}
