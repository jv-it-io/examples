package be.jnn.training.pluralsight.resttemplate.repository;

import be.jnn.training.pluralsight.resttemplate.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
