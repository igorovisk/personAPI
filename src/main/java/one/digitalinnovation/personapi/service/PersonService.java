package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE; // constante INSTANCE criada na interface PersonMapper

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personMapper.toModel(personDTO);
        return createMethodResponse(savedPerson.getId(), "Created person with ID ");
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personMapper.toModel(personDTO);
        return createMethodResponse(updatedPerson.getId(), "Updated person with ID ");
    }
    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
    private MessageResponseDTO createMethodResponse(Long id, String message) {
        return MessageResponseDTO.builder().message(message +id).build();
    }
}
