package sn.groupeisi.graphql.resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sn.groupeisi.graphql.models.Etudiant;
import sn.groupeisi.graphql.repositories.EtudiantRepository;


@Controller
public class EtudiantQueryResolver   {

    private final EtudiantRepository studentRepository;


    public EtudiantQueryResolver(EtudiantRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @QueryMapping
    public Etudiant student(String id) {
        return studentRepository.findById(id).orElse(null);
    }
    @QueryMapping

    public Iterable<Etudiant> students() {
        return studentRepository.findAll();
    }

    @QueryMapping
    public long studentCount() {
        return studentRepository.count();
    }
    @MutationMapping
    public Etudiant createEtudiant(@Argument String nom, @Argument int age) {
        Etudiant student = new Etudiant();
        student.setNom(nom);
        student.setAge(age);
        return studentRepository.save(student);
    }
}