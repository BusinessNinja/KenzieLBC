package com.kenzie.appserver.repositories;

import com.kenzie.appserver.repositories.model.GameEntity;
import com.kenzie.appserver.repositories.model.GamePrimaryKey;
import org.springframework.data.repository.CrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface GameRepository extends CrudRepository<GameEntity, GamePrimaryKey> {
}
