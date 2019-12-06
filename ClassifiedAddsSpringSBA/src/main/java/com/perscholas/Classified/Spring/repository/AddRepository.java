package com.perscholas.Classified.Spring.repository;
import java.util.List;

import com.perscholas.Classified.Spring.model.Add;

public interface AddRepository {
	List<Add> showAdds();
		Integer addAdd(Add add);
		Boolean removeAdd(Integer Id);
	}

