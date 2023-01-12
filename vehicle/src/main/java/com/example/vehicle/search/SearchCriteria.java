package com.example.vehicle.search;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
	
//	public SearchCriteria(String key, Object value, SearchOperation operation) {
//		super();
//		this.key = key;
//		this.value = value;
//		this.operation = operation;
		
	//}
	public SearchCriteria(String key, SearchOperation operation,Object value) {
		super();
		this.key = key;
		this.value = value;
		this.operation = operation;
	}
	private String key;
	private Object value;
	private SearchOperation operation;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public SearchOperation getOperation() {
		return operation;
	}
	public void setOperation(SearchOperation operation) {
		this.operation = operation;
	}

}