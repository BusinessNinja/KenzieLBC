package com.kenzie.appserver.repositories;


import com.kenzie.appserver.repositories.model.GamePrimaryKey;
import com.kenzie.appserver.repositories.model.GameRecord;
import org.springframework.data.repository.CrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface GameRepository extends CrudRepository<GameRecord, GamePrimaryKey> {
}
