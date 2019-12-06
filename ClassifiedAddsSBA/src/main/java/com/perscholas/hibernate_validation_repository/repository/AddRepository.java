package com.perscholas.hibernate_validation_repository.repository;

import java.util.List;

import com.perscholas.hibernate_validation_repository.models.Add;

public interface AddRepository {

	List<Add> showAdds();
	Integer addAdd(Add add);
	Boolean removeAdd(Integer addId);
	Boolean updateStatusOne(Integer addStatus);
	Boolean updateStatusTwo(Integer addStatus);
	
}
