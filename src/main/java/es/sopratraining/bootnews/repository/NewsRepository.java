package es.sopratraining.bootnews.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.sopratraining.bootnews.model.News;

public interface NewsRepository extends MongoRepository<News, String>{

}
