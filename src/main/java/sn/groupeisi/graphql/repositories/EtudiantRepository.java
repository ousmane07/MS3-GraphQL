package sn.groupeisi.graphql.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import sn.groupeisi.graphql.models.Etudiant;

public interface EtudiantRepository extends MongoRepository<Etudiant,String> {
}
