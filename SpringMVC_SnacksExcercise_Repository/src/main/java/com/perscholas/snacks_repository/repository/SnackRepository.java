package com.perscholas.snacks_repository.repository;

import java.util.List;

import com.perscholas.snacks_repository.model.Snacks;

public interface SnackRepository {
	List<Snacks> showSnacks();
	Integer addSnack(Snacks snacks);
	Boolean removeSnack(Integer snacksid);
}
