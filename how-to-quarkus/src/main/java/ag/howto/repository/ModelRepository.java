package ag.howto.repository;

import ag.howto.entity.Model;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ModelRepository implements PanacheRepository<Model> {

    public List<Model> getModels() {
        return findAll().stream().collect(Collectors.toList());
    }

}
