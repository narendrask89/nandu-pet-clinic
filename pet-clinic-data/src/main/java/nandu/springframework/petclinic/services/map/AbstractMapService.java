package nandu.springframework.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import nandu.springframework.petclinic.model.BaseEntity;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

	private Map<Long, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		}
		return object;
	}

	public void deleteById(ID id) {
		map.remove(id);
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	public Long getNextId() {
		Long nextId = null;
		try {
			nextId = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			nextId = 1L;
		}
		return nextId;
	}
}
