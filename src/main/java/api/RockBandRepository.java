package main.java.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import main.java.api.RockBand;

@RepositoryRestResource(collectionResourceRel = "rockBand", path = "rockBand")
public interface RockBandRepository extends MongoRepository<RockBand, String> {

}
