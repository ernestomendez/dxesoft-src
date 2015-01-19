package mx.com.oxsoftware.dxesoft.service.contact;

import com.google.common.base.Preconditions;
import mx.com.oxsoftware.dxesoft.model.entities.contact.Contact;
import mx.com.oxsoftware.dxesoft.model.repositories.ContactRepository;
import mx.com.oxsoftware.dxesoft.utils.DxesoftUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void createContact(Contact contact) {
        LOGGER.debug("CreateContact");
        Preconditions.checkNotNull(contact);
        contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(long id) {
        LOGGER.debug("deleteContactById");
        Preconditions.checkArgument(DxesoftUtils.isValidId(id), "contactId has to be greater than 0");
        contactRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Contact> findAll(Integer pageNumber) {
        LOGGER.debug("contact findAll");
        PageRequest pageRequest = new PageRequest(pageNumber -1, 50);
        return contactRepository.findAll(pageRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        LOGGER.debug("contact findAll");
//        PageRequest pageRequest = new PageRequest(pageNumber -1, 50);
        return contactRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        LOGGER.debug("findById");
        return contactRepository.findOne(id);
    }

    @Override
    public void update(Contact contact) throws Exception {
        LOGGER.debug("update");
        Preconditions.checkNotNull(contact);

        if (contactRepository.exists(contact.getId())) {
            throw new Exception("alsdkfj");
        } else {
            contactRepository.save(contact);
        }
    }
}
