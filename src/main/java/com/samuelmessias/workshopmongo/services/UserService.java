package com.samuelmessias.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samuelmessias.workshopmongo.models.dto.PostDTO;
import com.samuelmessias.workshopmongo.models.dto.UserDTO;
import com.samuelmessias.workshopmongo.models.entities.User;
import com.samuelmessias.workshopmongo.repositories.UserRepository;
import com.samuelmessias.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	
	public UserDTO findByID(String id) {		
		User entity = getEntityById(id);
		return new UserDTO(entity);
	}
	
	@Transactional(readOnly = true)
	private User getEntityById(String id) {
		Optional<User> obj = repository.findById(id);
		return  obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado!"));		
	}
	
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);		
		entity = repository.insert(entity);
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(String id, UserDTO dto) {
		User entity = getEntityById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	public void delete(String id) {
		getEntityById(id);
		repository.deleteById(id);
	}
	
	public List<PostDTO> getUserPosts(String id){
		User entity = getEntityById(id);
		return entity.getPosts().stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}
	
}
