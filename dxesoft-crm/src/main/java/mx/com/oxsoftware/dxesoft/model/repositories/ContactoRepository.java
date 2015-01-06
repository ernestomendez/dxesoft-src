package mx.com.oxsoftware.dxesoft.model.repositories;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ernesto on 11/12/14.
 */
@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long> {
}
